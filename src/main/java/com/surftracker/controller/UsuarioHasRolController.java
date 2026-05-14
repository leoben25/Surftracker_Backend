package com.surftracker.controller;

import com.surftracker.entity.UsuarioHasRol;
import com.surftracker.service.UsuarioHasRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuario-has-rol")
public class UsuarioHasRolController {

    @Autowired
    private UsuarioHasRolService service;

    @GetMapping
    public List<UsuarioHasRol> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioHasRol> obtenerPorId(@PathVariable Integer id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/usuario/{idUsuario}")
    public List<UsuarioHasRol> listarPorUsuario(@PathVariable Integer idUsuario) {
        return service.listarPorUsuario(idUsuario);
    }

    @PostMapping
    public ResponseEntity<UsuarioHasRol> crear(@RequestBody UsuarioHasRol usuarioHasRol) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(usuarioHasRol));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}