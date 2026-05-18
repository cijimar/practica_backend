package es.ediae.master.programacion.gestionusuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import es.ediae.master.programacion.gestionusuario.dto.LoginDTO;
import es.ediae.master.programacion.gestionusuario.dto.UsuarioRequestDTO;
import es.ediae.master.programacion.gestionusuario.dto.UsuarioResponseDTO;
import es.ediae.master.programacion.gestionusuario.service.AuthService;
import es.ediae.master.programacion.gestionusuario.service.impl.UsuarioService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AuthService authService;

    // CREATE
    @PostMapping("/usuarios")
    public UsuarioResponseDTO crearUsuario(@RequestBody UsuarioRequestDTO dto) {
        return usuarioService.crearUsuario(dto);
    }

    // READ ONE
    @GetMapping("/usuarios/{id}")
    public UsuarioResponseDTO obtenerUsuarioPorId(@PathVariable Integer id) {
        return usuarioService.obtenerUsuarioPorId(id);
    }

    // READ ALL
    @GetMapping("/usuarios")
    public List<UsuarioResponseDTO> obtenerTodosLosUsuarios() {
        return usuarioService.obtenerTodosLosUsuarios();
    }

    // UPDATE
    @PutMapping("/usuarios/{id}")
    public UsuarioResponseDTO actualizarUsuario(
            @PathVariable Integer id,
            @RequestBody UsuarioRequestDTO dto) {
        return usuarioService.actualizarUsuario(id, dto);
    }

    // DELETE
    @DeleteMapping("/usuarios/{id}")
    public void eliminarUsuario(@PathVariable Integer id) {
        usuarioService.eliminarUsuario(id);
    }

    // LOGIN
    @PostMapping("/login")
    public boolean login(@RequestBody LoginDTO dto) {
        return authService.login(dto.getNickUsuario(), dto.getContrasena());
    }
}