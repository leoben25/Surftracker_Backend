package com.surftracker.serviceimpl;

import com.surftracker.entities.ObservacionReal;
import com.surftracker.repositories.ObservacionRealRepository;
import com.surftracker.services.ObservacionRealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObservacionRealServiceImplement
        implements ObservacionRealService {

    @Autowired
    private ObservacionRealRepository repository;


    @Override
    public ObservacionReal registrar(
            ObservacionReal observacion){

        return repository.save(observacion);

    }

    @Override
    public List<ObservacionReal> listar(){

        return repository.findAll();

    }

    @Override
    public ObservacionReal buscarPorId(
            Integer id){

        return repository.findById(id)
                .orElse(null);

    }

    @Override
    public ObservacionReal actualizar(
            ObservacionReal observacion){

        return repository.save(observacion);

    }

    @Override
    public void eliminar(Integer id){

        repository.deleteById(id);

    }

}
