package com.surftracker.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SolicitudRolRequest {

    @NotNull(message = "El id del usuario es obligatorio")
    private Integer idUsuario;

    @NotBlank(message = "El rol solicitado es obligatorio")
    private String rolSolicitado;

    private String motivo;
}

