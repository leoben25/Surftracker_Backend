package com.surftracker.repository;

import com.surftracker.entity.UsuarioHasRol;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UsuarioHasRolRepository extends JpaRepository<UsuarioHasRol, Integer> {
    List<UsuarioHasRol> findByUsuarioIdUsuario(Integer idUsuario);
    List<UsuarioHasRol> findByRolIdRol(Integer idRol);
}