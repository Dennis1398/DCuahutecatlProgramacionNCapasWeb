
package com.digis01.DCuahutecatlProgramacionNCapasWeb.DL_JPA;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Empleado implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int numeroempleado;
    
    @Basic
    private String rfc;
    private String nombre;
    private String apellidopaterno;
    private String apellidomaterno;
    private String email;
    private String telefono;
    private String nss;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal (TemporalType.DATE)
    private Date fechanacimiento;
    private Date fechaingreso;
    
    
    @Lob
    private String foto;

//    @OneToMany
//    @JoinColumn(name= "idempresa") 
//    private Empresa empresa;

    public Empleado() {
    }

    public Empleado(int numeroempleado) {
        this.numeroempleado = numeroempleado;
    }

    public Empleado(String rfc) {
        this.rfc = rfc;
    }

    public Empleado(int idempleado, String rfc, String nombre, String apellidopaterno, String apellidomaterno, String email, String telefono, String nss, Date fechanacimiento, Date fechaingreso, String foto, Empresa empresa) {
        this.numeroempleado = numeroempleado;
        this.rfc = rfc;
        this.nombre = nombre;
        this.apellidopaterno = apellidopaterno;
        this.apellidomaterno = apellidomaterno;
        this.email = email;
        this.telefono = telefono;
        this.nss = nss;
        this.fechanacimiento = fechanacimiento;
        this.fechaingreso = fechaingreso;
        this.foto = foto;
        //this.empresa = empresa;
    }

    public int getIdempleado() {
        return numeroempleado;
    }

    public void setIdempleado(int numeroempleado) {
        this.numeroempleado = numeroempleado;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidopaterno() {
        return apellidopaterno;
    }

    public void setApellidopaterno(String apellidopaterno) {
        this.apellidopaterno = apellidopaterno;
    }

    public String getApellidomaterno() {
        return apellidomaterno;
    }

    public void setApellidomaterno(String apellidomaterno) {
        this.apellidomaterno = apellidomaterno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public Date getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(Date fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

//    public Empresa getEmpresa() {
//        return empresa;
//    }

//    public void setEmpresa(Empresa empresa) {
//        this.empresa = empresa;
//    }
    
    
}
