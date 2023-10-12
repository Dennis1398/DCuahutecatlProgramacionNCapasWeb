package com.digis01.DCuahutecatlProgramacionNCapasWeb.DL_JPA;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;

@Entity
public class Rol implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idrol;
    private String nombre;

    public Rol() {
    }

    public Rol(int idRol) {
        this.idrol = idRol;
    }

    public Rol(String nombre) {
        this.nombre = nombre;
    }
    
    
    public Rol(int idRol, String nombre) {
        this.idrol = idRol;
        this.nombre = nombre;
    }

    public int getIdRol() {
        return idrol;
    }

    public void setIdRol(int idRol) {
        this.idrol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdrol() {
        return idrol;
    }

    public void setIdrol(int idrol) {
        this.idrol = idrol;
    }
    
    
    
}
