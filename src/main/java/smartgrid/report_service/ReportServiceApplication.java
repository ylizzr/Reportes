package smartgrid.report_service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.google.cloud.spring.data.firestore.repository.config.EnableReactiveFirestoreRepositories;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;

@SpringBootApplication
@EnableReactiveFirestoreRepositories
public class ReportServiceApplication {

	@Bean
	public Firestore firestore() throws IOException {
		String credentialsPath = "C:/Users/User/Downloads/tatata-455701-15522eae360c.json";
		GoogleCredentials credentials = GoogleCredentials.fromStream(
				new FileInputStream(credentialsPath));

		FirestoreOptions firestoreOptions = FirestoreOptions.getDefaultInstance().toBuilder()
				.setProjectId("tatata-455701")
				.setCredentials(credentials)
				.build();

		return firestoreOptions.getService();
	}

	public static void main(String[] args) {
		SpringApplication.run(ReportServiceApplication.class, args);

		// Verificación del archivo de credenciales
		File file = new File("C:/Users/User/Downloads/tatata-455701-15522eae360c.json");
		System.out.println("File exists: " + file.exists());
		System.out.println("File can read: " + file.canRead());
		System.out.println("Absolute path: " + file.getAbsolutePath());
	}
}