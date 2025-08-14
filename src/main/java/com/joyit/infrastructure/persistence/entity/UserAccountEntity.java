package com.joyit.infrastructure.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_Account")
public class UserAccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false, unique = true)
    public String correo;

    @Column(nullable = false)
    public String contrasenia;
}
