# Etapa 1: Construir la aplicación con Maven
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /workspace

# Copiar pom y dependencias
COPY pom.xml .
RUN mvn -q dependency:go-offline

# Copiar el código fuente
COPY src src

# Construir el JAR
RUN mvn -q package -DskipTests

# Etapa 2: Ejecutar el jar
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copiamos el archivo jar construido en la etapa anterior
COPY --from=build /workspace/target/agendafinanciera-0.0.1.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]