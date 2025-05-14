package com.uniquindio.sebas.guia5.controllers;

import com.uniquindio.sebas.guia5.doamin.EstadoReporte;
import com.uniquindio.sebas.guia5.dtos.ReportRequest;
import com.uniquindio.sebas.guia5.dtos.ReportResponse;
import com.uniquindio.sebas.guia5.dtos.ReporteDTO;
import com.uniquindio.sebas.guia5.services.ReporteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ReportResponse> crearReporte (@Valid @RequestBody ReportRequest reporteDTO){
        return ResponseEntity.ok(reporteService.crearReporte(reporteDTO));
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
