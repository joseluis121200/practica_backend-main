package es.ediae.master.programacion.gestionusuario.models;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;

public class UsuarioModel {
   
    private Integer id;
    private String nickUsuario;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private boolean esAdmin;
    private Integer idGenero; 
    private Integer idPuesto;
    private String contrasena;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNickUsuario() {
        return nickUsuario;
    }
    public void setNickUsuario(String nickUsuario) {
        this.nickUsuario = nickUsuario;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPrimerApellido() {
        return primerApellido;
    }
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }
    public String getSegundoApellido() {
        return segundoApellido;
    }
    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }
    public boolean isEsAdmin() {
        return esAdmin;
    }
    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }
    public Integer getIdGenero() {
        return idGenero;
    }
    public void setIdGenero(Integer idGenero) {
        this.idGenero = idGenero;
    }
    public Integer getIdPuesto() {
        return idPuesto;
    }
    public void setIdPuesto(Integer idPuesto) {
        this.idPuesto = idPuesto;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    
}
    

