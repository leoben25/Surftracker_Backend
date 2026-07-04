package com.surftracker.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class RegistroClienteRequest {

    @NotBlank(message = "Los nombres son obligatorios")
    @Size(max = 100)
    private String nombres;

    @NotBlank(message = "Los apellidos son obligatorios")
    @Size(max = 100)
    private String apellidos;

    @Size(max = 8)
    private String dni;

    @NotBlank(message = "El login es obligatorio")
    @Size(max = 15)
    private String login;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 4, max = 200)
    private String password;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El correo no tiene un formato válido")
    @Size(max = 45)
    private String correo;

    @Size(max = 20)
    private String telefono;

    private LocalDate fechanacimiento;

    private String direccion;
}

