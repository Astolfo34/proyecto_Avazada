package com.uniquindio.sebas.guia5.mappers;

import com.uniquindio.sebas.guia5.doamin.Categoria;
import com.uniquindio.sebas.guia5.doamin.Comentario;
import com.uniquindio.sebas.guia5.doamin.EstadoReporte;
import com.uniquindio.sebas.guia5.doamin.Location;
import com.uniquindio.sebas.guia5.doamin.Reporte;
import com.uniquindio.sebas.guia5.dtos.ReportRequest;
import com.uniquindio.sebas.guia5.dtos.ReportResponse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-15T14:48:43-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.12.1.jar, environment: Java 21.0.6 (Amazon.com Inc.)"
)
@Component
public class ReporteMapperImpl implements ReporteMapper {

    @Override
    public Reporte parseOf(ReportRequest reporteDTO) {
        if ( reporteDTO == null ) {
            return null;
        }

        Reporte.ReporteBuilder reporte = Reporte.builder();

        reporte.userId( reporteDTO.userId_creador() );
        reporte.location( reporteDTO.location() );
        reporte.title( reporteDTO.title() );
        reporte.content( reporteDTO.contenido() );
        reporte.imageUrl( reporteDTO.image() );
        reporte.occurrenceDate( reporteDTO.fechaSuceso() );
        List<Categoria> list = reporteDTO.categories();
        if ( list != null ) {
            reporte.categories( new ArrayList<Categoria>( list ) );
        }
        reporte.status( reporteDTO.status() );
        if ( reporteDTO.importanceCount() != null ) {
            reporte.importanceCount( reporteDTO.importanceCount() );
        }

        reporte.id( java.util.UUID.randomUUID().toString() );
        reporte.createdAt( java.time.LocalDate.now() );

        return reporte.build();
    }

    @Override
    public ReportResponse toReportResponse(Reporte reporte) {
        if ( reporte == null ) {
            return null;
        }

        String id = null;
        String title = null;
        String contenido = null;
        String image = null;
        Location location = null;
        List<Categoria> categories = null;
        LocalDate fechaSuceso = null;
        String userId = null;
        List<Comentario> comments = null;
        Integer importanceCount = null;
        EstadoReporte status = null;
        String creadorId = null;

        id = reporte.getId();
        title = reporte.getTitle();
        contenido = reporte.getContent();
        image = reporte.getImageUrl();
        location = reporte.getLocation();
        List<Categoria> list = reporte.getCategories();
        if ( list != null ) {
            categories = new ArrayList<Categoria>( list );
        }
        fechaSuceso = reporte.getOccurrenceDate();
        userId = reporte.getUserId();
        List<Comentario> list1 = reporte.getListComments();
        if ( list1 != null ) {
            comments = new ArrayList<Comentario>( list1 );
        }
        importanceCount = reporte.getImportanceCount();
        status = reporte.getStatus();
        creadorId = reporte.getUserId();

        ReportResponse reportResponse = new ReportResponse( id, title, contenido, image, location, categories, fechaSuceso, userId, comments, importanceCount, status, creadorId );

        return reportResponse;
    }
}
