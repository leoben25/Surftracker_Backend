package com.surftracker.service;

import com.surftracker.entity.Usuario;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UsuarioService {

    public List<Usuario> listarUsuarios();

    public Optional<Usuario> obtenerUsuarioPorId(Integer id);

    public Usuario guardarUsuario(Usuario usuario);

    public void eliminarUsuario(Integer id);
}
