package com.surftracker.services;

import com.surftracker.entities.Localizacion;
import java.util.List;

public interface LocalizacionService {

    Localizacion registrar(Localizacion localizacion);

    List<Localizacion> listar();

    Localizacion buscarPorId(Integer id);

    Localizacion actualizar(Localizacion localizacion);

    void eliminar(Integer id);

}
