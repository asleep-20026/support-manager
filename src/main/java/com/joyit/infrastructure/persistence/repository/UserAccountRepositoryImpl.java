package com.joyit.infrastructure.persistence.repository;

import com.joyit.domain.model.UserAccount;
import com.joyit.domain.ports.out.UserAccountRepository;
import com.joyit.infrastructure.persistence.entity.UserAccountEntity;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import java.util.Optional;

@ApplicationScoped
public class UserAccountRepositoryImpl implements UserAccountRepository {

    @Inject
    EntityManager em;

    @Override
    public Optional<UserAccount> findByCorreo(String correo) {
        try {
            UserAccountEntity ue = em.createQuery(
                "FROM UsuarioEntity u WHERE u.correo = :correo", UserAccountEntity.class)
                .setParameter("correo", correo)
                .getSingleResult();
            return Optional.of(new UserAccount(ue.id, ue.correo, ue.contrasenia));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public UserAccount save(UserAccount usuario) {
        UserAccountEntity entity = new UserAccountEntity();
        entity.correo = usuario.getCorreo();
        entity.contrasenia = usuario.getContrasenia();
        em.persist(entity);
        usuario.setId(entity.id);
        return usuario;
    }
}
