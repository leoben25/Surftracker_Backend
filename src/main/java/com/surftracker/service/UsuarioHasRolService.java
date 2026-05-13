package com.surftracker.service;

import com.surftracker.entity.UsuarioHasRol;
import java.util.List;
import java.util.Optional;

public interface UsuarioHasRolService {
    public List<UsuarioHasRol> listarUsuarioHasRoles();
    public Optional<UsuarioHasRol> obtenerUsuarioHasRolPorId(Integer id);
}