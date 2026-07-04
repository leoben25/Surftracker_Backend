package com.surftracker.controller;

import com.surftracker.dtos.PronosticoRegistroRequest;
import com.surftracker.entity.Pronostico;
import com.surftracker.service.PronosticoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/pronosticos")
@CrossOrigin(origins = "*")
public class PronosticoController {

    @Autowired
    private PronosticoService pronosticoService;

    // Endpoint antiguo conservado para que no se rompa lo que ya tenías.
    @PostMapping("/InsertaPronostico")
    public ResponseEntity<?> InsertaPronostico(@RequestBody Pronostico obj) {
        HashMap<String, Object> salida = new HashMap<>();
        obj.setIdPronostico(null);
        Pronostico objSalida = pronosticoService.inserta(obj);
        salida.put("data", objSalida);
        salida.put("mensaje", "Registro de pronóstico exitoso");
        return ResponseEntity.ok(salida);
    }

    // Endpoint recomendado para el frontend.
    @PostMapping("/registro")
    public ResponseEntity<Map<String, Object>> registrarPronostico(@Valid @RequestBody PronosticoRegistroRequest request) {
        Pronostico pronostico = pronosticoService.registrarPronostico(request);

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("mensaje", "Pronóstico registrado correctamente");
        respuesta.put("data", pronostico);

        return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
    }

    @GetMapping("/listaTodos")
    public ResponseEntity<?> listarTodos() {
        return ResponseEntity.ok(pronosticoService.listaTodos());
    }

    @GetMapping("/listaPorLocalizacion/{id}")
    public ResponseEntity<?> listarPorLocalizacion(@PathVariable Integer id) {
        return ResponseEntity.ok(pronosticoService.listaPorLocalizacion(id));
    }

    @GetMapping("/localizacion/{idLocalizacion}/fecha/{fecha}")
    public ResponseEntity<?> consultarPorLocalizacionYFecha(
            @PathVariable Integer idLocalizacion,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {

        return ResponseEntity.ok(pronosticoService.consultaPorLocalizacionYFecha(idLocalizacion, fecha));
    }

    @GetMapping("/localizacion/{idLocalizacion}/rango")
    public ResponseEntity<?> consultarPorRangoFechas(
            @PathVariable Integer idLocalizacion,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate desde,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate hasta) {

        return ResponseEntity.ok(pronosticoService.consultaPorLocalizacionYRangoFechas(idLocalizacion, desde, hasta));
    }

    @PutMapping("/{idPronostico}")
    public ResponseEntity<Map<String, Object>> actualizarPronostico(
            @PathVariable Integer idPronostico,
            @Valid @RequestBody PronosticoRegistroRequest request) {

        Pronostico pronostico = pronosticoService.actualizarPronostico(idPronostico, request);

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("mensaje", "Pronóstico actualizado correctamente");
        respuesta.put("data", pronostico);

        return ResponseEntity.ok(respuesta);
    }
}
