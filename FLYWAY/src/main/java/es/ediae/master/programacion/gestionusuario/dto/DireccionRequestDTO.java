package es.ediae.master.programacion.gestionusuario.dto;

import es.ediae.master.programacion.gestionusuario.entity.DireccionEntity;
import es.ediae.master.programacion.gestionusuario.entity.UsuarioEntity;

// --> Se utiliza para POST y PUT. Define lo que el cliente puede enviar.

public class DireccionRequestDTO {

    private String nombreCalle;
    private Integer numeroCalle;
    private Integer usuarioId;
    private boolean direccionPrincipal;


    // Getters y Setters
    public String getNombreCalle() {
        return nombreCalle;
    }
    public void setNombreCalle(String nombreCalle) {
        this.nombreCalle = nombreCalle;
    }
    public Integer getNumeroCalle() {
        return numeroCalle;
    }
    public void setNumeroCalle(Integer numeroCalle) {
        this.numeroCalle = numeroCalle;
    }
    public Integer getUsuarioId() {
        return usuarioId;
    }
    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }
    public boolean isDireccionPrincipal() {
        return direccionPrincipal;
    }
    public void setDireccionPrincipal(boolean direccionPrincipal) {
        this.direccionPrincipal = direccionPrincipal;
    }

    // MÉTODO CLAVE: recibe un RequestDTO y devuelve un Entity.
    public static DireccionEntity toEntity(DireccionRequestDTO dto, UsuarioEntity usuario) {
        DireccionEntity direccion = new DireccionEntity();
        direccion.setNombreCalle(dto.getNombreCalle());
        direccion.setNumeroCalle(dto.getNumeroCalle());
        direccion.setDireccionPrincipal(dto.isDireccionPrincipal());
        direccion.setUsuario(usuario);
        return direccion;
    }


}
