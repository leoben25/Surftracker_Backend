package com.surftracker.services;

import com.surftracker.entities.ObservacionReal;

import java.util.List;

public interface ObservacionRealService {

    ObservacionReal registrar(
            ObservacionReal observacion);

    List<ObservacionReal> listar();

    ObservacionReal buscarPorId(
            Integer id);

    ObservacionReal actualizar(
            ObservacionReal observacion);

    void eliminar(Integer id);

}
