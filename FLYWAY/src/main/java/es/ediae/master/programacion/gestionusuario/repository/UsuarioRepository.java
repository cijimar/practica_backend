package es.ediae.master.programacion.gestionusuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.ediae.master.programacion.gestionusuario.entity.UsuarioEntity;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
    
    // Optional es NECESARIO para login y orElseThrow
    Optional<UsuarioEntity> findByNickUsuario(String nickUsuario);

    boolean existsByNickUsuario(String nickUsuario);

    boolean existsByNickUsuarioAndIdNot(String nickUsuario, Integer id);

    Optional<UsuarioEntity> findByNickUsuarioAndContrasena(String nickUsuario, String contrasena);
}