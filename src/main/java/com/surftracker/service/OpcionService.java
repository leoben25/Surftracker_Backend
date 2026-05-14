package com.surftracker.service;

import com.surftracker.entity.Opcion;



import java.util.List;
import java.util.Optional;


public interface OpcionService {


    public List<Opcion> listarOpciones();

    public Optional<Opcion> obtenerOpcionPorId(Integer id);

    public Opcion guardarOpcion(Opcion opcion);

    public void eliminarOpcion(Integer id);
}
