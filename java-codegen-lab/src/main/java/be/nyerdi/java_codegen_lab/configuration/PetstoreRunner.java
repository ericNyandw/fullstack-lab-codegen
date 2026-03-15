package be.nyerdi.java_codegen_lab.configuration;


import be.nyerdi.java_codegen_lab.services.PetstoreService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!test")
public class PetstoreRunner implements CommandLineRunner {

    private final PetstoreService petstoreService;

    public PetstoreRunner(PetstoreService petstoreService) {
        this.petstoreService = petstoreService;
    }

    @Override
    public void run(String... args) {
        System.out.println("🚀 Démarrage de l'appel Petstore (via Runner)...");
        petstoreService.creerNouvelUtilisateur().block();
        System.out.println("🏁 Fin de l'exécution du Runner");
    }
}
