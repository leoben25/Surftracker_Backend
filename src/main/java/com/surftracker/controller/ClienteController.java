package com.surftracker.controller;

import com.surftracker.dtos.RegistroClienteRequest;
import com.surftracker.entity.Usuario;
import com.surftracker.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/registro")
    public ResponseEntity<Map<String, Object>> registrarCliente(@Valid @RequestBody RegistroClienteRequest request) {
        Usuario usuario = clienteService.registrarCliente(request);

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("mensaje", "Cliente registrado correctamente");
        respuesta.put("data", usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
    }
}
