package es.ediae.master.programacion.gestionusuario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.ediae.master.programacion.gestionusuario.entity.DireccionEntity;

@Repository
public interface DireccionRepository extends JpaRepository<DireccionEntity, Integer> {
    
    @Query("SELECT d FROM DireccionEntity d WHERE d.usuario.id = :usuarioId")
    //Cambiamos el findByUsuarioId por buscarPorUsuarioId porque Spring hace la implementación de forma automática y nos puede dar error si el nombre no sigue la convención de Spring Data JPA 
    List<DireccionEntity> buscarPorUsuarioId(Integer usuarioId);

    @Modifying
    @Query("DELETE FROM DireccionEntity d WHERE d.usuario.id = :usuarioId")
    void deleteByUsuarioId(@Param("usuarioId") Integer usuarioId);

}
