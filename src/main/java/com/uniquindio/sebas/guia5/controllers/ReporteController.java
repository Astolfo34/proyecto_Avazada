package com.uniquindio.sebas.guia5.controllers;

import com.uniquindio.sebas.guia5.doamin.EstadoReporte;
import com.uniquindio.sebas.guia5.dtos.*;
import com.uniquindio.sebas.guia5.exceptions.ValueConflictExceptions;
import com.uniquindio.sebas.guia5.services.ReporteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador que define los endpoints para la gestión de reportes.
 */
@RestController
@RequestMapping("/v1/reports")
@RequiredArgsConstructor
public class ReporteController {

    private final ReporteService reporteService;

    @PostMapping
    public ResponseEntity<ReportResponse> crearReporte (@RequestBody @Valid ReportRequest reporteDTO){

            try {
                return ResponseEntity.ok(reporteService.crearReporte(reporteDTO));
            } catch (ValueConflictExceptions e) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(null); // Error 409
            } catch (IllegalArgumentException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // Error 400
            } /*catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // Error 500
            }*/

    }

    @PostMapping("/{reportId}/calificar-importancia")
    public ResponseEntity<CalificarImportanciaResponse> calificarImportancia
            (@PathVariable String reportId) {
        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        try {
            CalificarImportanciaResponse response = reporteService.calificarImpReporte(reportId,userEmail);
            return  ResponseEntity.ok(response);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); // Error 400
        }

    }

    @PutMapping("/{reportId}")
    public ResponseEntity<ReportResponse> actualizarReporte (@Valid @PathVariable String reportId, @RequestBody ReportRequest reporteDTO){
        return ResponseEntity.ok(reporteService.actualizarReporte(reportId,reporteDTO));
    }

    @DeleteMapping("/{reportId}")
    public ResponseEntity<Void> eliminarReporte (@PathVariable String reportId){
        reporteService.eliminarReporte(reportId);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{reportId}")
    public ResponseEntity<ReportResponse> obtenerReportePorId (@PathVariable String reportId){
        return  ResponseEntity.ok(reporteService.obtenerReportePorId(reportId));
    }

    @GetMapping
    public ResponseEntity<List<ReportResponse>> listarTodosLosReportes(){
        return ResponseEntity.ok(reporteService.listarTodosLosReportes());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ReportResponse>> listarReportesPorUsuario(@PathVariable String userId){
        return ResponseEntity.ok(reporteService.listarReportesPorUsuario(userId));
    }


}
