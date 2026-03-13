package be.nyerdi.java_codegen_lab;

import be.nyerdi.java_codegen_lab.services.PetstoreService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaCodegenLabApplication implements CommandLineRunner {

	private final PetstoreService petstoreService;

    public JavaCodegenLabApplication(PetstoreService petstoreService) {
        this.petstoreService = petstoreService;
    }

    public static void main(String[] args) {
		SpringApplication.run(JavaCodegenLabApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println("🚀 Démarrage de l'appel Petstore...");
		petstoreService.creerNouvelUtilisateur().block(); // Le .block() est crucial ici pour attendre la réponse
		System.out.println("🏁 Fin de l'exécution du Runner");
	}
}
