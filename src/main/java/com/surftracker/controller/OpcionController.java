package com.surftracker.controller;

import com.surftracker.entity.Opcion;
import com.surftracker.service.OpcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/opciones")
@CrossOrigin(origins = "*")
public class OpcionController {

    @Autowired
    private OpcionService opcionService;

    @GetMapping
    public List<Opcion> listarOpciones() {
        return opcionService.listarOpciones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Opcion> obtenerOpcionPorId(@PathVariable Integer id) {
        Optional<Opcion> opcion = opcionService.obtenerOpcionPorId(id);
        return opcion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Opcion> registrarOpcion(@RequestBody Opcion opcion) {
        Opcion nuevaOpcion = opcionService.guardarOpcion(opcion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaOpcion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarOpcion(@PathVariable Integer id) {
        opcionService.eliminarOpcion(id);
        return ResponseEntity.noContent().build();
    }
}
