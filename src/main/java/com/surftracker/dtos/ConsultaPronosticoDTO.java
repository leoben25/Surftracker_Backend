package com.surftracker.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ConsultaPronosticoDTO {

    private Integer id;

    private Integer idUsuario;

    private Integer idLocalizacion;

    private Timestamp fechaConsulta;

}
