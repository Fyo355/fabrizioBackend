package edu.es.eoi.marketplace.controller;

import edu.es.eoi.marketplace.dto.UsuariosDto;
import edu.es.eoi.marketplace.service.UsuariosService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marketplace/usuarios")
public class UsuariosController {

    private final UsuariosService usuarioService;

    public UsuariosController(UsuariosService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<UsuariosDto>> findAll() {
        List<UsuariosDto> usuarios = usuarioService.findAll();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")	
    public ResponseEntity<UsuariosDto> findById(@PathVariable Integer id) {
        UsuariosDto usuario = usuarioService.findById(id);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public ResponseEntity<UsuariosDto> createUser(@RequestBody UsuariosDto usuariosDto) {
        UsuariosDto createdUser = usuarioService.create(usuariosDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }



    @PutMapping("/{id}")
    public ResponseEntity<UsuariosDto> update(@PathVariable Integer id, @RequestBody UsuariosDto usuarioDto) {
        UsuariosDto updatedUsuario = usuarioService.update(id, usuarioDto);
        return ResponseEntity.ok(updatedUsuario);
    }

    @PostMapping("/login")
    public ResponseEntity<UsuariosDto> login(@RequestParam String username, @RequestParam String password) {
        UsuariosDto usuario = usuarioService.login(username, password);
        return ResponseEntity.ok(usuario);
    }

}
