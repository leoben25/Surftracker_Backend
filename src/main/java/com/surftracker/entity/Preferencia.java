package com.surftracker.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "preferencia_usuario")
public class Preferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_preferencia")
    private int idPreferencia;

    @Column(name = "id_usuario")
    private int idUsuario;

    @Column(name = "tema")
    private String tema;

    @Column(name = "frecuencia_notificaciones")
    private String frecuenciaNotificaciones;

    @Column(name = "recibir_alertas")
    private boolean recibirAlertas;

    @Column(name = "tipo_informacion_preferida")
    private String tipoInformacionPreferida;

    @ManyToOne
    @JoinColumn(name = "id_pronostico")
    private Pronostico pronostico;
}