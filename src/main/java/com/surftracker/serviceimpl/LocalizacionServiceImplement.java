package com.surftracker.serviceimpl;


import com.surftracker.entities.Localizacion;
import com.surftracker.repositories.LocalizacionRepository;
import com.surftracker.services.LocalizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class LocalizacionServiceImplement implements LocalizacionService {

    @Autowired
    private LocalizacionRepository repository;


    @Override
    public Localizacion registrar(
            Localizacion localizacion) {

        return repository.save(localizacion);

    }

    @Override
    public List<Localizacion> listar() {

        return repository.findAll();

    }

    @Override
    public Localizacion buscarPorId(Integer id) {

        return repository.findById(id)
                .orElse(null);

    }

    @Override
    public Localizacion actualizar(
            Localizacion localizacion) {

        return repository.save(localizacion);

    }

    @Override
    public void eliminar(Integer id) {

        repository.deleteById(id);

    }

}
