package com.uniquindio.sebas.guia5.services;

import com.uniquindio.sebas.guia5.doamin.EstadoReporte;
import com.uniquindio.sebas.guia5.dtos.ReporteDTO;

import java.util.List;

/**
 * Servicio que define los métodos para la gestión de reportes.
 */
public interface ReporteService {

    ReporteDTO crearReporte(ReporteDTO reporteDTO);

    ReporteDTO actualizarReporte(String userId,ReporteDTO reporteDTO);

    void eliminarReporte(String idReporte);

    ReporteDTO obtenerReportePorId(String idReporte);

    List<ReporteDTO> listarTodosLosReportes();

    List<ReporteDTO> listarReportesPorUsuario(String userId);

    List<ReporteDTO> listarReportesPorEstado(EstadoReporte estadoReporte);


}
