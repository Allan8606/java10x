# 🎬 MovieFlix API

API REST para gerenciamento de catálogo de filmes, categorias e serviços de streaming, com autenticação JWT.

Projeto desenvolvido com **Spring Boot**, seguindo boas práticas de arquitetura em camadas (Controller, Service, Repository), DTOs, mappers e versionamento de banco de dados com Flyway.

---

## 🚀 Tecnologias Utilizadas

* Java 24
* Spring Boot 3.5.3
* Spring Web
* Spring Data JPA
* Spring Security
* JWT (Auth0)
* Bean Validation
* PostgreSQL
* Flyway
* Swagger / OpenAPI (Springdoc)
* Maven
* Lombok
* JUnit / Spring Security Test

---

## 📂 Estrutura do Projeto

```
src/main/java/com/allan/dev/MovieFlix
├── config        # Configurações (Security, JWT, Swagger)
├── controller    # Controllers REST
│   ├── request   # DTOs de entrada
│   └── response  # DTOs de saída
├── entity        # Entidades JPA
├── exception     # Exceções customizadas
├── mapper        # Conversão Entity <-> DTO
├── repository    # Repositórios JPA
├── service       # Regras de negócio
└── MovieFlixApplication
```

---

## 🔐 Autenticação

A aplicação utiliza **JWT (JSON Web Token)**.

Fluxo básico:

1. Registrar usuário
2. Realizar login
3. Utilizar o token JWT nas requisições protegidas

Header esperado:

```
Authorization: Bearer <token>
```

---

## 📑 Documentação da API (Swagger)

Após subir a aplicação, acesse:

* Swagger UI: `http://localhost:8080/swagger/index.html`
* OpenAPI Docs: `http://localhost:8080/api/api-docs`

---

## 📌 Endpoints Principais

### 🔑 Autenticação

* `POST /movieflix/auth/register` – Registrar usuário
* `POST /movieflix/auth/login` – Login

### 🎭 Categorias

* `GET /movieflix/category` – Listar categorias
* `POST /movieflix/category` – Criar categoria
* `GET /movieflix/category/{id}` – Buscar por ID
* `DELETE /movieflix/category/{id}` – Deletar

### 📺 Streaming

* `GET /movieflix/streaming` – Listar streamings
* `POST /movieflix/streaming` – Criar streaming
* `GET /movieflix/streaming/{id}` – Buscar por ID
* `DELETE /movieflix/streaming/{id}` – Deletar

### 🎬 Filmes

* `GET /movieflix/movie` – Listar filmes
* `POST /movieflix/movie` – Criar filme
* `GET /movieflix/movie/{id}` – Buscar por ID
* `PUT /movieflix/movie/{id}` – Atualizar filme
* `DELETE /movieflix/movie/{id}` – Deletar filme
* `GET /movieflix/movie/search` – Buscar filmes por categoria

---

## 🗄️ Banco de Dados

Banco utilizado: **PostgreSQL**

Migrações gerenciadas com **Flyway**:

```
src/main/resources/db/migration
├── V1__create_table_category.sql
├── V2__create_table_streaming.sql
├── V3__create_table_movie.sql
├── V4__create_table_movie_category.sql
├── V5__create_table_movie_streaming.sql
├── V6__create_table_user.sql
```

---

## ⚙️ Configuração

Arquivo `application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/movieflix
    username: postgres
    password: ******

movieflix:
  security:
    secret: minha-palavra-secreta
```

> ⚠️ **Importante:** não versionar credenciais reais. Use variáveis de ambiente.

---

## ▶️ Como Executar

Pré-requisitos:

* Java 24
* Maven
* PostgreSQL

Passos:

```bash
# Clonar repositório
git clone https://github.com/seu-usuario/movieflix.git

# Entrar no projeto
cd movieflix

# Executar aplicação
mvn spring-boot:run
```

---

## 🧪 Testes

Para executar os testes:

```bash
mvn test
```

---

## 📚 Aprendizados Aplicados

* Arquitetura em camadas
* DTOs e Mappers
* Segurança com JWT
* Validação de dados
* Migração de banco com Flyway
* Documentação com Swagger
* Boas práticas com Spring Boot

---

## 👨‍💻 Autor

Desenvolvido por **Allan Isaac** 🚀

Projeto educacional focado em boas práticas de desenvolvimento backend com Java e Spring Boot.
