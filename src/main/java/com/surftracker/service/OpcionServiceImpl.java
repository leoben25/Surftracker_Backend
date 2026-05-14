package com.surftracker.service;

import com.surftracker.entity.Opcion;
import com.surftracker.repository.OpcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OpcionServiceImpl implements OpcionService {

    @Autowired
    private OpcionRepository opcionRepository;

    @Override
    public List<Opcion> listarOpciones() {
        return opcionRepository.findAll();
    }

    @Override
    public Optional<Opcion> obtenerOpcionPorId(Integer id) {
        return opcionRepository.findById(id);
    }

    @Override
    public Opcion guardarOpcion(Opcion opcion) {
        return opcionRepository.save(opcion);
    }

    @Override
    public void eliminarOpcion(Integer id) {
        opcionRepository.deleteById(id);
    }
}
