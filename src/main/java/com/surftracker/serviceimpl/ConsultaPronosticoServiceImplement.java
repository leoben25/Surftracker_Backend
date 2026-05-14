package com.surftracker.serviceimpl;


import com.surftracker.entities.ConsultaPronostico;
import com.surftracker.repositories.ConsultaPronosticoRepository;
import com.surftracker.services.ConsultaPronosticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ConsultaPronosticoServiceImplement implements ConsultaPronosticoService {

    @Autowired
    private ConsultaPronosticoRepository repository;


    @Override
    public ConsultaPronostico registrar(
            ConsultaPronostico consulta){

        return repository.save(consulta);

    }

    @Override
    public List<ConsultaPronostico> listar(){

        return repository.findAll();

    }

    @Override
    public ConsultaPronostico buscarPorId(
            Integer id){

        return repository.findById(id)
                .orElse(null);

    }

    @Override
    public ConsultaPronostico actualizar(
            ConsultaPronostico consulta){

        return repository.save(consulta);

    }

    @Override
    public void eliminar(Integer id){

        repository.deleteById(id);

    }

}
