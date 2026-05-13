package com.example.tb1.Entity;

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
    private int idPreferencia;

    private int idUsuario;
    private String tema;
    private String frecuenciaNotificaciones;
    private boolean recibirAlertas;
    private String tipoInformacionPreferida;

    @ManyToOne
    @JoinColumn(name = "idPronostico")
    private Pronostico pronostico;

}