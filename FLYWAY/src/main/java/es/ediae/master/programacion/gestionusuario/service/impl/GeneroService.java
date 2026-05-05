package es.ediae.master.programacion.gestionusuario.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.ediae.master.programacion.gestionusuario.entity.GeneroEntity;
import es.ediae.master.programacion.gestionusuario.repository.GeneroRepository;
import es.ediae.master.programacion.gestionusuario.service.IGeneroService;

@Service
public class GeneroService implements IGeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    @Override
    public List<GeneroEntity> obtenerTodosLosGeneros() {
        return generoRepository.findAll();
    }

    @Override
    public GeneroEntity obtenerGeneroPorId(Integer id) {
        return generoRepository.findById(id).orElse(null);
    }

    @Override
    public GeneroEntity crearGenero(GeneroEntity genero) {
        return generoRepository.save(genero);
    }

    @Override
    public GeneroEntity actualizarGenero(Integer id, GeneroEntity genero) {
        if (generoRepository.existsById(id)) {
            genero.setId(id);
            return generoRepository.save(genero);
        }
        return null;
    }

    @Override
    public void eliminarGenero(Integer id) {
        generoRepository.deleteById(id);
    }
    
}
