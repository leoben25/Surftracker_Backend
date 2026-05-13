package com.example.tb1.Controller;

import com.example.tb1.Entity.Preferencia;
import com.example.tb1.Service.PreferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/Tb1/Prueba/preferencia")
public class PreferenciaController {

    @Autowired
    private PreferenciaService PreferenciaService;

    @PostMapping("/insertaPreferencia")
    public ResponseEntity<?> insertaPreferencia(@RequestBody Preferencia obj) {
        HashMap<String, Object> salida = new HashMap<>();
        obj.setIdPreferencia(0);
        Preferencia objSalida = PreferenciaService.inserta(obj);
        salida.put("data", objSalida);
        salida.put("mensaje", "Preferencia registrada correctamente");
        return ResponseEntity.ok(salida);
    }

    @GetMapping("/listaPorUsuario/{idUsuario}")
    public ResponseEntity<?> listarPorUsuario(@PathVariable int idUsuario) {
        return ResponseEntity.ok(PreferenciaService.listaPorUsuario(idUsuario));
    }
}