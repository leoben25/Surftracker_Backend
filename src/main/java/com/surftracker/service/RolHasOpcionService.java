package com.surftracker.service;

import com.surftracker.entity.Opcion;
import com.surftracker.entity.RolHasOpcion;
import java.util.List;
import java.util.Optional;

public interface RolHasOpcionService {

    public List<RolHasOpcion> listarTodos();

    public Optional<RolHasOpcion> obtenerPorId(Integer id);

    public Opcion guardarOpcion(Opcion opcion);

    public void eliminarOpcion(Integer id);
}