# 📦 Franquicias API

Una API RESTful desarrollada en Spring Boot 3.4.5 para gestionar franquicias, sucursales y productos, persistiendo los datos en PostgreSQL.

---

## 🚀 Tecnologías usadas

- Java 17
- Spring Boot 3.4.5
- Spring Data JPA
- PostgreSQL
- Lombok
- Maven

---

## 🖥️ Requisitos del entorno

- Ubuntu 24.04
- Java 17 (`sudo apt install openjdk-17-jdk`)
- PostgreSQL (`sudo apt install postgresql postgresql-contrib`)
- Maven (`sudo apt install maven`)
- VS Code con extensiones:
  - Java Extension Pack
  - Lombok Annotations Support
  - Spring Boot Tools (opcional)

---

## ⚙️ Configuración de PostgreSQL

1. Inicia el servicio:

   ```bash
   sudo systemctl start postgresql
   ```

2. Accede al intérprete de comandos de PostgreSQL:

   ```bash
   sudo -u postgres psql
   ```

3. Crea una base de datos y un usuario:
   ```sql
   CREATE DATABASE nequi;
   CREATE USER admin WITH ENCRYPTED PASSWORD 'admin123';
   GRANT ALL PRIVILEGES ON DATABASE nequi TO admin;
   \q
   ```

---

## 🔧 Configuración de `application.properties`

Ubicado en: `src/main/resources/application.properties`

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/nequi
spring.datasource.username=admin
spring.datasource.password=admin123
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

---

## ▶️ Cómo ejecutar la aplicación

1. Clona el proyecto:

   ```bash
   git clone https://github.com/serosc95/franquicias-api.git
   cd franquicias-api
   ```

2. Compila y ejecuta con Maven:

   ```bash
   ./mvnw spring-boot:run
   ```

   o si no tienes `mvnw`:

   ```bash
   mvn spring-boot:run
   ```

3. La API estará disponible en:

   ```
   http://localhost:8080/api/
   ```

---

## 📬 Endpoints principales

| Método | Ruta                       | Descripción                                |
| ------ | -------------------------- | ------------------------------------------ |
| GET    | `/api/franquicia`          | Listar franquicias                         |
| POST   | `/api/franquicia`          | Crear una nueva franquicia                 |
| PATCH  | `/api/franquicia/{id}`     | Actualizar nombre de una franquicia        |
| POST   | `/api/sucursal`            | Crear una nueva sucursal                   |
| PATCH  | `/api/sucursal/{id}`       | Actualizar nombre de una sucursal          |
| POST   | `/api/producto`            | Crear un nuevo producto                    |
| DELETE | `/api/producto/{id}`       | Eliminar un producto                       |
| PATCH  | `/api/producto/{id}/stock` | Actualizar stock de un producto            |
| PATCH  | `/api/producto/{id}/name`  | Actualizar nombre de un producto           |
| GET    | `/api/producto/stock-max`  | Listar producto con más stock por sucursal |

---

## ✅ Buenas prácticas aplicadas

- Separación por capas: Controller, Service, Repository
- Principios SOLID en la arquitectura
- Validaciones con Jakarta Bean Validation
- Manejo global de errores
- Uso de DTOs para entrada de datos
