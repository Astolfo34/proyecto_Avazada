package com.uniquindio.sebas.guia5.services.implementations;

import com.uniquindio.sebas.guia5.doamin.Comentario;
import com.uniquindio.sebas.guia5.doamin.Reporte;
import com.uniquindio.sebas.guia5.dtos.ComentarioRequest;
import com.uniquindio.sebas.guia5.dtos.ComentarioResponse;
import com.uniquindio.sebas.guia5.mappers.ComentarioMapper;
import com.uniquindio.sebas.guia5.repository.ComentarioRepository;
import com.uniquindio.sebas.guia5.repository.ReporteRepository;
import com.uniquindio.sebas.guia5.services.ComentarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class ComentarioServiceImpl implements ComentarioService {

    private final ComentarioRepository comentarioRepository;
    private final ComentarioMapper comentarioMapper;
    private final ReporteRepository reporteRepository;


    @Override
    public ComentarioResponse crearComentario(ComentarioRequest request, String reportId, String userId) {
        // Verifica que el reporte existe primero
        var reportAux = reporteRepository.findById(reportId);
        if (reportAux.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"reporte no encontrado");
        }
        // creamos el comentario
        Comentario comentario = comentarioMapper.toEntity(request);
        comentario.setReporteId(reportId);
        comentario.setCreadorId(userId);

        //comentario para la bd
        Comentario comentaSaved = comentarioRepository.save(comentario);
        //añadimos el coment a la lista de comentarios del reporte
        Reporte reporteComentado = reportAux.get();
        reporteComentado.getListComments().add(comentaSaved);
        reporteRepository.save(reporteComentado);
     return comentarioMapper.toResponse(comentaSaved);
    }

    public List<ComentarioResponse> listarComentarios() {
        return comentarioRepository.findAll()
                .stream()
                .map(comentarioMapper::toResponse)
                .toList();
    }
}
