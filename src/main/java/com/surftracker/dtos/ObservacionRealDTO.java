package com.surftracker.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ObservacionRealDTO {

    private Integer id;

    private Integer idLocalizacion;

    private Date fechaObservacion;

    private Double temperaturaReal;

    private Double alturaOlasReal;

    private Double velocidadVientoReal;

    private String descripcion;

}
