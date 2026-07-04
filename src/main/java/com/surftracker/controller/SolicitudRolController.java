package com.surftracker.controller;

import com.surftracker.dtos.RespuestaSolicitudRolRequest;
import com.surftracker.dtos.SolicitudRolRequest;
import com.surftracker.entity.SolicitudRol;
import com.surftracker.service.SolicitudRolService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/solicitudes-rol")
@CrossOrigin(origins = "*")
public class SolicitudRolController {

    private final SolicitudRolService solicitudRolService;

    public SolicitudRolController(SolicitudRolService solicitudRolService) {
        this.solicitudRolService = solicitudRolService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> registrarSolicitud(@Valid @RequestBody SolicitudRolRequest request) {
        SolicitudRol solicitud = solicitudRolService.registrarSolicitud(request);

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("mensaje", "Solicitud registrada correctamente");
        respuesta.put("data", solicitud);

        return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
    }

    @GetMapping
    public List<SolicitudRol> listarTodas() {
        return solicitudRolService.listarTodas();
    }

    @GetMapping("/pendientes")
    public List<SolicitudRol> listarPendientes() {
        return solicitudRolService.listarPendientes();
    }

    @GetMapping("/usuario/{idUsuario}")
    public List<SolicitudRol> listarPorUsuario(@PathVariable Integer idUsuario) {
        return solicitudRolService.listarPorUsuario(idUsuario);
    }

    @GetMapping("/{idSolicitud}")
    public SolicitudRol obtenerPorId(@PathVariable Integer idSolicitud) {
        return solicitudRolService.obtenerPorId(idSolicitud);
    }

    @PutMapping("/{idSolicitud}/estado")
    public ResponseEntity<Map<String, Object>> responderSolicitud(
            @PathVariable Integer idSolicitud,
            @Valid @RequestBody RespuestaSolicitudRolRequest request) {

        SolicitudRol solicitud = solicitudRolService.responderSolicitud(idSolicitud, request);

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("mensaje", "Solicitud actualizada correctamente");
        respuesta.put("data", solicitud);

        return ResponseEntity.ok(respuesta);
    }

    @PutMapping("/{idSolicitud}/aprobar")
    public ResponseEntity<Map<String, Object>> aprobarSolicitud(
            @PathVariable Integer idSolicitud,
            @RequestParam Integer idAdminRespuesta,
            @RequestParam(required = false) String comentarioAdmin) {

        RespuestaSolicitudRolRequest request = new RespuestaSolicitudRolRequest();
        request.setEstado("APROBADA");
        request.setIdAdminRespuesta(idAdminRespuesta);
        request.setComentarioAdmin(comentarioAdmin);

        SolicitudRol solicitud = solicitudRolService.responderSolicitud(idSolicitud, request);

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("mensaje", "Solicitud aprobada y rol asignado correctamente");
        respuesta.put("data", solicitud);

        return ResponseEntity.ok(respuesta);
    }

    @PutMapping("/{idSolicitud}/rechazar")
    public ResponseEntity<Map<String, Object>> rechazarSolicitud(
            @PathVariable Integer idSolicitud,
            @RequestParam Integer idAdminRespuesta,
            @RequestParam(required = false) String comentarioAdmin) {

        RespuestaSolicitudRolRequest request = new RespuestaSolicitudRolRequest();
        request.setEstado("RECHAZADA");
        request.setIdAdminRespuesta(idAdminRespuesta);
        request.setComentarioAdmin(comentarioAdmin);

        SolicitudRol solicitud = solicitudRolService.responderSolicitud(idSolicitud, request);

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("mensaje", "Solicitud rechazada correctamente");
        respuesta.put("data", solicitud);

        return ResponseEntity.ok(respuesta);
    }
}
