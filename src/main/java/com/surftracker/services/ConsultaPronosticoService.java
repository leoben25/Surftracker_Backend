package com.surftracker.services;


import com.surftracker.entities.ConsultaPronostico;
import java.util.List;

public interface ConsultaPronosticoService {

    ConsultaPronostico registrar(
            ConsultaPronostico consulta);

    List<ConsultaPronostico> listar();

    ConsultaPronostico buscarPorId(
            Integer id);

    ConsultaPronostico actualizar(
            ConsultaPronostico consulta);

    void eliminar(Integer id);

}
