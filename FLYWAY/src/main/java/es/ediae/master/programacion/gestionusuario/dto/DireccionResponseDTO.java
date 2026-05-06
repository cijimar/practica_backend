package es.ediae.master.programacion.gestionusuario.dto;

import es.ediae.master.programacion.gestionusuario.entity.DireccionEntity;

// --> Se utiliza para GET y respuestas de POST. Define lo que tú decides devolver.

public class DireccionResponseDTO {

    private Integer id;
    private String nombreCalle;
    private Integer numeroCalle;
    private boolean direccionPrincipal;

    // Datos básicos del usuario (no todo!)
    private Integer usuarioId;
    private String nombreUsuario;

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public boolean isDireccionPrincipal() {
        return direccionPrincipal;
    }

    public void setDireccionPrincipal(boolean direccionPrincipal) {
        this.direccionPrincipal = direccionPrincipal;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    // MÉTODO CLAVE: recibe un Entity y devuelve un ResponseDTO.
    public static DireccionResponseDTO fromEntity(DireccionEntity entity) {
        
        DireccionResponseDTO dto = new DireccionResponseDTO();

        dto.setId(entity.getId());
        dto.setNombreCalle(entity.getNombreCalle());
        dto.setNumeroCalle(entity.getNumeroCalle());
        dto.setDireccionPrincipal(entity.isDireccionPrincipal());

        if (entity.getUsuario() != null) {
            dto.setUsuarioId(entity.getUsuario().getId());
            dto.setNombreUsuario(entity.getUsuario().getNombre());
        }

        return dto;
    }


}
