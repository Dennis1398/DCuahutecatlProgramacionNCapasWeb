package com.digis01.DCuahutecatlProgramacionNCapasWeb.DL_JPA;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpais;
    
    private String nombre;

    public Pais() {
    }

    public Pais(int idpais) {
        this.idpais = idpais;
    }

    public Pais(String nombre) {
        this.nombre = nombre;
    }

    public Pais(int idpais, String nombre) {
        this.idpais = idpais;
        this.nombre = nombre;
    }

    public int getIdpais() {
        return idpais;
    }

    public void setIdpais(int idpais) {
        this.idpais = idpais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
