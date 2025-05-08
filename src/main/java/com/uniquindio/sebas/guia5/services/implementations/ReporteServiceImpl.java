package com.uniquindio.sebas.guia5.services.implementations;

import com.uniquindio.sebas.guia5.doamin.EstadoReporte;
import com.uniquindio.sebas.guia5.doamin.Reporte;
import com.uniquindio.sebas.guia5.dtos.ReporteDTO;
import com.uniquindio.sebas.guia5.mappers.ReporteMapper;
import com.uniquindio.sebas.guia5.repository.ReporteRepository;
import com.uniquindio.sebas.guia5.services.ReporteService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
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

    @Override
    public ReporteDTO crearReporte(ReporteDTO reporteDTO) {
        reporteDTO.setFechaCreacion(LocalDateTime.now());
        reporteDTO.setContadorDeImportancia(0);
        reporteDTO.setEstadoReporte(EstadoReporte.APROBADO);

        Reporte reporte = reporteMapper.toEntity(reporteDTO);
        Reporte reporteGuardado = reporteRepository.save(reporte);
        return reporteMapper.toDto(reporteGuardado);
    }

    @Override
    public ReporteDTO actualizarReporte (String idReporte,ReporteDTO reporteDTO){
        Reporte reporteExistente = reporteRepository.findById(idReporte)
                .orElseThrow(() -> new RuntimeException("Reporte no encontrado"));

        //Actualizar los campos permitidos
        reporteExistente.setTitulo(reporteDTO.getTitulo());
        reporteExistente.setListaCategorias(reporteDTO.getListaCategorias());
        reporteExistente.setUbicacion(reporteDTO.getUbicacion());
        reporteExistente.setImagenReporte(reporteDTO.getImagenReporte());
        reporteExistente.setDescripcion(reporteDTO.getDescripcion());
        reporteExistente.setFechaIncidente(reporteDTO.getFechaIncidente());
        reporteExistente.setEstadoReporte(reporteDTO.getEstadoReporte());
        reporteExistente.setListaComentarios(reporteDTO.getListaComentarios());
        reporteExistente.setContadorDeImportancia(reporteDTO.getContadorDeImportancia());

        Reporte reporteActualizado = reporteRepository.save(reporteExistente);
        return  reporteMapper.toDto(reporteActualizado);
    }

    @Override
    public void eliminarReporte (String idReporte){
        reporteRepository.deleteById(idReporte);
    }

    @Override
    public ReporteDTO obtenerReportePorId (String idReporte){
        return reporteRepository.findById(idReporte)
                .map(reporteMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Reporte no encontrado"));
    }

    @Override
    public List<ReporteDTO> listarTodosLosReportes() {
        return reporteRepository.findAll().stream()
                .map(reporteMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReporteDTO> listarReportesPorUsuario (String userId){
        return reporteRepository.findByUserId(new ObjectId(userId)).stream()
                .map(reporteMapper::toDto)
                .collect(Collectors.toList());

    }

    @Override
    public List<ReporteDTO> listarReportesPorEstado(EstadoReporte estadoReporte){
        return reporteRepository.findByEstadoReporte(estadoReporte).stream()
                .map(reporteMapper::toDto)
                .collect(Collectors.toList());
    }
}
