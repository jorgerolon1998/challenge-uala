
# Microblogging Platform

Este proyecto es una implementación simplificada de una plataforma de microblogging, similar a Twitter, que permite a los usuarios publicar mensajes cortos (tweets), seguir a otros usuarios y ver un timeline con los tweets de los usuarios que siguen.

## Tecnologías Utilizadas
- **Java 11**
- **Spring Boot**
- **Spring Data JPA**
- **H2 Database** (para pruebas)
- **RabbitMQ** (mockeado en pruebas)
- **Docker**

## Requisitos
- **Java 11** o superior
- **Maven 3.6+**
- **Docker** instalado en tu máquina

## Configuración del Entorno de Desarrollo

### Clonar el Repositorio

Clona el repositorio a tu máquina local:

```bash
git clone https://github.com/tu-usuario/microblogging-platform.git
cd microblogging-platform
```

### Compilar el Proyecto

Utiliza Maven para compilar el proyecto y generar el archivo JAR:

```bash
mvn clean install
```

### Ejecutar la Aplicación Localmente

Después de compilar, puedes ejecutar la aplicación localmente con:

```bash
java -jar target/microblogging-app.jar
```

La aplicación se iniciará en `http://localhost:8080`.

### Probar la Aplicación

Puedes probar la aplicación utilizando herramientas como `curl` o `Postman`.

#### Crear un Tweet

```bash
curl -X POST http://localhost:8080/tweets -H "Content-Type: application/json" -d '{"username": "user1", "content": "This is a tweet"}'
```

#### Ver el Timeline de un Usuario

```bash
curl http://localhost:8080/timeline?username=user1
```

## Trabajar con Docker

### Construir la Imagen Docker

Para empaquetar la aplicación en un contenedor Docker:

```bash
docker build -t microblogging-app .
```

### Ejecutar el Contenedor Docker

Para ejecutar la aplicación en un contenedor Docker:

```bash
docker run -p 8080:8080 microblogging-app
```

Esto ejecutará la aplicación en el puerto 8080 del contenedor, que estará mapeado al puerto 8080 de tu máquina host.

### Probar la Aplicación en Docker

Puedes usar los mismos comandos `curl` o Postman mencionados anteriormente para interactuar con la aplicación corriendo en Docker.

## Testing

Las pruebas unitarias e integradas están configuradas para ejecutarse con Maven:

```bash
mvn test
```

### Mocking de RabbitMQ

Durante las pruebas, RabbitMQ está mockeado para evitar la necesidad de un servidor RabbitMQ real.

## Despliegue

Para desplegar la aplicación, puedes utilizar el archivo Docker generado. Asegúrate de configurar un entorno de producción con un servidor de base de datos real en lugar de H2.

