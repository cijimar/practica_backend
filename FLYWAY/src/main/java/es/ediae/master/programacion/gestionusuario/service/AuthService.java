package es.ediae.master.programacion.gestionusuario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.ediae.master.programacion.gestionusuario.entity.UsuarioEntity;
import es.ediae.master.programacion.gestionusuario.repository.UsuarioRepository;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public boolean login(String nickUsuario, String contrasena) {

        UsuarioEntity usuario = usuarioRepository.findByNickUsuario(nickUsuario).orElse(null);

        if (usuario == null) {
            return false;
        }

        return usuario.getContrasena().equals(contrasena);
    }
}

