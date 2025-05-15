package com.uniquindio.sebas.guia5.services.implementations;

import com.uniquindio.sebas.guia5.doamin.EstadoReporte;
import com.uniquindio.sebas.guia5.doamin.Reporte;
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
import java.util.Optional;
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
    public ReportResponse crearReporte(ReportRequest reporte) {
        if (reporteStore.values().stream().anyMatch(r -> r.getId().equalsIgnoreCase(reporte.userId_creador())))
        {   throw new ValueConflictExceptions("el titulo ya esta registrado"); }
            var newReporte = reporteMapper.parseOf(reporte);
            var reporteGuardado = reporteRepository.save(newReporte);
            //reporteStore.put(newReporte.getId(), newReporte);
            return reporteMapper.toReportResponse(reporteGuardado);
    }

    @Override
    public ReportResponse actualizarReporte (String id, ReportRequest reportRequest){
        //verificamos existencia
        var reporteActual = findReporteById(id);
        // actualizar datos
        reporteActual.setImportanceCount(Integer.parseInt(reportRequest.title()));
        reporteActual.setContent(reportRequest.contenido());
        reporteActual.setLocation(reportRequest.location());
        reporteActual.setStatus(reportRequest.status());
        reporteActual.setCategories(reportRequest.categories());
        reporteActual.setListComments(reportRequest.listaComentarios());
        reporteActual.setImageUrl(reportRequest.image());
        reporteActual.setOccurrenceDate(reportRequest.fechaSuceso());
        return reporteMapper.toReportResponse(reporteRepository.save(reporteActual));
    }

    @Override
    public void eliminarReporte (String idReporte){
        var reporteAlmacenado = findReporteById(idReporte); //basicamente no se estaria usando por ahora
        reporteAlmacenado.setStatus(EstadoReporte.ELIMINADO);
        //reporteRepository.save(reporteAlmacenado);
        reporteRepository.deleteById(idReporte);
    }


    public ReportResponse obtenerReportePorId (String idReporte){
        return reporteMapper.toReportResponse(findReporteById(idReporte));
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

    /*@Override
    public List<ReportResponse> listarReportesPorEstado(EstadoReporte status){
        return reporteRepository.findByEstadoReporte(status).stream()
                .map(reporteMapper::toReportResponse)
                .collect(Collectors.toList());
    }*/
    private Reporte findReporteById (String idReporte){
        return reporteRepository.findById(idReporte)
                .orElseThrow(() -> new RuntimeException("Reporte no encontrado"));
    }
}
