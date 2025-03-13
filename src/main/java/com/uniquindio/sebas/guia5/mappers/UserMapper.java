package com.uniquindio.sebas.guia5.mappers;

import com.uniquindio.sebas.guia5.doamin.User;
import com.uniquindio.sebas.guia5.dtos.UserRegistration;
import com.uniquindio.sebas.guia5.dtos.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING) //definition to spring that this mapper will be a bean (@component)
public interface UserMapper {                                      //it is used to inject in a service with the method @Autowired

        /**
         * PARA LOS MAPPER DEFINIREMOS LAS TRANSFORMACIONES DE LOS DATOS
         * LOS CUALES SUFLUJO DE DATOS PROVIENEN DE LOS SERVICIOS QUE USAN REPOSITORIOS
         * Y LOS OBJETOS RECIBIDOS DTO , A ENTIDADES
         */

    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID().toString())")//generate a UUID random for my users mapped
    @Mapping(target = "stateUser", constant = "REGISTERED") // add the string registered to the users objects
    @Mapping(target = "password",
            expression = "java(new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder().encode(userDTO.password()))")
    @Mapping(target = "rolUser", ignore = true )
    @Mapping(target = "fullName", source = "fullname")
    User parseOf(UserRegistration userDTO);  //transformation of DTO object in an Entity
    UserResponse toUserResponse(User user);   //transform a object type entity to object DTO UserResponse, used to response in the API
                                                //for this context, is the response after created an new user, this had better sent to server
}
