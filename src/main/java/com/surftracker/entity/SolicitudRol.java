package com.surftracker.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "solicitud_rol")
public class SolicitudRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitud")
    private Integer idSolicitud;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Column(name = "rol_actual", nullable = false, length = 30)
    private String rolActual;

    @Column(name = "rol_solicitado", nullable = false, length = 30)
    private String rolSolicitado;

    @Column(length = 255)
    private String motivo;

    @Column(nullable = false, length = 30)
    private String estado;

    @Column(name = "comentario_admin", length = 255)
    private String comentarioAdmin;

    @ManyToOne
    @JoinColumn(name = "id_admin_respuesta")
    private Usuario adminRespuesta;

    @Column(name = "fecha_solicitud")
    private LocalDateTime fechaSolicitud;

    @Column(name = "fecha_respuesta")
    private LocalDateTime fechaRespuesta;

    @PrePersist
    public void prePersist() {
        if (fechaSolicitud == null) {
            fechaSolicitud = LocalDateTime.now();
        }
        if (estado == null || estado.isBlank()) {
            estado = "PENDIENTE";
        }
    }
}

