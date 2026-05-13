package com.example.tb1.Repository;

import com.example.tb1.Entity.Pronostico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface PronosticoRepository extends JpaRepository<Pronostico, Integer> {


    public abstract List<Pronostico> findByIdLocalizacion(int idLocalizacion);

    public abstract List<Pronostico> findByFechaPronostico(LocalDate fecha);


    @Query("select f from Pronostico f where f.temperatura between ?1 and ?2")
    public abstract List<Pronostico> findByTemperaturaBetween(double min, double max);

}