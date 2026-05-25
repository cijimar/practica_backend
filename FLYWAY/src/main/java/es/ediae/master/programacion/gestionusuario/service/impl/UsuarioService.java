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
import es.ediae.master.programacion.gestionusuario.repository.DireccionRepository;
import es.ediae.master.programacion.gestionusuario.repository.GeneroRepository;
import es.ediae.master.programacion.gestionusuario.repository.PuestoDeTrabajoRepository;
import es.ediae.master.programacion.gestionusuario.repository.UsuarioRepository;
import es.ediae.master.programacion.gestionusuario.service.AuthService;
import jakarta.transaction.Transactional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private GeneroRepository generoRepository;

    @Autowired
    private PuestoDeTrabajoRepository puestoDeTrabajoRepository;

    @Autowired
    private AuthService authService;

    @Autowired
    private DireccionRepository direccionRepository;

    // CREATE
    public UsuarioResponseDTO crearUsuario(UsuarioRequestDTO dto) {

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

        GeneroEntity genero = generoRepository.findById(dto.getGeneroId())
                .orElseThrow(() -> new RuntimeException("Genero no encontrado"));

        usuario.setGenero(genero);

        if (dto.getPuestoDeTrabajoId() != null) {
            PuestoDeTrabajoEntity puesto = puestoDeTrabajoRepository.findById(dto.getPuestoDeTrabajoId())
                    .orElseThrow(() -> new RuntimeException("Puesto no encontrado"));

            usuario.setPuestoDeTrabajo(puesto);
        }

        UsuarioEntity guardado = usuarioRepository.save(usuario);

        return UsuarioResponseDTO.fromEntity(guardado);
    }

    // READ ONE
    public UsuarioResponseDTO obtenerUsuarioPorId(Integer id) {

        UsuarioEntity usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        return UsuarioResponseDTO.fromEntity(usuario);
    }

    // READ ALL
    public List<UsuarioResponseDTO> obtenerTodosLosUsuarios() {

        return usuarioRepository.findAll()
            .stream()
            .map(UsuarioResponseDTO::fromEntity)
            .toList();
    }

    // UPDATE
    public UsuarioResponseDTO actualizarUsuario(Integer id, UsuarioRequestDTO dto) {

        UsuarioEntity usuario = usuarioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // VALIDAR NICK SOLO SI CAMBIA
        if (!usuario.getNickUsuario().equals(dto.getNickUsuario())
                && usuarioRepository.existsByNickUsuario(dto.getNickUsuario())) {
            throw new RuntimeException("Ya existe un usuario con ese nick");
        }

        usuario.setEsAdmin(dto.getEsAdmin());
        usuario.setNickUsuario(dto.getNickUsuario());
        usuario.setContrasena(dto.getContrasena());
        usuario.setNombre(dto.getNombre());
        usuario.setPrimerApellido(dto.getPrimerApellido());
        usuario.setSegundoApellido(dto.getSegundoApellido());
        usuario.setFechaNacimiento(dto.getFechaNacimiento());
        usuario.setHoraDesayuno(dto.getHoraDesayuno());

        return UsuarioResponseDTO.fromEntity(usuarioRepository.save(usuario));
    }

    // DELETE
    @Transactional
    public void eliminarUsuario(Integer id) {
        direccionRepository.deleteByUsuarioId(id);
        direccionRepository.flush();
        usuarioRepository.deleteById(id);
    }

    // LOGIN
    public boolean iniciarSesion(String nickUsuario, String contrasena) {
        return usuarioRepository.findByNickUsuario(nickUsuario)
            .map(u -> u.getContrasena().equals(contrasena))
            .orElse(false);
}
}
