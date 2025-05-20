package com.uniquindio.sebas.guia5.controllers;

import com.uniquindio.sebas.guia5.dtos.ActivateAccountRequest;
import com.uniquindio.sebas.guia5.dtos.LoginDTO;
import com.uniquindio.sebas.guia5.services.JwtService;
import com.uniquindio.sebas.guia5.services.UserServices;
import com.uniquindio.sebas.guia5.services.UserServicesImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserServices userServices;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService; //crear el token

    @PostMapping("/activate")
    public ResponseEntity<?>activationAccount (@Valid @RequestBody ActivateAccountRequest request){
        if(userServices.activateUser(request.activationCode())){
            return ResponseEntity.ok("Cuenta Activada Exitosamente");
        }else{
            return ResponseEntity.badRequest().body("Error al activar cuenta, código invalido o cuenta ya activa");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginDTO loginDTO) {
        // Verificar si el usuario está activo
        if (!userServices.estaActivo(loginDTO.email())) {
            throw new RuntimeException("Cuenta no activada");
        }

        // Autenticar
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.email(),
                        loginDTO.password()
                )
        );

        // Generar token
        UserDetails userDetails = userServices.loadUserByUsername(loginDTO.email());
        String token = jwtService.generateToken(userDetails);

        return ResponseEntity.ok(Map.of("token", token));
    }
}
