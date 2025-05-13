package com.uniquindio.sebas.guia5.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // 1. Permite todas las peticiones sin autenticación
                .authorizeHttpRequests(authz -> authz
                        .anyRequest().permitAll()
                )
                // 2. Deshabilita CSRF (útil para pruebas con .http o Postman)
                .csrf(csrf -> csrf.disable());
        return http.build();
    }
}
