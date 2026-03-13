package be.nyerdi.java_codegen_lab.services;

import com.petstore.client.api.UserApi;
import com.petstore.client.model.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
public class PetstoreService {
    private  final UserApi userApi;

    public PetstoreService(UserApi userApi) {
        this.userApi = userApi;
    }
    public Mono<Void> creerNouvelUtilisateur() {
        // 1. On prépare les données (Utilisation du modèle généré.)
        User newUser = new User();
        newUser.setId(System.currentTimeMillis()); // ID unique basé sur le temps
        newUser.setUsername("JohnDoe_Codegen");
        newUser.setFirstName("John");
        newUser.setLastName("Doe");
        newUser.setEmail("john.doe@example.com");
        newUser.setPassword("secret123");
        newUser.setPhone("0123456789");
        newUser.setUserStatus(1);

        // 2. Appel de l'API (Retourne un Mono<Void> car createUser ne renvoie pas de corps)
        return userApi.createUser(newUser)
                .doOnSuccess(v -> System.out.println("✅ Utilisateur créé avec succès sur le serveur !"))
                .doOnError(e -> System.err.println("❌ Erreur lors de la création : " + e.getMessage()));
    }

    public Mono<User> getRemoteUser(String username) {
        return userApi.getUserByName(username);
    }
    public Mono<Void> saveRemoteUser(User user) {
        // La logique métier reste ici
        if (user.getId() == null) {
            user.setId(System.currentTimeMillis());
        }
        return userApi.createUser(user);
    }
}
