package com.surftracker.repository;

import com.surftracker.entity.RolHasOpcion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RolHasOpcionRepository extends JpaRepository<RolHasOpcion, Integer> {

    List<RolHasOpcion> findByRolIdRol(Integer idRol);

    List<RolHasOpcion> findByOpcionIdOpcion(Integer idOpcion);
}