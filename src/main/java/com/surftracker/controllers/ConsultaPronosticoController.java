package com.surftracker.controllers;

import com.surftracker.entities.ConsultaPronostico;
import com.surftracker.services.ConsultaPronosticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/consultapronostico")

public class ConsultaPronosticoController {

    @Autowired
    private ConsultaPronosticoService service;


    @PostMapping
    public ConsultaPronostico registrar(
            @RequestBody ConsultaPronostico c){

        return service.registrar(c);

    }


    @GetMapping
    public List<ConsultaPronostico> listar(){

        return service.listar();

    }


    @GetMapping("/{id}")
    public ConsultaPronostico buscar(
            @PathVariable Integer id){

        return service.buscarPorId(id);

    }


    @PutMapping
    public ConsultaPronostico actualizar(
            @RequestBody ConsultaPronostico c){

        return service.actualizar(c);

    }


    @DeleteMapping("/{id}")
    public void eliminar(
            @PathVariable Integer id){

        service.eliminar(id);

    }

}
