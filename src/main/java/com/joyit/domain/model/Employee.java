package com.joyit.domain.model;

public class Employee {
    private Long id;
    private String nombre;
    private String correo;
    private String faceID;

    public Employee(Long id, String nombre, String correo, String faceID) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.faceID = faceID;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public String getFaceID() { return faceID; }

    public void setId(Long id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCorreo(String correo) { this.correo = correo; }
    public void setFaceID(String faceID) { this.faceID = faceID; }
}