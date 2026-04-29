package es.ediae.master.programacion.gestionusuario.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class ValidationController {

    @PostMapping("/producto")
    public ResponseEntity<ProductoDTO> crearProducto(@RequestBody @Valid ProductoDTO productoDTO) {
        // Aquí podrías guardar el producto en la base de datos o realizar otras operaciones
        return ResponseEntity.ok(productoDTO);

    }

}
