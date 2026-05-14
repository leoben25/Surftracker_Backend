package com.surftracker.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name="observacion_real")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ObservacionReal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_observacion")
    private Integer id;


    @ManyToOne
    @JoinColumn(name="id_localizacion")
    private Localizacion localizacion;


    @Column(name="fecha_observacion")
    private Date fechaObservacion;


    @Column(name="temperatura_real")
    private Double temperaturaReal;


    @Column(name="altura_olas_real")
    private Double alturaOlasReal;


    @Column(name="velocidad_viento_real")
    private Double velocidadVientoReal;

    private String descripcion;
}
