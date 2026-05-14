package com.surftracker.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name="consulta_pronostico")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ConsultaPronostico {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_consulta")
    private Integer id;


    @Column(name="id_usuario")
    private Integer idUsuario;


    @ManyToOne
    @JoinColumn(name="id_localizacion")
    private Localizacion localizacion;


    @Column(name="fecha_consulta")
    private Timestamp fechaConsulta;

}