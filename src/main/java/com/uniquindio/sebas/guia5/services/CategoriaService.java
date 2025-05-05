package com.uniquindio.sebas.guia5.services;

import com.uniquindio.sebas.guia5.dtos.CategoriaDTO;
import com.uniquindio.sebas.guia5.dtos.CategoriaResponse;
import com.uniquindio.sebas.guia5.doamin.Categoria;
import com.uniquindio.sebas.guia5.mappers.CategoriaMapper;
import com.uniquindio.sebas.guia5.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    public CategoriaService(CategoriaRepository categoriaRepository, CategoriaMapper categoriaMapper) {
        this.categoriaRepository = categoriaRepository;
        this.categoriaMapper = categoriaMapper;
    }

    public CategoriaResponse crearCategoria(CategoriaDTO dto) {
        Categoria categoria = categoriaMapper.toEntity(dto);
        return categoriaMapper.toResponse(categoriaRepository.save(categoria));
    }

    public List<CategoriaResponse> listarCategorias() {
        return categoriaRepository.findAll()
                .stream()
                .map(categoriaMapper::toResponse)
                .toList();
    }
}
