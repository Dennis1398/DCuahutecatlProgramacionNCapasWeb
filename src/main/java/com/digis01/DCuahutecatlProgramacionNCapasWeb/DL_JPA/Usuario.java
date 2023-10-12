
package com.digis01.DCuahutecatlProgramacionNCapasWeb.DL_JPA;
import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Usuario implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idusuario;
    
    
    @Basic
    private String nombre;
    private String apellidopaterno;
    private String apellidomaterno;
    private String email;
    private String password;
    private String username;
    private String sexo;
    private String telefono;
    private String celular;
    private String curp;
    //private int idRol;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal (TemporalType.DATE)
    private Date fechanacimiento;
    
    @ManyToOne
    @JoinColumn(name= "idrol") 
    private Rol rol;
    
    @Lob
    private String imagen;
    
    private String status;
    

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    public Usuario() {
    }
    

       
    

    public Usuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public Usuario(String Nombre) {
        this.nombre = nombre;
    }

    public Usuario(int idusuario, String nombre, String apellidopaterno, String apellidomaterno, String email, String password, String username, String sexo, String telefono, String celular, String curp, Date fechanacimiento, Rol rol, String imagen, String status) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.apellidopaterno = apellidopaterno;
        this.apellidomaterno = apellidomaterno;
        this.email = email;
        this.password = password;
        this.username = username;
        this.sexo = sexo;
        this.telefono = telefono;
        this.celular = celular;
        this.curp = curp;
        this.fechanacimiento = fechanacimiento;
        this.rol = rol;
        this.imagen = imagen;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    
      


   
    
    
    
}
