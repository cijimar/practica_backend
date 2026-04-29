package es.ediae.master.programacion.gestionusuario.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name =  "direcciones")
public class DireccionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nombre_calle", nullable = false)
    private String nombreCalle;

    @Column(name="numero_calle", nullable = true)
    private Integer numeroCalle;

    @ManyToOne
    @JoinColumn(name="usuario_id", nullable = false)    
    private UsuarioEntity usuario;

    @Column(name="direccion_principal", nullable = false)
    private boolean direccionPrincipal;

    // Constructor
    public DireccionEntity(Integer id, String nombreCalle, Integer numeroCalle, UsuarioEntity usuario, boolean direccionPrincipal) {
        this.id = id;
        this.nombreCalle = nombreCalle;
        this.numeroCalle = numeroCalle;
        this.usuario = usuario;
        this.direccionPrincipal = direccionPrincipal;
    }     
    
    
    // Constructor vacío
    public DireccionEntity() {
    }


    // Getters
    public Integer getId() {
        return id;
    }     

    public String getNombreCalle() {
        return nombreCalle;
    }

    public Integer getNumeroCalle() {
        return numeroCalle;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public boolean isDireccionPrincipal() {
        return direccionPrincipal;
    }


    // Setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombreCalle(String nombreCalle) {
        this.nombreCalle = nombreCalle;
    }

    public void setNumeroCalle(Integer numeroCalle) {
        this.numeroCalle = numeroCalle;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public void setDireccionPrincipal(boolean direccionPrincipal) {
        this.direccionPrincipal = direccionPrincipal;
    }
    

    


    
}