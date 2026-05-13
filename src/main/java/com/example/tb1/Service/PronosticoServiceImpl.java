package com.example.tb1.Service;

import com.example.tb1.Entity.Pronostico;
import com.example.tb1.Repository.PronosticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PronosticoServiceImpl implements PronosticoService {

    @Autowired
    private PronosticoRepository repository;

    @Override
    public Pronostico inserta(Pronostico pronostico) {
        return repository.save(pronostico);
    }

    @Override
    public List<Pronostico> listaTodos() {
        return repository.findAll();
    }

    @Override
    public List<Pronostico> listaPorLocalizacion(int idLocalizacion) {
        return repository.findByIdLocalizacion(idLocalizacion);
    }

    @Override
    public List<Pronostico> listaPorFecha(LocalDate fecha) {
        return repository.findByFechaPronostico(fecha);
    }

    @Override
    public List<Pronostico> listaPorRangoTemperaturas(double min, double max) {
        return repository.findByTemperaturaBetween(min, max);
    }
}