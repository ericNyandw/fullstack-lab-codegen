# --- ÉTAPE 1 : Build (Compilation) ---
#  On utilise une image Maven avec Java 17 pour compiler le projet
FROM maven:3.8.5-openjdk-17-slim AS build
LABEL authors="ericn"

# Répertoire de travail dans le conteneur
WORKDIR /app

# Copie du pom.xml  pour télécharger les dépendances  dans le dossier /app/ du conteneur
COPY pom.xml .
RUN mvn dependency:go-offline

# Copie du code source et compilation
COPY src ./src
RUN mvn clean package -DskipTests

# --- ÉTAPE 2 : Runtime (Exécution) ---
# On utilise une image JRE légère pour l'exécution et  la production
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# On récupère uniquement le JAR généré à l'étape précédente (donc Récupération du JAR généré à l'étape 1)
# Remplace 'nom-de-ton-projet.jar' par le nom généré dans ton dossier target/
COPY --from=build /app/target/*.jar app.jar

# Port exposé par ton Spring Boot (8081 dans ton cas)
EXPOSE 8081
# Commande de lancement
ENTRYPOINT ["java", "-jar", "app.jar"]
