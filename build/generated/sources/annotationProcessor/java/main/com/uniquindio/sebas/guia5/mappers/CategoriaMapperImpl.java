package com.uniquindio.sebas.guia5.mappers;

import com.uniquindio.sebas.guia5.doamin.Categoria;
import com.uniquindio.sebas.guia5.dtos.CategoriaDTO;
import com.uniquindio.sebas.guia5.dtos.CategoriaResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-08T09:58:13-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.12.1.jar, environment: Java 21.0.6 (Amazon.com Inc.)"
)
@Component
public class CategoriaMapperImpl implements CategoriaMapper {

    @Override
    public Categoria toEntity(CategoriaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Categoria categoria = new Categoria();

        categoria.setName( dto.name() );
        categoria.setDescription( dto.description() );

        categoria.setId( java.util.UUID.randomUUID().toString() );

        return categoria;
    }

    @Override
    public CategoriaResponse toResponse(Categoria categoria) {
        if ( categoria == null ) {
            return null;
        }

        String id = null;
        String name = null;
        String description = null;

        id = categoria.getId();
        name = categoria.getName();
        description = categoria.getDescription();

        CategoriaResponse categoriaResponse = new CategoriaResponse( id, name, description );

        return categoriaResponse;
    }
}
