package com.joyit.domain.ports.out;

import com.joyit.domain.model.UserAccount;
import java.util.Optional;

public interface UserAccountRepository {
    Optional<UserAccount> findByCorreo(String correo);
    UserAccount save(UserAccount usuario);
}
