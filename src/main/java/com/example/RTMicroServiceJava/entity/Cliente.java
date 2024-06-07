package com.example.RTMicroServiceJava.entity;

import jakarta.persistence.Entity;

@Entity
public class Cliente extends Persona{
    private Long clienteId;
    private String contraseña;
    private String estado;

    public Cliente() {}

    public Cliente(String contraseña, String estado) {
        this.contraseña = contraseña;
        this.estado = estado;
    }

    public Cliente(Long clienteId, String contraseña, String estado) {
        this.clienteId = clienteId;
        this.contraseña = contraseña;
        this.estado = estado;
    }

    public Cliente(Long id, String nombre, String genero, int edad, String identificacion, String direccion, String telefono, Long clienteId, String contraseña, String estado) {
        super(id, nombre, genero, edad, identificacion, direccion, telefono);
        this.clienteId = clienteId;
        this.contraseña = contraseña;
        this.estado = estado;
    }

    public Cliente(String nombre, String genero, int edad, String identificacion, String direccion, String telefono, Long clienteId, String contraseña, String estado) {
        super(nombre, genero, edad, identificacion, direccion, telefono);
        this.clienteId = clienteId;
        this.contraseña = contraseña;
        this.estado = estado;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
