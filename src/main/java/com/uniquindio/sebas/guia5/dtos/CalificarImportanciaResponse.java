package com.uniquindio.sebas.guia5.dtos;

/**
 * Representacion del objeto de la entidad que se tendra como respuesta
 * No es necesario un DTO de request ya que el usuario se obtiene del token y el reporteId
 * viene dentro del endpoint
 * @param reporteId
 * @param nuevaCantidadImportancia
 * @param mensaje
 */

public record CalificarImportanciaResponse (String reporteId, int nuevaCantidadImportancia, String mensaje){
}
