package com.surftracker.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="localizacion")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Localizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_localizacion")
    private Integer id;

    @Column(name="nombre_playa")
    private String nombrePlaya;

    private String distrito;
    private String provincia;
    private String departamento;
    private String pais;

    private Double latitud;
    private Double longitud;

}
