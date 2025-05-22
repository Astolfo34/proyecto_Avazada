package com.uniquindio.sebas.guia5.services;

import com.uniquindio.sebas.guia5.doamin.Comentario;
import com.uniquindio.sebas.guia5.doamin.Reporte;
import com.uniquindio.sebas.guia5.dtos.ComentarioRequest;
import com.uniquindio.sebas.guia5.dtos.ComentarioResponse;
import com.uniquindio.sebas.guia5.mappers.ComentarioMapper;
import com.uniquindio.sebas.guia5.repository.ComentarioRepository;
import com.uniquindio.sebas.guia5.repository.ReporteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;
    private final ComentarioMapper comentarioMapper;
    private final ReporteRepository reporteRepository;

    public ComentarioService(ComentarioRepository comentarioRepository, ComentarioMapper comentarioMapper, ReporteRepository reporteRepository) {
        this.comentarioRepository = comentarioRepository;
        this.comentarioMapper = comentarioMapper;
        this.reporteRepository = reporteRepository;
    }

    public ComentarioResponse crearComentario(ComentarioRequest dto, String reportId, String userId) {
        // Verifica que el reporte existe primero
        Reporte reporte = reporteRepository.findById(reportId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Reporte no encontrado"));

        Comentario comentario = new Comentario();
        comentario.setContenido_comentario(dto.contenido_comentario());
        comentario.setFechaPublication(LocalDate.now());
        comentario.setCreadorId(userId);
        comentario.setReporteId(reportId);

        return comentarioMapper.toResponse(comentarioRepository.save(comentario));
    }

    public List<ComentarioResponse> listarComentarios() {
        return comentarioRepository.findAll()
                .stream()
                .map(comentarioMapper::toResponse)
                .toList();
    }
}
