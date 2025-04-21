package smartgrid.report_service.Persistencia.Entidades;

import com.google.cloud.spring.data.firestore.Document;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@Document(collectionName = "emergencias") // Define que esta clase pertenece a la colección "emergencias"
public class Emergencia {
    @Id // Marca este campo como el identificador único del documento
    private String idEmergencia;
    private String idDispositivo;
    private String tipoEmergencia;
    private String descripcion;
    private String nivelSeveridad;
    private LocalDateTime fechaHora = LocalDateTime.now(); // Asigna la fecha y hora actuales
    private String estado = "Activa"; // Valor por defecto
    private String accionesTomadas;
    private String tiempoResolucion; // Cambié esto a String, ya que Firestore podría no manejar objetos `interval` directamente
    private String usuarioId;
}