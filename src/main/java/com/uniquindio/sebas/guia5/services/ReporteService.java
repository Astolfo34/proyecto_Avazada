package com.uniquindio.sebas.guia5.services;

import com.uniquindio.sebas.guia5.doamin.EstadoReporte;
import com.uniquindio.sebas.guia5.dtos.ReportResponse;
import com.uniquindio.sebas.guia5.dtos.ReporteDTO;

import java.util.List;
import java.util.Optional;

/**
 * Servicio que define los métodos para la gestión de reportes.
 */
public interface ReporteService {

    ReportResponse crearReporte(ReporteDTO reporteDTO);

    ReportResponse actualizarReporte(String userId,ReporteDTO reporteDTO);

    void eliminarReporte(String idReporte);

    Optional<ReportResponse> obtenerReportePorId(String idReporte);

    List<ReporteDTO> listarTodosLosReportes();

    List<ReporteDTO> listarReportesPorUsuario(String userId);

    List<ReporteDTO> listarReportesPorEstado(EstadoReporte estadoReporte);


}
