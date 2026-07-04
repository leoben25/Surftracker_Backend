package com.surftracker.service;

import com.surftracker.dtos.PronosticoRegistroRequest;
import com.surftracker.entity.Pronostico;

import java.time.LocalDate;
import java.util.List;

public interface PronosticoService {

    Pronostico inserta(Pronostico pronostico);

    Pronostico registrarPronostico(PronosticoRegistroRequest request);

    List<Pronostico> listaTodos();

    List<Pronostico> listaPorLocalizacion(Integer idLocalizacion);

    List<Pronostico> listaPorFecha(LocalDate fecha);

    List<Pronostico> listaPorRangoTemperaturas(Double min, Double max);

    Pronostico consultaPorLocalizacionYFecha(Integer idLocalizacion, LocalDate fecha);

    List<Pronostico> consultaPorLocalizacionYRangoFechas(Integer idLocalizacion, LocalDate desde, LocalDate hasta);

    Pronostico actualizarPronostico(Integer idPronostico, PronosticoRegistroRequest request);
}
