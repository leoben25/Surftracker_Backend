package com.surftracker.service;

import com.surftracker.dtos.RespuestaSolicitudRolRequest;
import com.surftracker.dtos.SolicitudRolRequest;
import com.surftracker.entity.Rol;
import com.surftracker.entity.SolicitudRol;
import com.surftracker.entity.Usuario;
import com.surftracker.entity.UsuarioHasRol;
import com.surftracker.repository.RolRepository;
import com.surftracker.repository.SolicitudRolRepository;
import com.surftracker.repository.UsuarioHasRolRepository;
import com.surftracker.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class SolicitudRolServiceImpl implements SolicitudRolService {

    private static final String ESTADO_PENDIENTE = "PENDIENTE";
    private static final String ESTADO_APROBADA = "APROBADA";
    private static final String ESTADO_RECHAZADA = "RECHAZADA";

    private final SolicitudRolRepository solicitudRolRepository;
    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final UsuarioHasRolRepository usuarioHasRolRepository;

    public SolicitudRolServiceImpl(SolicitudRolRepository solicitudRolRepository,
                                   UsuarioRepository usuarioRepository,
                                   RolRepository rolRepository,
                                   UsuarioHasRolRepository usuarioHasRolRepository) {
        this.solicitudRolRepository = solicitudRolRepository;
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
        this.usuarioHasRolRepository = usuarioHasRolRepository;
    }

    @Override
    @Transactional
    public SolicitudRol registrarSolicitud(SolicitudRolRequest request) {
        Usuario usuario = usuarioRepository.findById(request.getIdUsuario())
                .orElseThrow(() -> new IllegalArgumentException("No existe el usuario con id " + request.getIdUsuario()));

        if (solicitudRolRepository.existsByUsuario_IdUsuarioAndEstado(request.getIdUsuario(), ESTADO_PENDIENTE)) {
            throw new IllegalArgumentException("El usuario ya tiene una solicitud pendiente");
        }

        String rolSolicitado = normalizarRol(request.getRolSolicitado());
        rolRepository.findByNombreIgnoreCase(rolSolicitado)
                .orElseThrow(() -> new IllegalArgumentException("No existe el rol solicitado: " + rolSolicitado));

        SolicitudRol solicitud = new SolicitudRol();
        solicitud.setUsuario(usuario);
        solicitud.setRolActual(obtenerRolesActuales(usuario.getIdUsuario()));
        solicitud.setRolSolicitado(rolSolicitado);
        solicitud.setMotivo(request.getMotivo());
        solicitud.setEstado(ESTADO_PENDIENTE);
        solicitud.setFechaSolicitud(LocalDateTime.now());

        return solicitudRolRepository.save(solicitud);
    }

    @Override
    public List<SolicitudRol> listarTodas() {
        return solicitudRolRepository.findAll();
    }

    @Override
    public List<SolicitudRol> listarPendientes() {
        return solicitudRolRepository.findByEstado(ESTADO_PENDIENTE);
    }

    @Override
    public List<SolicitudRol> listarPorUsuario(Integer idUsuario) {
        return solicitudRolRepository.findByUsuario_IdUsuario(idUsuario);
    }

    @Override
    public SolicitudRol obtenerPorId(Integer idSolicitud) {
        return solicitudRolRepository.findById(idSolicitud)
                .orElseThrow(() -> new IllegalArgumentException("No existe la solicitud con id " + idSolicitud));
    }

    @Override
    @Transactional
    public SolicitudRol responderSolicitud(Integer idSolicitud, RespuestaSolicitudRolRequest request) {
        SolicitudRol solicitud = obtenerPorId(idSolicitud);

        if (!ESTADO_PENDIENTE.equalsIgnoreCase(solicitud.getEstado())) {
            throw new IllegalArgumentException("La solicitud ya fue respondida y no puede modificarse");
        }

        String nuevoEstado = normalizarEstado(request.getEstado());
        Usuario admin = usuarioRepository.findById(request.getIdAdminRespuesta())
                .orElseThrow(() -> new IllegalArgumentException("No existe el administrador con id " + request.getIdAdminRespuesta()));

        solicitud.setEstado(nuevoEstado);
        solicitud.setComentarioAdmin(request.getComentarioAdmin());
        solicitud.setAdminRespuesta(admin);
        solicitud.setFechaRespuesta(LocalDateTime.now());

        if (ESTADO_APROBADA.equals(nuevoEstado)) {
            asignarRolSolicitado(solicitud);
        }

        return solicitudRolRepository.save(solicitud);
    }

    private void asignarRolSolicitado(SolicitudRol solicitud) {
        Rol rol = rolRepository.findByNombreIgnoreCase(solicitud.getRolSolicitado())
                .orElseThrow(() -> new IllegalArgumentException("No existe el rol solicitado: " + solicitud.getRolSolicitado()));

        Integer idUsuario = solicitud.getUsuario().getIdUsuario();
        Integer idRol = rol.getIdRol();

        boolean yaTieneRol = usuarioHasRolRepository.existsByUsuario_IdUsuarioAndRol_IdRol(idUsuario, idRol);
        if (!yaTieneRol) {
            UsuarioHasRol usuarioHasRol = new UsuarioHasRol();
            usuarioHasRol.setUsuario(solicitud.getUsuario());
            usuarioHasRol.setRol(rol);
            usuarioHasRol.setFechaAsignacion(LocalDate.now());
            usuarioHasRolRepository.save(usuarioHasRol);
        }
    }

    private String obtenerRolesActuales(Integer idUsuario) {
        List<Rol> roles = usuarioRepository.traerRolesDeUsuario(idUsuario);
        if (roles == null || roles.isEmpty()) {
            return "SIN_ROL";
        }
        return roles.stream()
                .map(Rol::getNombre)
                .collect(Collectors.joining(","));
    }

    private String normalizarRol(String rol) {
        return rol.trim().toUpperCase(Locale.ROOT);
    }

    private String normalizarEstado(String estado) {
        String valor = estado.trim().toUpperCase(Locale.ROOT);
        if (!ESTADO_APROBADA.equals(valor) && !ESTADO_RECHAZADA.equals(valor)) {
            throw new IllegalArgumentException("El estado debe ser APROBADA o RECHAZADA");
        }
        return valor;
    }
}

