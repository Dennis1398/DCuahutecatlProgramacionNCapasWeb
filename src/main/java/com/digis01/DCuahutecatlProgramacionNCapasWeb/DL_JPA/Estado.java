
package com.digis01.DCuahutecatlProgramacionNCapasWeb.DL_JPA;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Estado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idestado;
    
    private String nombre;
    
    @ManyToOne // muchos estados a un pais 
    @JoinColumn(name = "idpais")
    private Pais pais;

    public Estado() {
    }

    public Estado(int idestado) {
        this.idestado = idestado;
    }

    public Estado(String nombre) {
        this.nombre = nombre;
    }

    public Estado(Pais pais) {
        this.pais = pais;
    }

    public Estado(int idestado, String nombre, Pais pais) {
        this.idestado = idestado;
        this.nombre = nombre;
        this.pais = pais;
    }

    public int getIdestado() {
        return idestado;
    }

    public void setIdestado(int idestado) {
        this.idestado = idestado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
    
    
    
}
