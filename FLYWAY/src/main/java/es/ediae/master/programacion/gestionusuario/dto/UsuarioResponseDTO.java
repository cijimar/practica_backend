package es.ediae.master.programacion.gestionusuario.dto;

import es.ediae.master.programacion.gestionusuario.entity.UsuarioEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

// --> Se utiliza para GET y respuestas de POST. Define lo que tú decides devolver.

public class UsuarioResponseDTO {

    private Integer id;
    private String nickUsuario;
    private Boolean esAdmin;
    private LocalDateTime fechaHoraCreacion;
    private Integer generoId;
    private String generoNombre;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private LocalDate fechaNacimiento;
    private LocalTime horaDesayuno;
    private Integer puestoDeTrabajoId;
    private String puestoDeTrabajoNombre;

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public LocalDateTime getFechaHoraCreacion() {
        return fechaHoraCreacion;
    }

    public void setFechaHoraCreacion(LocalDateTime fechaHoraCreacion) {
        this.fechaHoraCreacion = fechaHoraCreacion;
    }

    public Integer getGeneroId() {
        return generoId;
    }

    public void setGeneroId(Integer generoId) {
        this.generoId = generoId;
    }

    public String getGeneroNombre() {
        return generoNombre;
    }

    public void setGeneroNombre(String generoNombre) {
        this.generoNombre = generoNombre;
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

    public String getPuestoDeTrabajoNombre() {
        return puestoDeTrabajoNombre;
    }

    public void setPuestoDeTrabajoNombre(String puestoDeTrabajoNombre) {
        this.puestoDeTrabajoNombre = puestoDeTrabajoNombre;
    }

    // MÉTODO CLAVE: recibe un Entity y devuelve un ResponseDTO.
    public static UsuarioResponseDTO fromEntity(UsuarioEntity entity) {

        UsuarioResponseDTO dto = new UsuarioResponseDTO();

        dto.setId(entity.getId());
        dto.setNickUsuario(entity.getNickUsuario());
        dto.setEsAdmin(entity.getEsAdmin());
        dto.setFechaHoraCreacion(entity.getFechaHoraCreacion());

        dto.setNombre(entity.getNombre());
        dto.setPrimerApellido(entity.getPrimerApellido());
        dto.setSegundoApellido(entity.getSegundoApellido());
        dto.setFechaNacimiento(entity.getFechaNacimiento());
        dto.setHoraDesayuno(entity.getHoraDesayuno());

        if (entity.getGenero() != null) {
            dto.setGeneroId(entity.getGenero().getId());
            dto.setGeneroNombre(entity.getGenero().getNombre());
        }

        if (entity.getPuestoDeTrabajo() != null) {
            dto.setPuestoDeTrabajoId(entity.getPuestoDeTrabajo().getId());
            dto.setPuestoDeTrabajoNombre(entity.getPuestoDeTrabajo().getNombre());
        }

        return dto;
    }

}
