package com.surftracker.service;

import com.surftracker.dtos.RegistroClienteRequest;
import com.surftracker.entity.Rol;
import com.surftracker.entity.Usuario;
import com.surftracker.entity.UsuarioHasRol;
import com.surftracker.repository.RolRepository;
import com.surftracker.repository.UsuarioHasRolRepository;
import com.surftracker.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class ClienteService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final UsuarioHasRolRepository usuarioHasRolRepository;

    public ClienteService(UsuarioRepository usuarioRepository,
                          RolRepository rolRepository,
                          UsuarioHasRolRepository usuarioHasRolRepository) {
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
        this.usuarioHasRolRepository = usuarioHasRolRepository;
    }

    @Transactional
    public Usuario registrarCliente(RegistroClienteRequest request) {
        if (usuarioRepository.existsByLogin(request.getLogin())) {
            throw new IllegalArgumentException("Ya existe un usuario con ese login");
        }
        if (usuarioRepository.existsByCorreo(request.getCorreo())) {
            throw new IllegalArgumentException("Ya existe un usuario con ese correo");
        }

        Usuario usuario = new Usuario();
        usuario.setNombres(request.getNombres());
        usuario.setApellidos(request.getApellidos());
        usuario.setDni(request.getDni());
        usuario.setLogin(request.getLogin());
        usuario.setPassword(request.getPassword());
        usuario.setCorreo(request.getCorreo());
        usuario.setTelefono(request.getTelefono());
        usuario.setFechanacimiento(request.getFechanacimiento());
        usuario.setDireccion(request.getDireccion());
        usuario.setFecharegistro(LocalDate.now());
        usuario.setEstado("ACTIVO");

        Usuario usuarioGuardado = usuarioRepository.save(usuario);

        Rol rolCliente = rolRepository.findByNombreIgnoreCase("CLIENTE")
                .orElseGet(() -> {
                    Rol nuevoRol = new Rol();
                    nuevoRol.setNombre("CLIENTE");
                    nuevoRol.setEstado("ACTIVO");
                    return rolRepository.save(nuevoRol);
                });

        UsuarioHasRol usuarioHasRol = new UsuarioHasRol();
        usuarioHasRol.setUsuario(usuarioGuardado);
        usuarioHasRol.setRol(rolCliente);
        usuarioHasRol.setFechaAsignacion(LocalDate.now());
        usuarioHasRolRepository.save(usuarioHasRol);

        return usuarioGuardado;
    }
}

