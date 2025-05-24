package com.uniquindio.sebas.guia5.services.implementations;

import com.uniquindio.sebas.guia5.doamin.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private final User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // puedes retornar roles aquí si tienes alguno
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return user.getPassword(); // ⚠️ importante
    }

    @Override
    public String getUsername() {
        return user.getEmail(); // ⚠️ Spring lo usa como username
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // puedes ajustar según lógica
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // puedes ajustar
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // puedes ajustar
    }

    @Override
    public boolean isEnabled() {
        return user.isActivo(); // ⚠️ Si esto es false, el login falla
    }

    public User getUser() {
        return user;
    }
}
