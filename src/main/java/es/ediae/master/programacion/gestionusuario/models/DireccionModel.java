package es.ediae.master.programacion.gestionusuario.models;

public class DireccionModel {
    private int id;
    private String nombreCalle;
    private Integer numeroCalle;
    private boolean direccionPrincipal;
    private int idUsuario;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre_calle() {
        return nombreCalle;
    }
    public void setNombre_calle(String nombreCalle) {
        this.nombreCalle = nombreCalle;
    }
    public Integer getNumero_calle() {
        return numeroCalle;
    }
    public void setNumero_calle(Integer numeroCalle) {
        this.numeroCalle = numeroCalle;
    }
    public boolean isDireccion_principal() {
        return direccionPrincipal;
    }
    public void setDireccion_principal(boolean direccionPrincipal) {
        this.direccionPrincipal = direccionPrincipal;
    }
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
