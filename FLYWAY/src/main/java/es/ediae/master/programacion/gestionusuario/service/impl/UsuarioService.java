package es.ediae.master.programacion.gestionusuario.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.ediae.master.programacion.gestionusuario.dto.UsuarioRequestDTO;
import es.ediae.master.programacion.gestionusuario.dto.UsuarioResponseDTO;
import es.ediae.master.programacion.gestionusuario.entity.GeneroEntity;
import es.ediae.master.programacion.gestionusuario.entity.PuestoDeTrabajoEntity;
import es.ediae.master.programacion.gestionusuario.entity.UsuarioEntity;
import es.ediae.master.programacion.gestionusuario.repository.GeneroRepository;
import es.ediae.master.programacion.gestionusuario.repository.PuestoDeTrabajoRepository;
import es.ediae.master.programacion.gestionusuario.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Añado estos dos autowired 

    @Autowired
    private GeneroRepository generoRepository;

    @Autowired
    private PuestoDeTrabajoRepository puestoDeTrabajoRepository;
    
    // CREATE
    public UsuarioResponseDTO crearUsuario(UsuarioRequestDTO dto) {
    
    // VALIDACION ANTES DE CREACION: el nickUsuario debe ser único
    if (usuarioRepository.existsByNickUsuario(dto.getNickUsuario())) {
    throw new RuntimeException("Ya existe un usuario con ese nick");
    }

    UsuarioEntity usuario = new UsuarioEntity();

    usuario.setEsAdmin(dto.getEsAdmin());
    usuario.setNickUsuario(dto.getNickUsuario());
    usuario.setContrasena(dto.getContrasena());
    usuario.setFechaHoraCreacion(LocalDateTime.now());
    usuario.setNombre(dto.getNombre());
    usuario.setPrimerApellido(dto.getPrimerApellido());
    usuario.setSegundoApellido(dto.getSegundoApellido());
    usuario.setFechaNacimiento(dto.getFechaNacimiento());
    usuario.setHoraDesayuno(dto.getHoraDesayuno());

    // GENERO (obligatorio)
    GeneroEntity genero = generoRepository.findById(dto.getGeneroId())
        .orElseThrow(() -> new RuntimeException("Genero no encontrado"));

    usuario.setGenero(genero);

    // PUESTO (opcional)
    if (dto.getPuestoDeTrabajoId() != null) {
        PuestoDeTrabajoEntity puesto = puestoDeTrabajoRepository
            .findById(dto.getPuestoDeTrabajoId())
            .orElseThrow(() -> new RuntimeException("Puesto no encontrado"));

        usuario.setPuestoDeTrabajo(puesto);
    }

    UsuarioEntity guardado = usuarioRepository.save(usuario);

    return UsuarioResponseDTO.fromEntity(guardado);
    }


    // READ (un usuario)
    public UsuarioResponseDTO obtenerUsuarioPorId(Integer id) {

        UsuarioEntity usuario = usuarioRepository.findById(id)
                .orElse(null);

        if (usuario == null) {
            return null;
        }

        return UsuarioResponseDTO.fromEntity(usuario);
    }


    // READ (todos los usuarios)
    public List<UsuarioResponseDTO> obtenerTodosLosUsuarios() {

        List<UsuarioEntity> usuarios = usuarioRepository.findAll();

        return usuarios.stream()
                .map(UsuarioResponseDTO::fromEntity)
                .toList();
    }


    // UPDATE
    public UsuarioResponseDTO actualizarUsuario(Integer id, UsuarioRequestDTO dto) {

        UsuarioEntity usuario = usuarioRepository.findById(id).orElse(null);
        
        if (usuario == null) {
            return null;
        }

        // SE COMPRUEBA ANTES SI EL USUARIO EXISTE Y DESPUES SE VALIDA EL NICK: el nickUsuario debe ser único
        if (usuarioRepository.existsByNickUsuarioAndIdNot(dto.getNickUsuario(), id)) {
        throw new RuntimeException("Ya existe un usuario con ese nick");
        }



        // Actualizar campos
        usuario.setEsAdmin(dto.getEsAdmin());
        usuario.setNickUsuario(dto.getNickUsuario());
        usuario.setContrasena(dto.getContrasena());
        usuario.setNombre(dto.getNombre());
        usuario.setPrimerApellido(dto.getPrimerApellido());
        usuario.setSegundoApellido(dto.getSegundoApellido());
        usuario.setFechaNacimiento(dto.getFechaNacimiento());
        usuario.setHoraDesayuno(dto.getHoraDesayuno());

        UsuarioEntity actualizada = usuarioRepository.save(usuario);

        return UsuarioResponseDTO.fromEntity(actualizada);
    }


    // DELETE
    public void eliminarUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }


    // INICIAR SESION
    public boolean iniciarSesion(String nickUsuario, String contrasena) {

    UsuarioEntity usuario = usuarioRepository.findByNickUsuario(nickUsuario);

    if (usuario == null) {
        return false;
    }

    if (!usuario.getContrasena().equals(contrasena)) {
        return false;
    }

    return true;
    }    
    
}
