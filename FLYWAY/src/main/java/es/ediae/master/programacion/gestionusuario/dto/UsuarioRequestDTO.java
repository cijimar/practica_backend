package es.ediae.master.programacion.gestionusuario.dto;

import java.time.LocalDate;
import java.time.LocalTime;

// --> Se utiliza para POST y PUT. Define lo que el cliente puede enviar.

public class UsuarioRequestDTO {

    private Boolean esAdmin;
    private String nickUsuario;
    private String contrasena;
    private Integer generoId;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private LocalDate fechaNacimiento;
    private LocalTime horaDesayuno;
    private Integer puestoDeTrabajoId;

    // Getters y Setters
    public Boolean getEsAdmin() {
        return esAdmin;
    }    
    
    public void setEsAdmin(Boolean esAdmin) {
        this.esAdmin = esAdmin;
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
    public Integer getGeneroId() {
        return generoId;
    }
    public void setGeneroId(Integer generoId) {
        this.generoId = generoId;
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
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public LocalTime getHoraDesayuno() {
        return horaDesayuno;
    }
    public void setHoraDesayuno(LocalTime horaDesayuno) {
        this.horaDesayuno = horaDesayuno;
    }
    public Integer getPuestoDeTrabajoId() {
        return puestoDeTrabajoId;
    }
    public void setPuestoDeTrabajoId(Integer puestoDeTrabajoId) {
        this.puestoDeTrabajoId = puestoDeTrabajoId;
    }    
    
}
