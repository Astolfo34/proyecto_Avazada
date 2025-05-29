package com.uniquindio.sebas.guia5.fireData;

import com.uniquindio.sebas.guia5.doamin.*;
import com.uniquindio.sebas.guia5.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

/** * Clase que se encarga de inicializar la base de datos con datos de ejemplo.
 * Implementa CommandLineRunner para ejecutar código al iniciar la aplicación.
 * cabe aclarar que primero limpia la base de datos y luego inserta los datos de ejemplo.
 */
@Component
@AllArgsConstructor
public class DataSeeder implements CommandLineRunner {

    //repositorios usados
    private final UserRepository userRepository;
    private final ReporteRepository reporteRepository;
    private final ComentarioRepository comentarioRepository;
    private final CategoriaRepository categoriaRepository;
    private final NotificacionRepository notificacionRepository;

    @Override
    public void run (String... args) throws Exception {
        // Limpiar los datos existentes para pre-cargar los stan-dart
        /*userRepository.deleteAll();
        reporteRepository.deleteAll();
        comentarioRepository.deleteAll();
        categoriaRepository.deleteAll();
        notificacionRepository.deleteAll();*/

        /*// creando categorías
        Categoria robo = new Categoria(null,"HURTOS",
                "Acto delictivo que involucra el robo a propiedad privada de un individo" +
                        " o hacia la pertenencia de uno a varias personas ");
        Categoria desastreNatural = new Categoria(null,"DESASTRES NATURALES",
                "Eventos naturales que causan daños significativos a la vida, la propiedad y el medio ambiente, " +
                        "como terremotos, inundaciones, huracanes, etc.");
        Categoria accidente = new Categoria(null,"ACCIDENTES",
                " Incidentes inesperados que causan daño o lesión, como colisiones de vehículos, caídas, etc.");
        Categoria incidenteVial = new Categoria(null,"INCIDENTES VIALES",
                "Eventos relacionados con el tráfico, como accidentes de tráfico, congestiones, etc.");

        // Guardar las categorías en la base de datos
        categoriaRepository.saveAll(List.of(robo, desastreNatural, accidente, incidenteVial));

        // creando usuarios normales
        User ana = new User(
                "Ana Pérez", // fullName
                null,    // id
                "ana.perez@email.com", // email
                "passwordSeguro123",   // password
                LocalDate.of(1995, 5, 20), // dateBirth
                Rol.USERDEFAULT,           // rolUser (ajusta según tu enum)
                UserStatus.ACTIVE,     // stateUser (ajusta según tu enum)
                null,                  // lista_Reportes (puedes pasar una lista vacía o null)
                null,                  // lista_notificaciones (puedes pasar una lista vacía o null)
                "Calle 123 #45-67",    // direccion
                "3001234567",          // telefono
                "https://img.com/perfil.jpg", // imagenPerfil
                true,                  // activo
                "1234-6789sdd-xyz" // activationCode
        );
        // usuarios administradores
        User sebas = new User(
                "Sebastian Alzate", // fullName
                null,    // id
                "sebas.alzate@email.com", // email
                "passwordSeguro456",   // password
                LocalDate.of(2001, 10, 31), // dateBirth
                Rol.ADMINISTRATOR,           // rolUser (ajusta según tu enum)
                UserStatus.ACTIVE,     // stateUser (ajusta según tu enum)
                null,                  // lista_Reportes (puedes pasar una lista vacía o null)
                null,                  // lista_notificaciones (puedes pasar una lista vacía o null)
                "Calle 123 #45-67",    // direccion
                "3001234567",          // telefono
                "https://img.com/perfil.jpg", // imagenPerfil
                true,                  // activo
                "1234-6789sdd-1yz" // activationCode
        );
        // Guardar los usuarios en la base de datos
        userRepository.saveAll(List.of(ana, sebas));

        // creando reportes
        Reporte incendio = new Reporte(
                null, // id (Mongo lo genera)
                "Incendio en biblioteca", // title
                List.of(desastreNatural), // categories (usa una lista de categorías existentes)
                new Location(null,4.7110, -74.0721), // location (ajusta según tu clase Location)
                "https://img.com/incendio.jpg", // imageUrl
                LocalDate.now(), // createdAt
                "Se está quemando la biblioteca escolar", // content
                ana.getId(), // userId (id del usuario que reporta)
                LocalDate.of(2024, 5, 26), // occurrenceDate
                EstadoReporte.EN_PROCESO, // status (ajusta según tu enum)
                List.of(), // listComments (puedes pasar una lista vacía)
                0 // importanceCount
        );
        Reporte accidenteVehicular = new Reporte(
                null, // id (Mongo lo genera)
                "Accidente en la autopista", // title
                List.of(incidenteVial), // categories (usa una lista de categorías existentes)
                new Location(null,4.7110, -74.0721), // location (ajusta según tu clase Location)
                "https://img.com/accidente.jpg", // imageUrl
                LocalDate.now(), // createdAt
                "Un vehículo se volcó en la autopista", // content
                sebas.getId(), // userId (id del usuario que reporta)
                LocalDate.of(2024, 5, 26), // occurrenceDate
                EstadoReporte.PENDIENTE, // status (ajusta según tu enum)
                List.of(), // listComments (puedes pasar una lista vacía)
                0 // importanceCount
        );
        Reporte roboCasa = new Reporte(
                null, // id (Mongo lo genera)
                "Robo en casa", // title
                List.of(robo), // categories (usa una lista de categorías existentes)
                new Location(null,4.7110, -74.0721), // location (ajusta según tu clase Location)
                "https://img.com/robo.jpg", // imageUrl
                LocalDate.now(), // createdAt
                "Se reporta un robo en una vivienda", // content
                ana.getId(), // userId (id del usuario que reporta)
                LocalDate.of(2024, 5, 26), // occurrenceDate
                EstadoReporte.CERRADO, // status (ajusta según tu enum)
                List.of(), // listComments (puedes pasar una lista vacía)
                0 // importanceCount
        );
        // Guardar los reportes en la base de datos
        reporteRepository.saveAll(List.of(incendio, accidenteVehicular, roboCasa));

        // creando comentarios
        Comentario comentarioRoboCasa = new Comentario(
                null, // id (Mongo lo genera)
                sebas.getId(), // creadorId (id del usuario que comenta)
                roboCasa.getId(), // reporteId (id del reporte al que pertenece el comentario)
                "Yo vi a alguien sospechoso subir a un auto rojo a esa hora por ese lugar", // contenido_comentario
                LocalDate.now() // fechaPublication
        );
        Comentario comentarioIncendio = new Comentario(
                null, // id (Mongo lo genera)
                ana.getId(), // creadorId (id del usuario que comenta)
                incendio.getId(), // reporteId (id del reporte al que pertenece el comentario)
                "¿Alguien sabe si ya llegaron los bomberos?", // contenido_comentario
                LocalDate.now() // fechaPublication
        );

        // Guardar los comentarios en la base de datos
        comentarioRepository.saveAll(List.of(comentarioRoboCasa, comentarioIncendio));
*/
    }

}
