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

    // En Java usamos "nombres", pero en la BD tu columna real se llama "nombre"
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombres;

    // En Java usamos "apellidos", pero en la BD tu columna real se llama "apellido"
    @Column(name = "apellido", length = 100)
    private String apellidos;

    @Column(length = 8)
    private String dni;

    @Column(nullable = false, length = 15)
    private String login;

    @Column(nullable = false, length = 200)
    private String password;

    // En Java usamos "correo", pero en la BD tu columna real se llama "email"
    @Column(name = "email", nullable = false, length = 150)
    private String correo;

    // En Java usamos "fecharegistro", pero en la BD tu columna real se llama "fecha_registro"
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