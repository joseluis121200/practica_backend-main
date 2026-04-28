package es.ediae.master.programacion.gestionusuario.entity;

import jakarta.persistence.*;



@Entity
@Table(name = "direccion")
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "nombre_calle", nullable = false)
    private String nombre_calle;
    @Column (name = "numero_calle")
    private int numero_calle;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @Column (name = "direccion_principal", nullable = false)
    private boolean direccion_principal;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre_calle() {
        return nombre_calle;
    }
    public void setNombre_calle(String nombre_calle) {
        this.nombre_calle = nombre_calle;
    }
    public int getNumero_calle() {
        return numero_calle;
    }
    public void setNumero_calle(int numero_calle) {
        this.numero_calle = numero_calle;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public boolean isDireccion_principal() {
        return direccion_principal;
    }
    public void setDireccion_principal(boolean direccion_principal) {
        this.direccion_principal = direccion_principal;
    }
    
}


