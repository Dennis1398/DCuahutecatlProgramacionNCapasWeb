/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.DCuahutecatlProgramacionNCapasWeb.DL_JPA;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iddireccion;
    
    private String calle;
    private String numerointerior;
    private String numeroexterior;
    
    @ManyToOne
    @JoinColumn(name = "idestado")
    private Estado estado;
    
    @OneToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;

    public Direccion() {
    }

    public Direccion(int iddireccion) {
        this.iddireccion = iddireccion;
    }

    public Direccion(String calle) {
        this.calle = calle;
    }

    public Direccion(Estado estado) {
        this.estado = estado;
    }

    public Direccion(Usuario usuario) {
        this.usuario = usuario;
    }

    public Direccion(String calle, String numerointerior, String numeroexterior, Estado estado, Usuario usuario) {
        this.calle = calle;
        this.numerointerior = numerointerior;
        this.numeroexterior = numeroexterior;
        this.estado = estado;
        this.usuario = usuario;
    }
    
    

    public Direccion(int iddireccion, String calle, String numerointerior, String numeroexterior, Estado estado, Usuario usuario) {
        this.iddireccion = iddireccion;
        this.calle = calle;
        this.numerointerior = numerointerior;
        this.numeroexterior = numeroexterior;
        this.estado = estado;
        this.usuario = usuario;
    }

    public int getIddireccion() {
        return iddireccion;
    }

    public void setIddireccion(int iddireccion) {
        this.iddireccion = iddireccion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumerointerior() {
        return numerointerior;
    }

    public void setNumerointerior(String numerointerior) {
        this.numerointerior = numerointerior;
    }

    public String getNumeroexterior() {
        return numeroexterior;
    }

    public void setNumeroexterior(String numeroexterior) {
        this.numeroexterior = numeroexterior;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
