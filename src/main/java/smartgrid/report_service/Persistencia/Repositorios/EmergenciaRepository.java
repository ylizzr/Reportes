package smartgrid.report_service.Persistencia.Repositorios;

import smartgrid.report_service.Persistencia.Entidades.Emergencia;
import com.google.cloud.spring.data.firestore.FirestoreReactiveRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmergenciaRepository extends FirestoreReactiveRepository<Emergencia> {
}