package com.surftracker.repository;

import com.surftracker.entity.SolicitudRol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SolicitudRolRepository extends JpaRepository<SolicitudRol, Integer> {

    List<SolicitudRol> findByEstado(String estado);

    List<SolicitudRol> findByUsuario_IdUsuario(Integer idUsuario);

    boolean existsByUsuario_IdUsuarioAndEstado(Integer idUsuario, String estado);
}
