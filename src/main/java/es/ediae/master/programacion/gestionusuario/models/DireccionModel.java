package es.ediae.master.programacion.gestionusuario.models;

public class DireccionModel {
    private int id;
    private String nombreCalle;
    private String numeroCalle;
    private boolean direccionPrincipal;
    private int idUsuario;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombreCalle() {
        return nombreCalle;
    }
    public void setNombreCalle(String nombreCalle) {
        this.nombreCalle = nombreCalle;
    }
    public String getNumeroCalle() {
        return numeroCalle;
    }
    public void setNumeroCalle(String numeroCalle) {
        this.numeroCalle = numeroCalle;
    }
    public boolean isDireccionPrincipal() {
        return direccionPrincipal;
    }
    public void setDireccionPrincipal(boolean direccionPrincipal) {
        this.direccionPrincipal = direccionPrincipal;
    }
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
