package com.joyit.infrastructure.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String nombre;
    public String correo;
    public String faceID;
}