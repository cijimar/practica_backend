package es.ediae.master.programacion.gestionusuario.service;

import java.util.List;

import es.ediae.master.programacion.gestionusuario.entity.DireccionEntity;

public interface IDireccionService {

    List<DireccionEntity> obtenerTodasLasDirecciones();
    public DireccionEntity obtenerDireccionPorId(Integer id);
    public DireccionEntity crearDireccion(DireccionEntity direccion);
    public DireccionEntity actualizarDireccion(Integer id, DireccionEntity direccion);
    public void eliminarDireccion(Integer id);


}
