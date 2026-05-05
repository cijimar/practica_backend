package es.ediae.master.programacion.gestionusuario.service;

import java.util.List;

import es.ediae.master.programacion.gestionusuario.entity.GeneroEntity;

public interface IGeneroService {

    List<GeneroEntity> obtenerTodosLosGeneros();
    public GeneroEntity obtenerGeneroPorId(Integer id);
    public GeneroEntity crearGenero(GeneroEntity genero);
    public GeneroEntity actualizarGenero(Integer id, GeneroEntity genero);
    public void eliminarGenero(Integer id);

}