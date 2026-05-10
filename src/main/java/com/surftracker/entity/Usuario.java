package com.surftracker.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "usuario")

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(nullable = false, length = 100)
    private String nombres;

    @Column(nullable = false, length = 100)
    private String apellidos;

    @Column(length = 8)
    private String dni;

    @Column(nullable = false, length = 15)
    private String login;

    @Column(nullable = false, length = 200)
    private String password;

    @Column(nullable = false, length = 45)
    private String correo;

    private LocalDate fecharegistro;

    private LocalDate fechanacimiento;

    private String direccion;


}
