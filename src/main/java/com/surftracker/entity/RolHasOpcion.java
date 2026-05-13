package com.surftracker.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "rol_has_opcion")
public class RolHasOpcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idrol", nullable = false)
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "idopcion", nullable = false)
    private Opcion opcion;

    private LocalDate fechaAsignacion;

    // --- Getters y Setters ---
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Rol getRol() { return rol; }
    public void setRol(Rol rol) { this.rol = rol; }

    public Opcion getOpcion() { return opcion; }
    public void setOpcion(Opcion opcion) { this.opcion = opcion; }

    public LocalDate getFechaAsignacion() { return fechaAsignacion; }
    public void setFechaAsignacion(LocalDate fechaAsignacion) { this.fechaAsignacion = fechaAsignacion; }
}