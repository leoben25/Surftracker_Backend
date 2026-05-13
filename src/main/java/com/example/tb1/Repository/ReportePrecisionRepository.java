package com.example.tb1.Repository;

import com.example.tb1.Entity.ReportePrecision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ReportePrecisionRepository extends JpaRepository<ReportePrecision, Integer> {

    public abstract List<ReportePrecision> findByFechaReporte(LocalDate fecha);


    public abstract List<ReportePrecision> findByPorcentajePrecisionGreaterThanEqual(double precisionMinima);


    @Query("select r from ReportePrecision r where r.pronostico.idPronostico = ?1")
    public abstract List<ReportePrecision> findByPronosticoIdPronostico(int idPronostico);

}