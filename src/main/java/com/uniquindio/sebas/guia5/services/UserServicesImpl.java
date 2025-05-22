package com.uniquindio.sebas.guia5.services;

import ch.qos.logback.classic.Logger;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.uniquindio.sebas.guia5.doamin.User;
import com.uniquindio.sebas.guia5.doamin.UserStatus;
import com.uniquindio.sebas.guia5.dtos.UserRegistration;
import com.uniquindio.sebas.guia5.dtos.UserResponse;
import com.uniquindio.sebas.guia5.exceptions.ValueConflictExceptions;
import com.uniquindio.sebas.guia5.mappers.UserMapper;

import com.uniquindio.sebas.guia5.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import com.sendgrid.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor   // thanks to this sentences lombok , it will generate a constructor with final attributes

public class UserServicesImpl implements UserServices{
    /**
     * EN ESTA CLASE SE DEBE IMPLEMENTAR LA INSTERFAZ DEFINIDA PARA LOS SERVICIOS DE USUARIO EN
     * UserServices
     */
    private final Map<String, User> userStore = new ConcurrentHashMap<>(); //almacen de memoria para usuarios para manejar concurrencia
    private final UserMapper userMapper;                                    // si hay problemas en la bd datos con el user, es por que pide que el id de la entidad sea long y no string
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private static final Logger logger = (Logger) LoggerFactory.getLogger(UserServicesImpl.class);

    @Value("${spring.sendgrid.api-key}")
    private String sendGridApiKey;

    @Value("${spring.sendgrid.sender-email}")
    private  String mailFrom;


    @Override
    public UserResponse createUser(UserRegistration user) {
        if (userRepository.findUserByEmail(user.email()).isPresent())
        {   throw new ValueConflictExceptions("el email ya esta registrado"); }
            var newUser = userMapper.parseOf(user);
            // añadiendo nuevals lineas para la logica de activacion de cuentas
            newUser.setId(java.util.UUID.randomUUID().toString());
            newUser.setPassword(passwordEncoder.encode(user.password()));
            newUser.setActivo(false);
            newUser.setActivationCode(java.util.UUID.randomUUID().toString());
            newUser.setStateUser(UserStatus.PENDING_ACTIVATION); // Estado temporal mientras se activa la cuenta

            userStore.put(newUser.getId(), newUser); // solamente para la concurrencia basica
            sendActivationEmail(newUser);
            userRepository.save(newUser); // guardar el usuario en la base de datos
            return userMapper.toUserResponse(newUser);
    }

    //enviar codigo al correo del usuario
    /*private void sendActivationEmail(User newUser) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(newUser.getEmail());
            mailMessage.setSubject("Activación de  cuenta de usuario");
            mailMessage.setFrom(mailFrom);
            mailMessage.setText("Usa este Código Para activar Tu Cuenta"+ newUser.getActivationCode());
            logger.info("Enviando correo electrónico a {} desde {}", newUser.getEmail(), mailFrom);
            mailSender.send(mailMessage);
        } catch (Exception e) {
            logger.error("Error al enviar correo electrónico", e);
        }
    }*/
    private void sendActivationEmail(User newUser) {
        Email from = new Email(mailFrom);
        Email to = new Email(newUser.getEmail());
        String subject = "Activación de cuenta de usuario";
        String contentText = "Usa este Código Para activar Tu Cuenta: " + newUser.getActivationCode();
        Content content = new Content("text/plain", contentText);
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(sendGridApiKey);
        Request request = new Request();

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);

            logger.info("Correo de activación enviado a {}. Código de estado: {}", newUser.getEmail(), response.getStatusCode());
        } catch (Exception e) {
            logger.error("Error al enviar correo con SendGrid", e);
        }
    }

    public boolean activateUser(String email,String activationCode) {
        User user = userRepository.findUserByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));

        if (user.isActivo()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La cuenta ya está activada.");
        }

        if (!activationCode.equals(user.getActivationCode())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Código de activación inválido.");
        }

        user.setActivo(true);
        user.setActivationCode(null);
        user.setStateUser(UserStatus.REGISTERED);

        userRepository.save(user);
        if(user.getStateUser().equals(UserStatus.PENDING_ACTIVATION)){
            return false;
        }
        return true;
    }

    @Override
    public Optional<UserResponse> getUser(String id){
        return  Optional.ofNullable(userStore.get(id)).map(userMapper::toUserResponse);
    }

    @Override
    public Optional<UserResponse> updateUser(String id, UserRegistration request) {
        return Optional.empty();
    }

    @Override
    public boolean deleteUser(String id) {
        return false;
    }

   public boolean estaActivo(String email) {
       return userRepository.findUserByEmail(email)
               .map(user -> user.isActivo())
               .orElse(false);
   }

   @Override
   public UserDetails loadUserByUsername(String email) {
       return userRepository.findUserByEmail(email)
               .map(user -> org.springframework.security.core.userdetails.User
                       .withUsername(user.getEmail())
                       .password(user.getPassword())
                       .authorities("USERDEFAULT") // Ajusta los roles según tu lógica
                       .accountLocked(!user.isActivo())
                       .build())
               .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
   }
}
