package com.uniquindio.sebas.guia5.mappers;

import com.uniquindio.sebas.guia5.doamin.User;
import com.uniquindio.sebas.guia5.dtos.UserRegistration;
import com.uniquindio.sebas.guia5.dtos.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID().toString())")
    @Mapping(target = "stateUser", constant = "REGISTERED")
    @Mapping(target = "password", expression = "java(new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder().encode(userDTO.password()))")
    @Mapping(target = "rolUser", source = "rol")  // Mapeo de rol en UserRegistration a rolUser en User entidad
    @Mapping(target = "fullName", source = "fullname")
    @Mapping(target = "telefono", source = "telefono")
    @Mapping(target = "lista_Reportes", ignore = true)
    @Mapping(target = "lista_notificaciones", ignore = true)
    User parseOf(UserRegistration userDTO);  // Mapeo de DTO a entidad User

    @Mapping(target = "rol", source = "rolUser")  // Mapeo de rolUser en User a rol en UserResponse
    UserResponse toUserResponse(User user);  // Mapeo de entidad a DTO
}



