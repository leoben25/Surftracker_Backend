package com.surftracker.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PronosticoRegistroRequest {

    @NotNull(message = "La localización es obligatoria")
    private Integer idLocalizacion;

    private Integer idFuente;

    private Integer idUsuarioCreador;

    @NotNull(message = "La fecha del pronóstico es obligatoria")
    private LocalDate fechaPronostico;

    private Double temperatura;
    private Double alturaOlas;
    private Double periodoOlas;
    private String direccionOlas;
    private Double velocidadViento;
    private String direccionViento;
    private Double humedad;
    private Double lluvia;
    private Double nubosidad;
    private Double radiacionSolar;
}
