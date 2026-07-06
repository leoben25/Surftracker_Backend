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

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombres;

    @Column(name = "apellido", length = 100)
    private String apellidos;

    @Column(length = 8)
    private String dni;

    @Column(nullable = false, length = 15)
    private String login;

    @Column(nullable = false, length = 200)
    private String password;

    @Column(name = "email", nullable = false, length = 150)
    private String correo;

    @Column(name = "fecha_registro")
    private LocalDate fecharegistro;

    private LocalDate fechanacimiento;

    private String direccion;

    @Column(length = 20)
    private String telefono;

    @Column(length = 30)
    private String estado;

    @Column(length = 30)
    private String rol;
}