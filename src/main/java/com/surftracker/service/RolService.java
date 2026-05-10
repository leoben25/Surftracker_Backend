package com.surftracker.service;

import com.surftracker.entity.Rol;


import java.util.List;
import java.util.Optional;


public interface RolService {

    public List<Rol> listarRoles();

    public Optional<Rol> obtenerRolPorId(Integer id);

}
