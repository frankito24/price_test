# Price Microservice

Este es un Microservice de precios construido con Spring Boot, utilizando Java 17 (Corretto), Gradle, y una base de datos H2. El servicio ofrece una API para obtener el precio aplicable de un producto en una fecha determinada.

## Arquitectura

El proyecto sigue una arquitectura hexagonal (también conocida como arquitectura de puertos y adaptadores). Esta arquitectura permite separar las preocupaciones del dominio central de la aplicación, facilitando la mantenibilidad y escalabilidad.

## Requisitos

- Docker
- Docker Compose
- JDK 17 (Amazon Corretto)

## Configuración del Proyecto

### Estructura del Proyecto

- `src/`: Código fuente de la aplicación.
- `docker-compose.yml`: Configuración de Docker Compose para levantar el servicio y la base de datos.
- `Dockerfile`: Archivo para construir la imagen Docker del servicio.
- `application.yaml`: Archivo de configuración de Spring Boot.
- `ZARA.postman_collection.json`: Colección de Postman con todos los servicios habilitados y pruebas de los diferentes casos de uso.
- `run-test.sh`: Script para validación simple mediante curl en ausencia de Postman.

### Configuración de la Base de Datos

La base de datos H2 se configura en el boostrap de la aplicación. Los datos necesarios se incluyen utilizando Liquibase.

### Variables de Entorno

En el archivo `application.yaml`, se pueden configurar las variables de entorno.

## Ejecución del Proyecto

Para clonar y ejecutar el proyecto, sigue estos pasos:

```shell
git clone https://github.com/frankito24/price-test.git
cd price-test
docker-compose up
```

# Documentación 

* [SWAGGER](http://localhost:8080/swagger-ui/index.html)
* Uso de ApiFirst para definición de contratos