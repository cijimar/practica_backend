/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;

import es.ediae.master.programacion.gestionusuario.Eentity.DireccionEntity;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class DireccionRepositoryTest {

    @Autowired
    private DireccionRepository direccionRepository;

    @Test
    void buscarPorUsuarioId_devuelveSoloDireccionesDelUsuarioIndicado()  {
        // Given
        Integer usuarioExistente = 1;

        // When
        List<DireccionEntity> resultado = direccionRepository.buscarPorUsuarioId(usuarioExistente);

        // Then
        assertThat(resultado).hasSize(2);
        assertThat(resultado).extracting(DireccionEntity::geNombreCalle).containsExactlyAnyOrder("Calle Mayor", "Calle Menor");
        assertThat(resultado). allMatch(direccion -> direccion.getUsuario().getId().equals(usuarioExistente));
    }


}*/
