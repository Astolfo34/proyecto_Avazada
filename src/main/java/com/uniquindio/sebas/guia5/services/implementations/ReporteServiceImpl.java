package com.uniquindio.sebas.guia5.services.implementations;

import com.uniquindio.sebas.guia5.doamin.EstadoReporte;
import com.uniquindio.sebas.guia5.doamin.Reporte;
import com.uniquindio.sebas.guia5.doamin.User;
import com.uniquindio.sebas.guia5.dtos.*;
import com.uniquindio.sebas.guia5.exceptions.ValueConflictExceptions;
import com.uniquindio.sebas.guia5.mappers.ReporteMapper;
import com.uniquindio.sebas.guia5.repository.ReporteRepository;
import com.uniquindio.sebas.guia5.services.ReporteService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * Implementación del servicio ReporteService.
 * Proporciona métodos para crear, actualizar, eliminar y obtener reportes.
 */
@Service
@RequiredArgsConstructor
public class ReporteServiceImpl implements ReporteService {

    private final ReporteRepository reporteRepository;
    private final ReporteMapper reporteMapper;
    private final Map<String, Reporte> reporteStore = new ConcurrentHashMap<>();

    @Override
    public ReportResponse createReport(ReportRequest reporte) {
        if (reporteStore.values().stream().anyMatch(r -> r.getTitle().equalsIgnoreCase(reporte.title())))
        {   throw new ValueConflictExceptions("el titulo ya esta registrado"); }
            var newReporte = reporteMapper.parseOf(reporte);
            reporteStore.put(newReporte.getId(), newReporte);
            return reporteMapper.toReportResponse(newReporte);
    }

    @Override
    public ReporteDTO actualizarReporte (String idReporte,ReportResponse reporteDTO){
        Reporte reporteExistente = reporteRepository.findById(idReporte)
                .orElseThrow(() -> new RuntimeException("Reporte no encontrado"));

        //Actualizar los campos permitidos
        reporteExistente.setTitle(reporteDTO.title());
        reporteExistente.setCategories(reporteDTO.getCategories());
        reporteExistente.setLocation(reporteDTO.getLocation());
        reporteExistente.setImageUrl(reporteDTO.getImageUrl());
        reporteExistente.setContent(reporteDTO.getContent());
        reporteExistente.setOccurrenceDate(reporteDTO.getOccurrenceDate());
        reporteExistente.setStatus(reporteDTO.getStatus());
        reporteExistente.setListComments(reporteDTO.getListComments());
        reporteExistente.setImportanceCount(reporteDTO.getImportanceCount());

        Reporte reporteActualizado = reporteRepository.save(reporteExistente);
        return  reporteMapper.toReportResponse(reporteActualizado);
    }

    @Override
    public void eliminarReporte (String idReporte){
        reporteRepository.deleteById(idReporte);
    }

    @Override
    public ReportResponse obtenerReportePorId (String idReporte){
        return reporteRepository.findById(idReporte)
                .map(reporteMapper::toReportResponse)
                .orElseThrow(() -> new RuntimeException("Reporte no encontrado"));
    }

    @Override
    public List<ReportResponse> listarTodosLosReportes() {
        return reporteRepository.findAll().stream()
                .map(reporteMapper::toReportResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReportResponse> listarReportesPorUsuario (String userId){
        return reporteRepository.findByUserId(new ObjectId(userId)).stream()
                .map(reporteMapper::toReportResponse)
                .collect(Collectors.toList());

    }

    @Override
    public List<ReportResponse> listarReportesPorEstado(EstadoReporte estadoReporte){
        return reporteRepository.findByEstadoReporte(estadoReporte).stream()
                .map(reporteMapper::toReportResponse)
                .collect(Collectors.toList());
    }
}
