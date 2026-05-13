package es.ediae.master.programacion.gestionusuario.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.ediae.master.programacion.gestionusuario.entity.PuestoDeTrabajoEntity;
import es.ediae.master.programacion.gestionusuario.repository.PuestoDeTrabajoRepository;
import es.ediae.master.programacion.gestionusuario.service.IPuestoDeTrabajoService;

@Service
public class PuestoDeTrabajoService implements IPuestoDeTrabajoService {

    @Autowired
    private PuestoDeTrabajoRepository puestoDeTrabajoRepository;

    @Override
    public List<PuestoDeTrabajoEntity> obtenerTodosLosPuestosDeTrabajo() {
        return puestoDeTrabajoRepository.findAll();
    }

    @Override
    public PuestoDeTrabajoEntity obtenerPuestoDeTrabajoPorId(Integer id) {
        return puestoDeTrabajoRepository.findById(id).orElse(null);
    }
    
    @Override
    public PuestoDeTrabajoEntity crearPuestoDeTrabajo(PuestoDeTrabajoEntity puestoDeTrabajo) {
        return puestoDeTrabajoRepository.save(puestoDeTrabajo);
    }

    @Override
    public PuestoDeTrabajoEntity actualizarPuestoDeTrabajo(Integer id, PuestoDeTrabajoEntity puestoDeTrabajo) {
        puestoDeTrabajo.setId(id);
        return puestoDeTrabajoRepository.save(puestoDeTrabajo);
    }

    @Override
    public void eliminarPuestoDeTrabajo(Integer id) {
        puestoDeTrabajoRepository.deleteById(id);
    }   
    
}
