package com.surftracker.controllers;


import com.surftracker.entities.Localizacion;
import com.surftracker.services.LocalizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/localizacion")

public class LocalizacionController {

    @Autowired
    private LocalizacionService service;



    @PostMapping
    public Localizacion registrar(
            @RequestBody Localizacion localizacion){

        return service.registrar(localizacion);

    }



    @GetMapping
    public List<Localizacion> listar(){

        return service.listar();

    }



    @GetMapping("/{id}")
    public Localizacion buscar(
            @PathVariable Integer id){

        return service.buscarPorId(id);

    }



    @PutMapping
    public Localizacion actualizar(
            @RequestBody Localizacion localizacion){

        return service.actualizar(localizacion);

    }



    @DeleteMapping("/{id}")
    public void eliminar(
            @PathVariable Integer id){

        service.eliminar(id);

    }

}
