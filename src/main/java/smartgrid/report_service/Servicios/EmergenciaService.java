package smartgrid.report_service.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import smartgrid.report_service.Persistencia.Entidades.Emergencia;
import smartgrid.report_service.Persistencia.Repositorios.EmergenciaRepository;

@Service
public class EmergenciaService {

    private final EmergenciaRepository emergenciaRepository;

    @Autowired
    public EmergenciaService(EmergenciaRepository emergenciaRepository) {
        this.emergenciaRepository = emergenciaRepository;
        System.out.println("EmergenciaService inicializado");
    }

    // Método para obtener todas las emergencias
    public Flux<Emergencia> obtenerTodasEmergencias() {
        System.out.println("Servicio: Obteniendo todas las emergencias");
        return emergenciaRepository.findAll()
                .doOnNext(emergencia -> System.out.println("Emergencia encontrada: " + emergencia))
                .doOnComplete(() -> System.out.println("Búsqueda completada"))
                .doOnError(error -> System.out.println("Error al buscar emergencias: " + error.getMessage()));
    }

    // Método para crear una emergencia
    public Mono<Emergencia> crearEmergencia(Emergencia emergencia) {
        System.out.println("Servicio: Creando emergencia: " + emergencia);
        return emergenciaRepository.save(emergencia)
                .doOnSuccess(e -> System.out.println("Emergencia creada exitosamente: " + e))
                .doOnError(error -> System.out.println("Error al crear emergencia: " + error.getMessage()));
    }

    // Método para obtener una emergencia por ID
    public Mono<Emergencia> obtenerEmergenciaPorId(String id) {
        System.out.println("Servicio: Buscando emergencia con ID: " + id);
        return emergenciaRepository.findById(id);
    }

    // Método para eliminar una emergencia
    public Mono<Void> eliminarEmergencia(String id) {
        System.out.println("Servicio: Eliminando emergencia con ID: " + id);
        return emergenciaRepository.deleteById(id);
    }
}