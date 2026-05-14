package com.surftracker.controllers;


import com.surftracker.entities.ObservacionReal;
import com.surftracker.services.ObservacionRealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/observacionreal")

public class ObservacionRealController {

    @Autowired
    private ObservacionRealService service;


    @PostMapping
    public ObservacionReal registrar(
            @RequestBody ObservacionReal o){

        return service.registrar(o);

    }


    @GetMapping
    public List<ObservacionReal> listar(){

        return service.listar();

    }


    @GetMapping("/{id}")
    public ObservacionReal buscar(
            @PathVariable Integer id){

        return service.buscarPorId(id);

    }


    @PutMapping
    public ObservacionReal actualizar(
            @RequestBody ObservacionReal o){

        return service.actualizar(o);

    }


    @DeleteMapping("/{id}")
    public void eliminar(
            @PathVariable Integer id){

        service.eliminar(id);

    }

}
