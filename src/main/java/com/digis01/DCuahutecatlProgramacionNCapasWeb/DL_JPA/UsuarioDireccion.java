package com.digis01.DCuahutecatlProgramacionNCapasWeb.DL_JPA;


public class UsuarioDireccion {
    private Usuario usuario;

    public UsuarioDireccion() {
    }
    
    
    private Direccion direccion;

    public UsuarioDireccion(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public UsuarioDireccion(Usuario usuario, Direccion direccion) {
        this.usuario = usuario;
        this.direccion = direccion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    
    
}
