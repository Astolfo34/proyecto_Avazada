package com.uniquindio.sebas.guia5.mappers;

import com.uniquindio.sebas.guia5.doamin.Categoria;
import com.uniquindio.sebas.guia5.doamin.Comentario;
import com.uniquindio.sebas.guia5.doamin.Reporte;
import com.uniquindio.sebas.guia5.dtos.ReporteDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-08T09:58:13-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.12.1.jar, environment: Java 21.0.6 (Amazon.com Inc.)"
)
@Component
public class ReporteMapperImpl implements ReporteMapper {

    @Override
    public ReporteDTO toDto(Reporte reporte) {
        if ( reporte == null ) {
            return null;
        }

        ReporteDTO.ReporteDTOBuilder reporteDTO = ReporteDTO.builder();

        reporteDTO.userId( ReporteMapper.objectIdToString( reporte.getUserId() ) );
        reporteDTO.ubicacion( reporte.getUbicacion() );
        reporteDTO.id( reporte.getId() );
        reporteDTO.titulo( reporte.getTitulo() );
        List<Categoria> list = reporte.getListaCategorias();
        if ( list != null ) {
            reporteDTO.listaCategorias( new ArrayList<Categoria>( list ) );
        }
        reporteDTO.imagenReporte( reporte.getImagenReporte() );
        reporteDTO.fechaCreacion( reporte.getFechaCreacion() );
        reporteDTO.descripcion( reporte.getDescripcion() );
        reporteDTO.fechaIncidente( reporte.getFechaIncidente() );
        reporteDTO.estadoReporte( reporte.getEstadoReporte() );
        List<Comentario> list1 = reporte.getListaComentarios();
        if ( list1 != null ) {
            reporteDTO.listaComentarios( new ArrayList<Comentario>( list1 ) );
        }
        reporteDTO.contadorDeImportancia( reporte.getContadorDeImportancia() );

        return reporteDTO.build();
    }

    @Override
    public Reporte toEntity(ReporteDTO reporteDTO) {
        if ( reporteDTO == null ) {
            return null;
        }

        Reporte.ReporteBuilder reporte = Reporte.builder();

        reporte.userId( ReporteMapper.stringToObjectId( reporteDTO.getUserId() ) );
        reporte.ubicacion( reporteDTO.getUbicacion() );
        reporte.id( reporteDTO.getId() );
        reporte.titulo( reporteDTO.getTitulo() );
        List<Categoria> list = reporteDTO.getListaCategorias();
        if ( list != null ) {
            reporte.listaCategorias( new ArrayList<Categoria>( list ) );
        }
        reporte.imagenReporte( reporteDTO.getImagenReporte() );
        reporte.fechaCreacion( reporteDTO.getFechaCreacion() );
        reporte.descripcion( reporteDTO.getDescripcion() );
        reporte.fechaIncidente( reporteDTO.getFechaIncidente() );
        reporte.estadoReporte( reporteDTO.getEstadoReporte() );
        List<Comentario> list1 = reporteDTO.getListaComentarios();
        if ( list1 != null ) {
            reporte.listaComentarios( new ArrayList<Comentario>( list1 ) );
        }
        reporte.contadorDeImportancia( reporteDTO.getContadorDeImportancia() );

        return reporte.build();
    }
}
