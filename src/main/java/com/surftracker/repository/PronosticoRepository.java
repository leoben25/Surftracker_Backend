package com.surftracker.repository;

import com.surftracker.entity.Pronostico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PronosticoRepository extends JpaRepository<Pronostico, Integer> {

    List<Pronostico> findByIdLocalizacion(Integer idLocalizacion);

    List<Pronostico> findByFechaPronostico(LocalDate fecha);

    Optional<Pronostico> findByIdLocalizacionAndFechaPronostico(Integer idLocalizacion, LocalDate fechaPronostico);

    List<Pronostico> findByIdLocalizacionAndFechaPronosticoBetweenOrderByFechaPronosticoAsc(
            Integer idLocalizacion,
            LocalDate fechaInicio,
            LocalDate fechaFin
    );

    @Query("select f from Pronostico f where f.temperatura between ?1 and ?2")
    List<Pronostico> findByTemperaturaBetween(Double min, Double max);
}
