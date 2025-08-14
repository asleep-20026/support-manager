package com.joyit.domain.model;

public class UserAccount {
    private Long id;
    private String correo;
    private String contrasenia;

    public UserAccount(Long id, String correo, String contrasenia) {
        this.id = id;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    public Long getId() { return id; }
    public String getCorreo() { return correo; }
    public String getContrasenia() { return contrasenia; }

    public void setId(Long id) { this.id = id; }
    public void setCorreo(String correo) { this.correo = correo; }
    public void setContrasenia(String contrasenia) { this.contrasenia = contrasenia; }
}
