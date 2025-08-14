package com.joyit.infrastructure.graphql.resolvers;

import com.joyit.domain.model.UserAccount;
import com.joyit.domain.ports.in.LoginUseCase;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;

import jakarta.inject.Inject;

@GraphQLApi
public class AuthResolver {

    @Inject
    LoginUseCase loginUseCase;

    @Mutation
    public UserAccount login(@Name("correo") String correo, @Name("contrasenia") String contrasenia) {
        return loginUseCase.login(correo, contrasenia).orElse(null);
    }
}
