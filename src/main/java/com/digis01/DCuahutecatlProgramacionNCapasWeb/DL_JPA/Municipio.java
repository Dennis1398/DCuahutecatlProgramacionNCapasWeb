package com.digis01.DCuahutecatlProgramacionNCapasWeb.DL_JPA;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Municipio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idmunicipio;
    
    private String nombre;

    @ManyToOne 
    @JoinColumn(name = "idestado")
    private Estado estado;

    public Municipio() {
    }

    public Municipio(int idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    public Municipio(String nombre) {
        this.nombre = nombre;
    }

    public Municipio(Estado estado) {
        this.estado = estado;
    }

    public Municipio(int idmunicipio, String nombre, Estado estado) {
        this.idmunicipio = idmunicipio;
        this.nombre = nombre;
        this.estado = estado;
    }

    public int getIdmunicipio() {
        return idmunicipio;
    }

    public void setIdmunicipio(int idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    
    
    
}
