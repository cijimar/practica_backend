package es.ediae.master.programacion.gestionusuario.service;

import java.util.List;

import es.ediae.master.programacion.gestionusuario.entity.PuestoDeTrabajoEntity;

public interface IPuestoDeTrabajoService {

    List<PuestoDeTrabajoEntity> obtenerTodosLosPuestosDeTrabajo();
    public PuestoDeTrabajoEntity obtenerPuestoDeTrabajoPorId(Integer id);   
    public PuestoDeTrabajoEntity crearPuestoDeTrabajo(PuestoDeTrabajoEntity puestoDeTrabajo);
    public PuestoDeTrabajoEntity actualizarPuestoDeTrabajo(Integer id, PuestoDeTrabajoEntity puestoDeTrabajo);
    public void eliminarPuestoDeTrabajo(Integer id);
    
}
