package com.joyit.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "attendance")
public class AttendanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;
    private LocalDate fecha;
    private Long empleadoId;

    // Getters
    public Long getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Long getEmpleadoId() {
        return empleadoId;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setEmpleadoId(Long empleadoId) {
        this.empleadoId = empleadoId;
    }
}
