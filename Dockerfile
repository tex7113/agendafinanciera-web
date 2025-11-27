# Imagen base Java 17 estable
FROM eclipse-temurin:17-jdk

# Establecer directorio de trabajo
WORKDIR /app

# Copiar el JAR compilado
COPY target/agendafinanciera-0.0.1.jar app.jar

# Exponer el puerto (Spring Boot usa 8080 por defecto)
EXPOSE 8080

# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]

#FROM eclipse-temurin:17-jdk
#ARG JAR_FILE=target/agendafinanciera-0.0.1.jar
#COPY ${JAR_FILE} app_agenda.jar
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "app_agenda.jar"]