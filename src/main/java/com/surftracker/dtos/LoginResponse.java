package com.surftracker.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginResponse {

    private Integer idUsuario;
    private String nombres;
    private String apellidos;
    private String login;
    private String correo;
    private String rol;
    private String token;
}