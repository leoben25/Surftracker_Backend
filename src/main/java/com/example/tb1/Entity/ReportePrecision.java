package com.example.tb1.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "reporte_precision")
public class ReportePrecision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReporte;

    private int idObservacion;
    private double porcentajePrecision;
    private double diferencia;
    private LocalDate fechaReporte;


    @ManyToOne
    @JoinColumn(name = "id_pronostico")
    private Pronostico pronostico;
}