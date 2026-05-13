package com.example.tb1.Controller;

import com.example.tb1.Entity.ReportePrecision;
import com.example.tb1.Service.ReportePrecisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;

@RestController
@RequestMapping("/Tb1/Prueba/reporte")
public class ReportePrecisionController {

    @Autowired
    private ReportePrecisionService reportService;

    @PostMapping("/insertaReporte")
    public ResponseEntity<?> insertaReporte(@RequestBody ReportePrecision obj) {
        HashMap<String, Object> salida = new HashMap<>();
        obj.setIdReporte(0);
        ReportePrecision objSalida = reportService.inserta(obj);
        salida.put("data", objSalida);
        salida.put("mensaje", "Reporte generado con éxito");
        return ResponseEntity.ok(salida);
    }

    @GetMapping("/listaPorFecha")
    public ResponseEntity<?> listarPorFecha(@RequestParam String fecha) {
        LocalDate localDate = LocalDate.parse(fecha);
        return ResponseEntity.ok(reportService.listaPorFechaReporte(localDate));
    }
}