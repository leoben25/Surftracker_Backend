package com.surftracker.repository;

import com.surftracker.entity.UsuarioHasRol;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UsuarioHasRolRepository extends JpaRepository<UsuarioHasRol, Integer> {
    List<UsuarioHasRol> findByUsuario_IdUsuario(Integer idUsuario);
    List<UsuarioHasRol> findByRolIdRol(Integer idRol);

    boolean existsByUsuario_IdUsuarioAndRol_IdRol(Integer idUsuario, Integer idRol);
}