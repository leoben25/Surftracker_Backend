package com.surftracker.service;

import com.surftracker.dtos.PronosticoRegistroRequest;
import com.surftracker.entity.Pronostico;
import com.surftracker.repository.LocalizacionRepository;
import com.surftracker.repository.PronosticoRepository;
import com.surftracker.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PronosticoServiceImpl implements PronosticoService {

    @Autowired
    private PronosticoRepository repository;

    @Autowired
    private LocalizacionRepository localizacionRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Pronostico inserta(Pronostico pronostico) {
        validarPronostico(pronostico);
        if (pronostico.getFechaGeneracion() == null) {
            pronostico.setFechaGeneracion(LocalDateTime.now());
        }
        return repository.save(pronostico);
    }

    @Override
    public Pronostico registrarPronostico(PronosticoRegistroRequest request) {
        Pronostico pronostico = new Pronostico();
        copiarRequestAEntidad(request, pronostico);
        pronostico.setFechaGeneracion(LocalDateTime.now());
        return inserta(pronostico);
    }

    @Override
    public List<Pronostico> listaTodos() {
        return repository.findAll();
    }

    @Override
    public List<Pronostico> listaPorLocalizacion(Integer idLocalizacion) {
        return repository.findByIdLocalizacion(idLocalizacion);
    }

    @Override
    public List<Pronostico> listaPorFecha(LocalDate fecha) {
        return repository.findByFechaPronostico(fecha);
    }

    @Override
    public List<Pronostico> listaPorRangoTemperaturas(Double min, Double max) {
        return repository.findByTemperaturaBetween(min, max);
    }

    @Override
    public Pronostico consultaPorLocalizacionYFecha(Integer idLocalizacion, LocalDate fecha) {
        return repository.findByIdLocalizacionAndFechaPronostico(idLocalizacion, fecha)
                .orElseThrow(() -> new IllegalArgumentException("No existe pronóstico para esa localización y fecha"));
    }

    @Override
    public List<Pronostico> consultaPorLocalizacionYRangoFechas(Integer idLocalizacion, LocalDate desde, LocalDate hasta) {
        if (desde.isAfter(hasta)) {
            throw new IllegalArgumentException("La fecha desde no puede ser mayor que la fecha hasta");
        }
        return repository.findByIdLocalizacionAndFechaPronosticoBetweenOrderByFechaPronosticoAsc(idLocalizacion, desde, hasta);
    }

    @Override
    public Pronostico actualizarPronostico(Integer idPronostico, PronosticoRegistroRequest request) {
        Pronostico pronostico = repository.findById(idPronostico)
                .orElseThrow(() -> new IllegalArgumentException("No existe el pronóstico con id " + idPronostico));
        copiarRequestAEntidad(request, pronostico);
        validarPronostico(pronostico);
        return repository.save(pronostico);
    }

    private void copiarRequestAEntidad(PronosticoRegistroRequest request, Pronostico pronostico) {
        pronostico.setIdLocalizacion(request.getIdLocalizacion());
        pronostico.setIdFuente(request.getIdFuente());
        pronostico.setIdUsuarioCreador(request.getIdUsuarioCreador());
        pronostico.setFechaPronostico(request.getFechaPronostico());
        pronostico.setTemperatura(request.getTemperatura());
        pronostico.setAlturaOlas(request.getAlturaOlas());
        pronostico.setPeriodoOlas(request.getPeriodoOlas());
        pronostico.setDireccionOlas(request.getDireccionOlas());
        pronostico.setVelocidadViento(request.getVelocidadViento());
        pronostico.setDireccionViento(request.getDireccionViento());
        pronostico.setHumedad(request.getHumedad());
        pronostico.setLluvia(request.getLluvia());
        pronostico.setNubosidad(request.getNubosidad());
        pronostico.setRadiacionSolar(request.getRadiacionSolar());
    }

    private void validarPronostico(Pronostico pronostico) {
        if (pronostico.getIdLocalizacion() == null) {
            throw new IllegalArgumentException("La localización es obligatoria");
        }
        if (!localizacionRepository.existsById(pronostico.getIdLocalizacion())) {
            throw new IllegalArgumentException("No existe la localización con id " + pronostico.getIdLocalizacion());
        }
        if (pronostico.getFechaPronostico() == null) {
            throw new IllegalArgumentException("La fecha del pronóstico es obligatoria");
        }
        if (pronostico.getIdUsuarioCreador() != null && !usuarioRepository.existsById(pronostico.getIdUsuarioCreador())) {
            throw new IllegalArgumentException("No existe el usuario creador con id " + pronostico.getIdUsuarioCreador());
        }
    }
}
