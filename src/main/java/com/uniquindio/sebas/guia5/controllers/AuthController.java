package com.uniquindio.sebas.guia5.controllers;

import com.uniquindio.sebas.guia5.doamin.User;
import com.uniquindio.sebas.guia5.dtos.ActivateAccountRequest;
import com.uniquindio.sebas.guia5.dtos.LoginDTO;
import com.uniquindio.sebas.guia5.dtos.LoginDTOresponse;
import com.uniquindio.sebas.guia5.services.JwtService;
import com.uniquindio.sebas.guia5.services.UserServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserServices userServices;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService; //crear el token

    @PostMapping("/activate")
    public ResponseEntity<?>activationAccount (@Valid @RequestBody ActivateAccountRequest request){ //usando el metodo que implementa userDetails dto
        if(userServices.activateUser(request.email(),request.activationCode())){
            return ResponseEntity.ok("Cuenta Activada Exitosamente");
        }else{ // por ahora se usaran opcionales "?" pero hay que modificarlo a SuccesResponse
            return ResponseEntity.badRequest().body("Error al activar cuenta, código invalido o cuenta ya activa");
        }
    }

    /**
     * Endpoint para iniciar sesión.
     *
     * @param request Objeto que contiene el email y la contraseña del usuario.
     * @return Respuesta con el token JWT si las credenciales son válidas, o un mensaje de error.
     *
     * @param request
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<LoginDTOresponse> login(@RequestBody @Valid LoginDTO request) {
        Optional<User> userOptional = userServices.findUserByEmail(request.email());

        if (userOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                    new LoginDTOresponse(null, "Usuario no encontrado.")
            );
        }

        User user = userOptional.get();

        if (!userServices.estaActivo(request.email())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(
                    new LoginDTOresponse(null, "La cuenta aún no ha sido activada.")
            );
        }

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.email(), request.password())
            );
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                    new LoginDTOresponse(null, "Credenciales incorrectas.")
            );
        }

        String token = jwtService.generateToken(user);

        return ResponseEntity.ok(new LoginDTOresponse(token, "Login exitoso"));
    }

}
