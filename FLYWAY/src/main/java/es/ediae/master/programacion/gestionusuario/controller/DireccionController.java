package es.ediae.master.programacion.gestionusuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import es.ediae.master.programacion.gestionusuario.dto.DireccionRequestDTO;
import es.ediae.master.programacion.gestionusuario.dto.DireccionResponseDTO;
import es.ediae.master.programacion.gestionusuario.service.impl.DireccionService;


@RestController
@RequestMapping("/api/v1")
public class DireccionController {

    @Autowired
    private DireccionService direccionService;

    @PostMapping("/direcciones")
    public DireccionResponseDTO crearDireccion(@RequestBody DireccionRequestDTO dto) {
        return direccionService.crearDireccion(dto);
    }

    @GetMapping("/direcciones/{id}")
    public DireccionResponseDTO obtenerDireccionPorId(@PathVariable Integer id) {
        return direccionService.obtenerDireccionPorId(id);
    }

    @GetMapping("/direcciones")
    public List<DireccionResponseDTO> obtenerTodasLasDirecciones() {
        return direccionService.obtenerTodasLasDirecciones();
    }

    @PutMapping("/direcciones/{id}")
    public DireccionResponseDTO actualizarDireccion(@PathVariable Integer id,
                                                    @RequestBody DireccionRequestDTO dto) {
        return direccionService.actualizarDireccion(id, dto);
    }

    @DeleteMapping("/direcciones/{id}")
    public void eliminarDireccion(@PathVariable Integer id) {
        direccionService.eliminarDireccion(id);
    }


}
