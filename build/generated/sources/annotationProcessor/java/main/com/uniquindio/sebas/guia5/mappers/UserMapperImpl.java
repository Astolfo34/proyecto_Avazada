package com.uniquindio.sebas.guia5.mappers;

import com.uniquindio.sebas.guia5.doamin.Rol;
import com.uniquindio.sebas.guia5.doamin.User;
import com.uniquindio.sebas.guia5.doamin.UserStatus;
import com.uniquindio.sebas.guia5.dtos.UserRegistration;
import com.uniquindio.sebas.guia5.dtos.UserResponse;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-13T07:59:22-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.12.1.jar, environment: Java 21.0.6 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User parseOf(UserRegistration userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.fullName( userDTO.fullname() );
        user.email( userDTO.email() );
        user.dateBirth( userDTO.dateBirth() );

        user.id( java.util.UUID.randomUUID().toString() );
        user.stateUser( UserStatus.REGISTERED );
        user.password( new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder().encode(userDTO.password()) );

        return user.build();
    }

    @Override
    public UserResponse toUserResponse(User user) {
        if ( user == null ) {
            return null;
        }

        String id = null;
        String email = null;
        String fullName = null;
        LocalDate dateBirth = null;

        id = user.getId();
        email = user.getEmail();
        fullName = user.getFullName();
        dateBirth = user.getDateBirth();

        Rol rol = null;

        UserResponse userResponse = new UserResponse( id, email, fullName, dateBirth, rol );

        return userResponse;
    }
}
