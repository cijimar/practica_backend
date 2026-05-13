/*package es.ediae.master.programacion.gestionusuario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.lang.annotation.Inherited;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import es.ediae.master.programacion.gestionusuario.dto.DireccionResponseDTO;
import es.ediae.master.programacion.gestionusuario.entity.DireccionEntity;
import es.ediae.master.programacion.gestionusuario.entity.UsuarioEntity;
import es.ediae.master.programacion.gestionusuario.repository.DireccionRepository;
import es.ediae.master.programacion.gestionusuario.service.impl.DireccionService;

@ExtendWith(MockitoExtension.class)
public class DireccionServiceTest {

    @Mock
    private DireccionRepository direccionRepository;

    @InjectMocks
    private DireccionService direccionService;

    private UsuarioEntity usuario;
    private DireccionEntity d1;
    private DireccionEntity d2;

    @BeforeEach
    void setUp() {
        usuario = new UsuarioEntity();
        usuario.setId(1);
        usuario.setNombre("Usuario de Prueba");

        d1 = new DireccionEntity();
        d1.setId(1);
        d1.setNombreCalle("Calle Mayor");
        d1.setUsuario(usuario);

        d2 = new DireccionEntity();
        d2.setId(2);
        d2.setNombreCalle("Calle Menor");
        d2.setUsuario(usuario);
    }

    @Test
    void testObtenerTodasLasDirecciones_listaVacia() {
        // Given
        //List<DireccionEntity> direcciones = List.of(d1, d2);
        when(mockDireccionRepository.findAll()).thenReturn(List.of(d1, d2));

        // When
        List<DireccionResponseDTO> resultado = direccionService.obtenerTodasLasDirecciones();

        // Then
        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        assertEquals("Calle Mayor", resultado.get(0).getNombreCalle());
        verify(mockDireccionRepository, times(1)).findAll();
        
    }

}*/
