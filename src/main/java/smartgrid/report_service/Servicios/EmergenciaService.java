package smartgrid.report_service.Servicios;

import smartgrid.report_service.Persistencia.Entidades.Emergencia;
import smartgrid.report_service.Persistencia.Repositorios.EmergenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmergenciaService {

    private final EmergenciaRepository emergenciaRepository;

    @Autowired // Inyección explícita en el constructor
    public EmergenciaService(EmergenciaRepository emergenciaRepository) {
        this.emergenciaRepository = emergenciaRepository;
    }

    public Flux<Emergencia> obtenerTodasEmergencias() {
        return emergenciaRepository.findAll();
    }

    public Mono<Emergencia> crearEmergencia(Emergencia emergencia) {
        return emergenciaRepository.save(emergencia);
    }

    public Mono<Emergencia> obtenerEmergenciaPorId(String id) {
        return emergenciaRepository.findById(id);
    }

    public Mono<Void> eliminarEmergencia(String id) {
        return emergenciaRepository.deleteById(id);
    }
}