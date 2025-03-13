package com.uniquindio.sebas.guia5.services;

import com.uniquindio.sebas.guia5.doamin.User;
import com.uniquindio.sebas.guia5.dtos.UserRegistration;
import com.uniquindio.sebas.guia5.dtos.UserResponse;
import com.uniquindio.sebas.guia5.exceptions.ValueConflictExceptions;
import com.uniquindio.sebas.guia5.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    @Override
    public UserResponse createUser(UserRegistration user) {
        if (userStore.values().stream().anyMatch(u -> u.getEmail().equalsIgnoreCase(user.email())))
        {   throw new ValueConflictExceptions("el email ya esta registrado"); }
            var newUser = userMapper.parseOf(user);
            userStore.put(newUser.getId(), newUser);
            return userMapper.toUserResponse(newUser);
    }

    @Override
    public Optional<UserResponse> getUser(String id){
        return  Optional.ofNullable(userStore.get(id)).map(userMapper::toUserResponse);
    }


}
