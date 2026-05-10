package com.surftracker.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "opcion")

public class Opcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_opcion")
    private Integer idopcion;

    @Column(nullable = false, length = 45)
    private String nombre;

    @Column(length = 45)
    private String estado;

    private String ruta;

    private short tipo;
}
