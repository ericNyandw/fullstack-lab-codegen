package be.nyerdi.java_codegen_lab.configuration;

import com.petstore.client.api.StoreApi;
import com.petstore.client.invoker.ApiClient;
import com.petstore.client.api.UserApi;
import com.petstore.client.api.PetApi;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class PetstoreConfig {
    @Bean
    public ApiClient apiClient(WebClient.Builder webClientBuilder) {
        // On utilise le Builder de Spring pour créer l'ApiClient généré
        ApiClient apiClient = new ApiClient(webClientBuilder.build());
        apiClient.setBasePath("https://petstore.swagger.io/v2");
        return apiClient;
    }
    @Bean
    public UserApi userApi(ApiClient apiClient) {
        // On instancie la "Haute-Niveau" avec le moteur "Basse-Niveau."
        return new UserApi(apiClient);
    }
    @Bean
    public PetApi petApi(ApiClient apiClient) {
        return new PetApi(apiClient);
    }
    @Bean
    public StoreApi storeApi(ApiClient apiClient) {
        return new StoreApi(apiClient);
    }

    @Bean
    public OpenAPI productCatalogOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Product Management API")
                        .description("API REST pour la gestion d'un catalogue de produits avec Spring Boot 3 et PostgreSQL.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("nyerdi"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://springdoc.org")));
    }
}
