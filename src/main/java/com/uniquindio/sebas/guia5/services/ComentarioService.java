package com.uniquindio.sebas.guia5.services;

import com.uniquindio.sebas.guia5.doamin.Comentario;
import com.uniquindio.sebas.guia5.dtos.ComentarioDTO;
import com.uniquindio.sebas.guia5.dtos.ComentarioResponse;
import com.uniquindio.sebas.guia5.mappers.ComentarioMapper;
import com.uniquindio.sebas.guia5.repository.ComentarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;
    private final ComentarioMapper comentarioMapper;

    public ComentarioService(ComentarioRepository comentarioRepository, ComentarioMapper comentarioMapper) {
        this.comentarioRepository = comentarioRepository;
        this.comentarioMapper = comentarioMapper;
    }

    public ComentarioResponse crearComentario(ComentarioDTO dto) {
        Comentario comentario = comentarioMapper.toEntity(dto);
        return comentarioMapper.toResponse(comentarioRepository.save(comentario));
    }

    public List<ComentarioResponse> listarComentarios() {
        return comentarioRepository.findAll()
                .stream()
                .map(comentarioMapper::toResponse)
                .toList();
    }
}
