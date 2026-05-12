package es.ediae.master.programacion.gestionusuario.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class UsuarioEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "es_administrador", nullable = false)
    private Boolean esAdmin;

    @Column(name = "nick_usuario", nullable = false)
    private String nickUsuario;

    @Column(nullable = false)
    private String contrasena;

    @Column(name = "fecha_hora_creacion", nullable = false)
    private LocalDateTime fechaHoraCreacion;

    @ManyToOne
    @JoinColumn(name = "genero_id", nullable = false)
    private GeneroEntity genero;

    @Column(nullable = false)
    private String nombre;

    @Column(name = "primer_apellido", nullable = false)
    private String primerApellido;

    @Column(name = "segundo_apellido", nullable = true)
    private String segundoApellido;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(name = "hora_desayuno", nullable = true)
    private LocalTime horaDesayuno;

    @ManyToOne
    @JoinColumn(name = "puesto_de_trabajo_id", nullable = true)
    private PuestoDeTrabajoEntity puestoDeTrabajo;

    // Constructor
    public UsuarioEntity(Integer id, Boolean esAdmin, String nickUsuario, String contrasena, LocalDateTime fechaHoraCreacion, GeneroEntity genero, String nombre, String primerApellido, String segundoApellido, LocalDate fechaNacimiento,
        LocalTime horaDesayuno, PuestoDeTrabajoEntity puestoDeTrabajo) {
        this.id = id;
        this.esAdmin = esAdmin;
        this.nickUsuario = nickUsuario;
        this.contrasena = contrasena;
        this.fechaHoraCreacion = fechaHoraCreacion;
        this.genero = genero;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.horaDesayuno = horaDesayuno;
        this.puestoDeTrabajo = puestoDeTrabajo;
    }

    // Constructor vacío
    public UsuarioEntity() {
    }


    // Getters
    public Integer getId() {
        return id;
    }

    public Boolean getEsAdmin() {
        return esAdmin;
    }

    public String getNickUsuario() {
        return nickUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public LocalDateTime getFechaHoraCreacion() {
        return fechaHoraCreacion;
    }

    public GeneroEntity getGenero() {
        return genero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public LocalTime getHoraDesayuno() {
        return horaDesayuno;
    }

    public PuestoDeTrabajoEntity getPuestoDeTrabajo() {
        return puestoDeTrabajo;
    }

    
    // Setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setNickUsuario(String nickUsuario) {
        this.nickUsuario = nickUsuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setFechaHoraCreacion(LocalDateTime fechaHoraCreacion) {
        this.fechaHoraCreacion = fechaHoraCreacion;
    }

    public void setGenero(GeneroEntity genero) {
        this.genero = genero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setHoraDesayuno(LocalTime horaDesayuno) {
        this.horaDesayuno = horaDesayuno;
    }

    public void setPuestoDeTrabajo(PuestoDeTrabajoEntity puestoDeTrabajo) {
        this.puestoDeTrabajo = puestoDeTrabajo;
    }

    public void setEsAdmin(Boolean esAdmin) {
        this.esAdmin = esAdmin;
    }

    










}