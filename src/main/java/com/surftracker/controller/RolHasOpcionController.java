package com.surftracker.controller;

import com.surftracker.entity.RolHasOpcion;
import com.surftracker.service.RolHasOpcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rol-has-opcion")
@CrossOrigin(origins = "*")
public class RolHasOpcionController {

    @Autowired
    private RolHasOpcionService service;

    @GetMapping
    public List<RolHasOpcion> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolHasOpcion> obtenerPorId(@PathVariable Integer id) {
        return service.obtenerPorId(id);

    }

    @GetMapping("/rol/{idRol}")
    public List<RolHasOpcion> listarPorRol(@PathVariable Integer idRol) {
        return service.listarPorRol(idRol);
    }

    @PostMapping
    public ResponseEntity<RolHasOpcion> crear(@RequestBody RolHasOpcion rolHasOpcion) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(rolHasOpcion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}