package es.ediae.master.programacion.gestionusuario.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "puestos_de_trabajo")
public class PuestoDeTrabajoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    // Constructor
    public PuestoDeTrabajoEntity(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }


    // Constructor vacío
    public PuestoDeTrabajoEntity() {
    }   


    // Getters
    public Integer getId() {
        return id;
    }   

    public String getNombre() {
        return nombre;
    }


    // Setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
