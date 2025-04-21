package smartgrid.report_service.Controladores;

import smartgrid.report_service.Persistencia.Entidades.Emergencia;
import smartgrid.report_service.Servicios.EmergenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/emergencias")
public class EmergenciaController {

    private final EmergenciaService emergenciaService;

    @Autowired
    public EmergenciaController(EmergenciaService emergenciaService) {
        this.emergenciaService = emergenciaService;
    }

    @GetMapping
    public Flux<Emergencia> obtenerTodasEmergencias() {
        return emergenciaService.obtenerTodasEmergencias();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Emergencia> crearEmergencia(@RequestBody Emergencia emergencia) {
        return emergenciaService.crearEmergencia(emergencia);
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Emergencia>> obtenerEmergenciaPorId(@PathVariable String id) {
        return emergenciaService.obtenerEmergenciaPorId(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> eliminarEmergencia(@PathVariable String id) {
        return emergenciaService.eliminarEmergencia(id);
    }
}