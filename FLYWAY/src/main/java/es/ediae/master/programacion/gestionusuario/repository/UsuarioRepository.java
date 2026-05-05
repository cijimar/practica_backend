package es.ediae.master.programacion.gestionusuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import es.ediae.master.programacion.gestionusuario.entity.UsuarioEntity;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {

    @Query("SELECT u FROM UsuarioEntity u WHERE u.nickUsuario = :nickUsuario")
    UsuarioEntity findByNickUsuario(String nickUsuario);
    
}
