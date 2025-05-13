package com.uniquindio.sebas.guia5.mappers;

import com.uniquindio.sebas.guia5.doamin.Categoria;
import com.uniquindio.sebas.guia5.doamin.Comentario;
import com.uniquindio.sebas.guia5.doamin.EstadoReporte;
import com.uniquindio.sebas.guia5.doamin.Reporte;
import com.uniquindio.sebas.guia5.dtos.ReporteDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-12T10:20:40-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.12.1.jar, environment: Java 21.0.6 (Amazon.com Inc.)"
)
@Component
public class ReporteMapperImpl implements ReporteMapper {

    @Override
    public Reporte toEntity(ReporteDTO reporteDTO) {
        if ( reporteDTO == null ) {
            return null;
        }

        Reporte.ReporteBuilder reporte = Reporte.builder();

        reporte.location( reporteDTO.getLocation() );
        reporte.title( reporteDTO.getTitle() );
        reporte.content( reporteDTO.getContent() );
        reporte.imageUrl( reporteDTO.getImageUrl() );
        reporte.occurrenceDate( reporteDTO.getOccurrenceDate() );
        List<Categoria> list = reporteDTO.getCategories();
        if ( list != null ) {
            reporte.categories( new ArrayList<Categoria>( list ) );
        }

        reporte.id( java.util.UUID.randomUUID().toString() );
        reporte.status( EstadoReporte.PENDIENTE );

        return reporte.build();
    }

    @Override
    public ReporteDTO toDto(Reporte reporte) {
        if ( reporte == null ) {
            return null;
        }

        ReporteDTO.ReporteDTOBuilder reporteDTO = ReporteDTO.builder();

        reporteDTO.id( reporte.getId() );
        reporteDTO.title( reporte.getTitle() );
        List<Categoria> list = reporte.getCategories();
        if ( list != null ) {
            reporteDTO.categories( new ArrayList<Categoria>( list ) );
        }
        reporteDTO.location( reporte.getLocation() );
        reporteDTO.imageUrl( reporte.getImageUrl() );
        reporteDTO.occurrenceDate( reporte.getOccurrenceDate() );
        reporteDTO.content( reporte.getContent() );
        reporteDTO.userId( reporte.getUserId() );
        reporteDTO.createdAt( reporte.getCreatedAt() );
        reporteDTO.status( reporte.getStatus() );
        List<Comentario> list1 = reporte.getListComments();
        if ( list1 != null ) {
            reporteDTO.listComments( new ArrayList<Comentario>( list1 ) );
        }
        reporteDTO.importanceCount( reporte.getImportanceCount() );

        return reporteDTO.build();
    }
}
