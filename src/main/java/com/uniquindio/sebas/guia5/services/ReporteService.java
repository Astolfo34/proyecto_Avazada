package com.uniquindio.sebas.guia5.services;

import com.uniquindio.sebas.guia5.doamin.EstadoReporte;
import com.uniquindio.sebas.guia5.dtos.CalificarImportanciaResponse;
import com.uniquindio.sebas.guia5.dtos.ReportRequest;
import com.uniquindio.sebas.guia5.dtos.ReportResponse;
import com.uniquindio.sebas.guia5.dtos.ReporteDTO;

import java.util.List;
import java.util.Optional;

/**
 * Servicio que define los métodos para la gestión de reportes.
 */
public interface ReporteService {

    ReportResponse crearReporte(ReportRequest reporteDTO);

    ReportResponse actualizarReporte(String userId,ReportRequest reporteDTO);

    void eliminarReporte(String idReporte);

    ReportResponse obtenerReportePorId(String idReporte);

    List<ReportResponse> listarTodosLosReportes();

    List<ReportResponse> listarReportesPorUsuario(String userId);

    CalificarImportanciaResponse calificarImpReporte(String reporteId, String userEmail);
}
