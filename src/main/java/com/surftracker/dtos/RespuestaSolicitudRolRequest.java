package com.surftracker.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespuestaSolicitudRolRequest {

    @NotBlank(message = "El estado es obligatorio")
    private String estado;

    @NotNull(message = "El id del administrador es obligatorio")
    private Integer idAdminRespuesta;

    private String comentarioAdmin;
}
