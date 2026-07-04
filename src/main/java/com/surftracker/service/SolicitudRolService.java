package com.surftracker.service;

import com.surftracker.dtos.RespuestaSolicitudRolRequest;
import com.surftracker.dtos.SolicitudRolRequest;
import com.surftracker.entity.SolicitudRol;

import java.util.List;

public interface SolicitudRolService {

    SolicitudRol registrarSolicitud(SolicitudRolRequest request);

    List<SolicitudRol> listarTodas();

    List<SolicitudRol> listarPendientes();

    List<SolicitudRol> listarPorUsuario(Integer idUsuario);

    SolicitudRol obtenerPorId(Integer idSolicitud);

    SolicitudRol responderSolicitud(Integer idSolicitud, RespuestaSolicitudRolRequest request);
}

