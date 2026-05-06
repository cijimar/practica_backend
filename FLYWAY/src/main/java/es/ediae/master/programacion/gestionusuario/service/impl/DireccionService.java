package es.ediae.master.programacion.gestionusuario.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.ediae.master.programacion.gestionusuario.dto.DireccionRequestDTO;
import es.ediae.master.programacion.gestionusuario.dto.DireccionResponseDTO;
import es.ediae.master.programacion.gestionusuario.entity.DireccionEntity;
import es.ediae.master.programacion.gestionusuario.entity.UsuarioEntity;
import es.ediae.master.programacion.gestionusuario.repository.DireccionRepository;
import es.ediae.master.programacion.gestionusuario.repository.UsuarioRepository;

@Service
public class DireccionService{

    @Autowired
    private DireccionRepository direccionRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    // CREATE
    public DireccionResponseDTO crearDireccion(DireccionRequestDTO dto) {

        UsuarioEntity usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElse(null);

        DireccionEntity direccion = DireccionRequestDTO.toEntity(dto, usuario);

        DireccionEntity guardada = direccionRepository.save(direccion);

        return DireccionResponseDTO.fromEntity(guardada);
    }

    // READ (una dirección)
    public DireccionResponseDTO obtenerDireccionPorId(Integer id) {

        DireccionEntity direccion = direccionRepository.findById(id)
                .orElse(null);

        if (direccion == null) {
            return null;
        }

        return DireccionResponseDTO.fromEntity(direccion);
    }

    // READ (todas)
    public List<DireccionResponseDTO> obtenerTodasLasDirecciones() {

        List<DireccionEntity> direcciones = direccionRepository.findAll();

        return direcciones.stream()
                .map(DireccionResponseDTO::fromEntity)
                .toList();
    }

    // UPDATE
    public DireccionResponseDTO actualizarDireccion(Integer id, DireccionRequestDTO dto) {

        DireccionEntity direccion = direccionRepository.findById(id)
                .orElse(null);

        if (direccion == null) {
            return null;
        }

        UsuarioEntity usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElse(null);

        if (usuario == null) {
            return null;
        }

        direccion.setNombreCalle(dto.getNombreCalle());
        direccion.setNumeroCalle(dto.getNumeroCalle());
        direccion.setDireccionPrincipal(dto.isDireccionPrincipal());
        direccion.setUsuario(usuario);

        DireccionEntity actualizada = direccionRepository.save(direccion);

        return DireccionResponseDTO.fromEntity(actualizada);
    }

    // DELETE
    public void eliminarDireccion(Integer id) {
        direccionRepository.deleteById(id);
    }

}
