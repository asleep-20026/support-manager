package com.joyit.domain.model;

import java.time.LocalDate;

public class Attendance {
    private Long id;
    private String tipo;
    private LocalDate fecha;
    private Long empleadoId;

    public Attendance(Long id, String tipo, LocalDate fecha, Long empleadoId) {
        this.id = id;
        this.tipo = tipo;
        this.fecha = fecha;
        this.empleadoId = empleadoId;
    }

    public Long getId() { return id; }
    public String getTipo() { return tipo; }
    public LocalDate getFecha() { return fecha; }
    public Long getEmpleadoId() { return empleadoId; }

    public void setId(Long id) { this.id = id; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public void setEmpleadoId(Long empleadoId) { this.empleadoId = empleadoId; }
}
