# Utiliza una imagen base de Amazon Corretto 17
FROM amazoncorretto:17 AS build

# Configura el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia todo el contenido del proyecto desde la raíz al directorio de trabajo del contenedor
COPY . .

# Otorga permisos de ejecución al wrapper Gradle (si estás usando Gradle)
RUN chmod +x ./gradlew

# Autogenera el OpenAPI con Gradle
RUN ./gradlew openApiGenerate

# Ejecuta el build sin los test (Esto debido a que es conveniente hacerlo en CI) con Gradle y compila la aplicación
RUN ./gradlew build

# Expone el puerto 8080 donde se ejecutará tu aplicación Spring Boot
EXPOSE 8080

# Comando para ejecutar tu aplicación Spring Boot cuando el contenedor se inicia
CMD ["java", "-jar", "build/libs/price_test-0.0.1-SNAPSHOT.jar"]
