package com.uniquindio.sebas.guia5.controllers;

import com.uniquindio.sebas.guia5.doamin.EstadoReporte;
import com.uniquindio.sebas.guia5.dtos.ReporteDTO;
import com.uniquindio.sebas.guia5.services.ReporteService;
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
    public ResponseEntity<ReporteDTO> crearReporte (@RequestBody ReporteDTO reporteDTO){
        return new ResponseEntity<>(reporteService.crearReporte(reporteDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{reportId}")
    public ResponseEntity<ReporteDTO> actualizarReporte (@PathVariable String reportId, @RequestBody ReporteDTO reporteDTO){
        return ResponseEntity.ok(reporteService.actualizarReporte(reportId,reporteDTO));
    }

    @DeleteMapping("/{reportId}")
    public ResponseEntity<Void> eliminarReporte (@PathVariable String reportId){
        reporteService.eliminarReporte(reportId);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{reportId}")
    public ResponseEntity<ReporteDTO> obtenerReportePorId (@PathVariable String reportId){
        return  ResponseEntity.ok(reporteService.obtenerReportePorId(reportId));
    }

    @GetMapping
    public ResponseEntity<List<ReporteDTO>> listarTodosLosReportes(){
        return ResponseEntity.ok(reporteService.listarTodosLosReportes());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ReporteDTO>> listarReportesPorUsuario(@PathVariable String userId){
        return ResponseEntity.ok(reporteService.listarReportesPorUsuario(userId));
    }

    @GetMapping("estadoReporte/{estadoReporte}")
    public ResponseEntity<List<ReporteDTO>> listarReportesPorEstado(@PathVariable EstadoReporte estadoReporte){
        return ResponseEntity.ok(reporteService.listarReportesPorEstado(estadoReporte));
    }
}
