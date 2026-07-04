package com.surftracker.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "pronostico")
public class Pronostico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pronostico")
    private Integer idPronostico;

    @Column(name = "id_localizacion", nullable = false)
    private Integer idLocalizacion;

    @Column(name = "id_fuente")
    private Integer idFuente;

    @Column(name = "id_usuario_creador")
    private Integer idUsuarioCreador;

    @Column(name = "fecha_generacion")
    private LocalDateTime fechaGeneracion;

    @Column(name = "fecha_pronostico", nullable = false)
    private LocalDate fechaPronostico;

    private Double temperatura;

    @Column(name = "altura_olas")
    private Double alturaOlas;

    @Column(name = "periodo_olas")
    private Double periodoOlas;

    @Column(name = "direccion_olas", length = 50)
    private String direccionOlas;

    @Column(name = "velocidad_viento")
    private Double velocidadViento;

    @Column(name = "direccion_viento", length = 50)
    private String direccionViento;

    private Double humedad;
    private Double lluvia;
    private Double nubosidad;

    @Column(name = "radiacion_solar")
    private Double radiacionSolar;

    @PrePersist
    public void prePersist() {
        if (fechaGeneracion == null) {
            fechaGeneracion = LocalDateTime.now();
        }
    }
}
