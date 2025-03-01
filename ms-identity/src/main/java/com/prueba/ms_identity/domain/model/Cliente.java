package com.prueba.ms_identity.domain.model;

public class Cliente extends Persona {

    private Long id;
    private String contraseña;
    private boolean estado;

    public Cliente(String telefono, String direccion, String identificacion, int edad, String genero, String nombre) {
        super(telefono, direccion, identificacion, edad, genero, nombre);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
