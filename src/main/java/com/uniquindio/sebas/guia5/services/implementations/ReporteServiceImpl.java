package com.uniquindio.sebas.guia5.services.implementations;

import com.uniquindio.sebas.guia5.doamin.EstadoReporte;
import com.uniquindio.sebas.guia5.doamin.Reporte;
import com.uniquindio.sebas.guia5.doamin.User;
import com.uniquindio.sebas.guia5.dtos.*;
import com.uniquindio.sebas.guia5.exceptions.ValueConflictExceptions;
import com.uniquindio.sebas.guia5.mappers.ReporteMapper;
import com.uniquindio.sebas.guia5.repository.ReporteRepository;
import com.uniquindio.sebas.guia5.services.ReporteService;
import com.uniquindio.sebas.guia5.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
    private final UserServices userServices;

    @Override
    public ReportResponse crearReporte(ReportRequest reporte) {

        // 1. Extraer el userId (el email autenticado) desde el token , ASI VERIFICAMOS EXISTENCIA Y ACTIVIDAD
        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        try{
        // 2. Verificar que el usuario exista y esté activo
        var optionalUser = userServices.findUserByEmail(userEmail);
        if (optionalUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario creador no existe");
        }
        User usuarioAux = optionalUser.get();
        if (!usuarioAux.isActivo()) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "El usuario no está activo");
        }
        String userId = usuarioAux.getId(); // Obtener el ID del usuario
        // 3. Verificar si ya existe un reporte con el mismo título para ese usuario
        if (reporteRepository.existsByTitleAndUserId(reporte.title(), userId)) {
            throw new ValueConflictExceptions("El título ya está registrado para este usuario");
        }
        // 4. Construir un nuevo DTO con el userId inyectado

            var reporteConUser = new ReportRequest(
                    reporte.title(),
                    reporte.contenido(),
                    reporte.image(),
                    reporte.location(),
                    reporte.categories(),
                    reporte.fechaSuceso(),
                    reporte.listaComentarios(),
                    userId,
                    reporte.importanceCount(),
                    reporte.status()
            );
            // 5. Guardar el reporte
            var newReporte = reporteMapper.parseOf(reporteConUser);
            var reporteGuardado = reporteRepository.save(newReporte);
            return reporteMapper.toReportResponse(reporteGuardado);
        }catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al crear el reporte", e);
        }

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
        return reporteRepository.findByUserId(userId).stream()
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
