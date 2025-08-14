package com.joyit.domain.ports.in;

import com.joyit.domain.model.UserAccount;
import java.util.Optional;

public interface LoginUseCase {
    Optional<UserAccount> login(String correo, String contrasenia);
}
