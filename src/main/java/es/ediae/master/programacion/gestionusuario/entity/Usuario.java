package es.ediae.master.programacion.gestionusuario.entity;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;


@Entity
@Table(name = "usuarios")

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nick_usuario", nullable = false)
    private String nickUsuario;
    @Column(name = "contrasena", nullable = false)
    private String contrasena;
    @Column(name = "fecha_hora_creacion", nullable = false)
    private Timestamp fecha_hora_creacion;
    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;
    @Column(name = "es_admin", nullable = false)
    private boolean esAdmin;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "primer_apellido", nullable = false)
    private String primer_apellido;
    @Column(name = "segundo_apellido")
    private String segundo_apellido;
    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fecha_nacimiento;
    @Column(name="hora_desayuno")
    private Time hora_desayuno;
    @ManyToOne
    @JoinColumn(name = "puesto_trabajo_id")
    private PuestoDeTrabajo puesto_trabajo;

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
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public Timestamp getFecha_hora_creacion() {
        return fecha_hora_creacion;
    }
    public void setFecha_hora_creacion(Timestamp fecha_hora_creacion) {
        this.fecha_hora_creacion = fecha_hora_creacion;
    }
    public Genero getGenero() {
        return genero;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPrimer_apellido() {
        return primer_apellido;
    }
    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }
    public String getSegundo_apellido() {
        return segundo_apellido;
    }
    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }
    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }
    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
    public Time getHora_desayuno() {
        return hora_desayuno;
    }
    public void setHora_desayuno(Time hora_desayuno) {
        this.hora_desayuno = hora_desayuno;
    }
    public PuestoDeTrabajo getPuesto_trabajo() {
        return puesto_trabajo;
    }
    public void setPuesto_trabajo(PuestoDeTrabajo puesto_trabajo) {
        this.puesto_trabajo = puesto_trabajo;
    }
    public boolean isEsAdmin() {
        return esAdmin;
    }
    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }
    
}
