# 📦 Proyecto de enrolamiento de alumnos 

Este proyecto es la base de mi certificacion de estudio de spring boot con java 21 y aws developer, donde se prente desplegar el proyecto en aws, el proyecto se base en consultas básicas del enrolamiento de alumnos en varios cursos de tecnología

---

## 🚀 Tecnologías y herramientas

- Java 21
- Spring Boot 3.x
- JPA / Hibernate
- ModelMapper
- Maven / Gradle
- Base de datos: PostgreSQL 
- Otros: Lombok, etc.

---

## 🧩 Arquitectura

Describe brevemente la estructura del proyecto:
- `controller/`: Exposición de endpoints REST
- `service/`: Lógica de negocio
- `repo/`: Acceso a datos con JPA
- `dto/`: Objetos de transferencia limpios
- `model/`: Mapeo de entidades JPA
- `config/`: Configuraciones generales (mappers.)

---

## 📄 Endpoints principales
API:

```bash
| Método  | Endpoint                             | Descripción                                                                 |
|---------|--------------------------------------|-----------------------------------------------------------------------------|
| GET     | `/api/enrolls`                       | Lista todos los enrolamientos                                               |
| POST    | `/v1/enrolls/studentnotes`           | Lista estudiantes con sus cursos enrolados y respectivas notas              |
| PUT     | `/v1/enrolls/studentsbycourse`       | Lista estudiantes agrupados por cursos                                      |
| DELETE  | `/students/3/{id}`                   | Elimina estudiantes por ID                                                  |
| GET     | `/v1/courses`                        | Obtiene todos los cursos disponibles                                        |
| POST    | `/v1/students`                       | Crea un nuevo estudiante                                                    |
| GET     | `/v1/students/{id}/details`          | Obtiene detalles completos de un estudiante, incluyendo enrolamientos       |
| PATCH   | `/v1/enrolls/{id}/grade`             | Actualiza la nota de un enrolamiento específico                             |
| DELETE  | `/v1/enrolls/{id}`                   | Elimina un enrolamiento específico                                          |
```



## 🧪 Ejecución y pruebas de la Imagen del backend

```bash
# Crear imagen del proyeto ubicandose en la raiz del proyecto para que tome el docker file 
-docker build --build-arg mypassword=root -t sebashh26/api-students .

-se coloca mypassword ya que esta en el docker file como variable de entorno env 

# Ejecutar localmente
 1.docker run --rm -p 8787:8787 -e host=host.docker.internal -it sebashh26/api-students bash : para ver los logs 
 2.docker run --rm -d -p 8787:8787 -e host=host.docker.internal -it sebashh26/api-students : -d para ejecutar en segundo plano
-host=host.docker.internal: se coloca eso cuando la base de datos no esta dockerizada y esta en máquina local
-p: Tu app sí se lanza dentro del contenedor, y escucha en el puerto 8787 (según tu Dockerfile y configuración Spring Boot). Pero ese puerto solo existe dentro del contenedor, no está expuesto a tu máquina local, por eso debo definir el port.

# Prueba
-curl -i http://localhost:8787/v1/enrolls/studentnotes
```
## 🧪 Dockerización de la base de datos
```bash
docker build -t sebashh26/bd-students .

docker run -d -p 5432:5432 sebashh26/bd-students

-Ingresar al bash para poder hacer consultas mediante la terminal
docker exec -it postgres_server bash
psql -U postgres -d mito-students
select * from enroll;
```

## 🧪 Creación de red
```bash
docker network create mito-net

docker run -d --name postgres_server --network mito-net -p 5432:5432 sebashh26/bd-students

docker run -d --network mito-net -e host=postgres_server -p 8787:8787 sebashh26/api-students

PROBAR EN POSTMAN
```

## 🧪 Subir las imagenes al docker hub 
```bash
docker buildx build --push --platform linux/amd64 --platform linux/arm64 --tag sebashh26/bd-students:0.0.1 .
docker buildx build --push --platform linux/amd64 --platform linux/arm64 --tag sebashh26/api-students:0.0.1 .

Nota: para ejecutar contrucción se debe ubicar en el file donde este el dockerfile de cada proyecto
```

## 🧪 Ejecutar proyecto mediante docker compose 
```bash

docker compose -f docker-compose-mito-student.yml up -d --no-build
-f: especifica el nombre del file ya que por lo general solo suelen llamarse docker-compose.yml y no necesita ser especificado como en este caso
-d: que se ejecute en segundo plano
--no-build: no necesita construir la imagen ya que 

```

