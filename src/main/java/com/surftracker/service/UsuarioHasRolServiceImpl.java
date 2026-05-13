package com.surftracker.service;

import com.surftracker.entity.UsuarioHasRol;
import com.surftracker.repository.UsuarioHasRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioHasRolServiceImpl implements UsuarioHasRolService {

    @Autowired
    private UsuarioHasRolRepository usuarioHasRolRepository;

    @Override
    public List<UsuarioHasRol> listarUsuarioHasRoles() {
        return usuarioHasRolRepository.findAll();
    }

    @Override
    public Optional<UsuarioHasRol> obtenerUsuarioHasRolPorId(Integer id) {
        return usuarioHasRolRepository.findById(id);
    }
}