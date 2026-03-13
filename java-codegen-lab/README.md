# java-codegen-lab 🚀

Projet de démonstration sur l'implémentation du **Contract-First Development** avec **Spring Boot 3** et **OpenAPI Generator**.

## 📌 Concept
Ce lab montre comment consommer l'API externe [Swagger Petstore](https://petstore.swagger.io) de manière automatisée. 
Le code technique (DTOs et Clients HTTP) est généré à partir du contrat `petstore.json`.

## 🛠 Stack Technique
- **Java 17** / Spring Boot 3.4.x
- **Spring WebFlux** : Utilisation de `WebClient` pour des appels non-bloquants.
- **OpenAPI Generator Maven Plugin** : v7.2.0.

## 🚀 Installation & Build

1. **Cloner le projet** :
   ```bash
   git clone https://github.com
   cd java-codegen-lab
   ```
2. **Générer le code client** :
Le code est généré dans target/generated-sources/openapi/ lors de la compilation.
```bash
mvn clean compile
 ```

3. **Configuration IDE (IntelliJ)** :
1. Allez dans Project > Appearance > Excluded Files pour afficher le dossier target.
2. Clic droit sur target/generated-sources/openapi/src/main/java > **Mark Directory as > Generated Sources Root**. 

📖 **Utilisation du Proxy API**
L'application expose deux endpoints qui redirigent les flux vers le Petstore :
- GET http://localhost:8081/api/petstore/users/{username}
- POST http://localhost:8081/api/petstore/users (Body JSON)

🏗 **Architecture des Packages**
Le code généré est structuré en trois packages distincts :
- com.petstore.client.api : Interfaces métier (ex: UserApi).
- com.petstore.client.model : Modèles de données (ex: User).
- com.petstore.client.invoker : Moteur technique (ApiClient).

