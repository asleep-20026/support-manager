package com.joyit.application.usecases;

import com.joyit.domain.model.UserAccount;
import com.joyit.domain.ports.in.LoginUseCase;
import com.joyit.domain.ports.out.UserAccountRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Optional;

@ApplicationScoped
public class LoginService implements LoginUseCase {

    @Inject
    UserAccountRepository usuarioRepository;

    @Override
    public Optional<UserAccount> login(String correo, String contrasenia) {
        return usuarioRepository.findByCorreo(correo)
                .filter(u -> u.getContrasenia().equals(contrasenia));
    }
}
