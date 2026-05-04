package es.ediae.master.programacion.gestionusuario.service;

import java.util.List;

import es.ediae.master.programacion.gestionusuario.entity.UsuarioEntity;

public interface IUsuarioService {

    List<UsuarioEntity> obtenerTodosLosUsuarios();
    UsuarioEntity obtenerUsuarioPorId(Integer id);
    UsuarioEntity obtenerUsuarioPorEmail(String email);
    UsuarioEntity crearUsuario(UsuarioEntity usuario);
    UsuarioEntity actualizarUsuario(Integer id, UsuarioEntity usuario);
    void eliminarUsuario(Integer id);

}