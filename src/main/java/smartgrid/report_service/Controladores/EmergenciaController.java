package smartgrid.report_service.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import smartgrid.report_service.Persistencia.Entidades.Emergencia;
import smartgrid.report_service.Servicios.EmergenciaService;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/emergencias")
@CrossOrigin
public class EmergenciaController {

    private final EmergenciaService emergenciaService;

    @Autowired
    public EmergenciaController(EmergenciaService emergenciaService) {
        this.emergenciaService = emergenciaService;
        System.out.println("Controller inicializado");
    }

    @GetMapping("/test")
    public Mono<String> test() {
        System.out.println("Test endpoint llamado");
        return Mono.just("El controlador está funcionando - " + LocalDateTime.now());
    }

    @GetMapping("/all")
    public Flux<Emergencia> getAllEmergencias() {
        System.out.println("Controller: Obteniendo todas las emergencias");
        return emergenciaService.obtenerTodasEmergencias();
    }

    @PostMapping("/test-create")
    public Mono<Emergencia> testCreate() {
        System.out.println("Controller: Creando emergencia de prueba");
        Emergencia emergencia = new Emergencia();
        emergencia.setId("TEST-001");  // ID requerido por Firestore
        emergencia.setIdEmergencia("TEST-001");
        emergencia.setIdDispositivo("DEVICE-001");
        emergencia.setTipoEmergencia("Prueba");
        emergencia.setDescripcion("Emergencia de prueba");
        emergencia.setNivelSeveridad("Bajo");
        emergencia.setEstado("Activa");
        return emergenciaService.crearEmergencia(emergencia);
    }
}