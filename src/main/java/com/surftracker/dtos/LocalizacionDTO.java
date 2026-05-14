package com.surftracker.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class LocalizacionDTO {

    private Integer id;

    private String nombrePlaya;

    private String distrito;

    private String provincia;

    private String departamento;

    private String pais;

    private Double latitud;

    private Double longitud;

}
