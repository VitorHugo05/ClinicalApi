## Projeto backend - Agendamento de consultas
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) ![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white) ![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white)

### 📌 Descrição
 Esse é um projeto backend desenvolvido para gerenciar o processo de agendamento de uma clinica medica, desenvolvido usando Java com Spring Boot e banco relacional JPA. O projeto segue como padrão a arquitetura hexagonal(ports & adapters), oque permite maior flexibilidade e escalonamento do projeto

 ---

### 🚀 Tecnologias

- Java 17

- Spring Boot (Spring Web, Spring Data JPA, Spring Security)

- PostgreSQL

- Docker e Docker Compose

- JWT (Autenticação)

- H2 Database

- BCrypt password encoder

---
### ⚙️ Instalação e Execução
### ✅ Requisitos

Antes de iniciar, certifique-se de ter instalado: 

- Java 17+

- Docker

- Docker Compose

- Gradle

### 🔧 Configuração

clone o repositorio:

    git clone https://github.com/VitorHugo05/ClinicalApi.git
    cd ClinicalApi

navegue e rode o docker compose:

    cd backend\docker
    docker-compose up -build

Isso iniciará a aplicação e o banco de dados H2.

🔑 Passando Variáveis de Ambiente na Linha de Comando

Se desejar definir a variável API_SECURITY_TOKEN_SECRET ao iniciar o Docker, utilize um dos seguintes métodos (Caso opte por não colocar, o spring ira colocar uma default fazendo assim a aplicação funcionar normalmente):

Linux/macOS:

    API_SECURITY_TOKEN_SECRET=meu-segredo-super-seguro docker-compose up --build

Windows(CMD)

    set API_SECURITY_TOKEN_SECRET=meu-segredo-super-seguro && docker-compose up --build

Windows (PowerShell):

    $env:API_SECURITY_TOKEN_SECRET="meu-segredo-super-seguro"; docker-compose up --build

Dessa forma, a variável API_SECURITY_TOKEN_SECRET será passada para o contêiner sem necessidade de um arquivo .env.

🏃‍♂️ Execução Manual (Sem Docker)

Caso queira rodar sem Docker, configure o banco localmente e execute:

        ./gradlew bootRun

---

### 🏛️ Arquitetura

Este projeto segue a Arquitetura Hexagonal, garantindo um design desacoplado e modular.

![Arquitetura hexagonal](./.github/hex-ports-adapters.svg)

📌 Principais Camadas:

Core (Casos de Uso): Contém as regras de negocios aplicadas, sem utilização de frameworks e acesso ao mundo externo.

Domain (Entidades): Representa os modelos de domínio.

Adapters (Interfaces e Infraestrutura): Inclui controllers, repositórios e serviços externos, é a camada que acessa o mundo externo.

Ports (Interfaces de Entrada e Saída): Define contratos para comunicação entre o core isolado da aplicação e o mundo externo.

📌 Estrutura de Diretórios:

    backend
    ├── docker
    │  └── docker-compose.yml
    ├── gradle
    ├── src
    │  ├── main
    │  │  ├── java
    │  │  │  └── com
    │  │  │     └── vitordev
    │  │  │        └── clinicalapi
    │  │  │           ├── adapters
    │  │  │           │  ├── in
    │  │  │           │  │  ├── controllers
    │  │  │           │  │  │  ├── exception
    │  │  │           │  │  ├── mapper
    │  │  │           │  │  ├── requests
    │  │  │           │  │  └── response
    │  │  │           │  └── out
    │  │  │           │     ├── consultation
    │  │  │           │     │  ├── repository
    │  │  │           │     │  │  ├── entity
    │  │  │           │     │  │  │  ├── enums
    │  │  │           │     │  │  ├── mapper
    │  │  │           │     ├── doctor
    │  │  │           │     │  ├── repository
    │  │  │           │     │  │  ├── entity
    │  │  │           │     │  │  ├── mapper
    │  │  │           │     └── patient
    │  │  │           │        ├── repository
    │  │  │           │        │  ├── entity
    │  │  │           │        │  ├── mapper
    │  │  │           ├── application
    │  │  │           │  ├── core
    │  │  │           │  │  ├── domain
    │  │  │           │  │  │  ├── enums
    │  │  │           │  │  │  ├── exceptions
    │  │  │           │  │  └── usecase
    │  │  │           │  │     ├── consultation
    │  │  │           │  │     ├── doctor
    │  │  │           │  │     └── patient
    │  │  │           │  └── ports
    │  │  │           │     ├── in
    │  │  │           │     │  ├── consultationjavajava
    │  │  │           │     │  ├── doctor
    │  │  │           │     │  └── patient
    │  │  │           │     └── out
    │  │  │           │        ├── consultation
    │  │  │           │        ├── doctor
    │  │  │           │        └── patient
    │  │  │           ├── infra
    │  │  │           │  ├── beans
    │  │  │           │  │  ├── consultation
    │  │  │           │  │  ├── doctor
    │  │  │           │  │  └── patient
    │  │  │           │  └── security
    │  │  │           └── ClinicalApiApplication.java
    │  │  └── resources
    │  │     ├── application-docker.yml
    │  │     ├── application-test.yml
    │  │     ├── application.yml
    │  │     └── data.sql
    ├── .gitattributes
    ├── .gitignore
    ├── build.gradle
    ├── Dockerfile
    ├── gradlew
    ├── gradlew.bat
    ├── HELP.md
    └── settings.gradle

---

### 📦 Bibliotecas Gradle

O projeto utiliza as seguintes dependências no Gradle:

    dependencies {
        implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
        implementation 'org.springframework.boot:spring-boot-starter-web'
        implementation 'org.hibernate.validator:hibernate-validator:8.0.0.Final'
        implementation 'jakarta.validation:jakarta.validation-api:3.0.2'
        implementation 'com.auth0:java-jwt:4.5.0'
        implementation 'org.springframework.security.oauth:spring-security-oauth2:2.5.2.RELEASE'
        testImplementation 'org.springframework.security:spring-security-test'
        compileOnly 'org.projectlombok:lombok'
        runtimeOnly 'com.h2database:h2'
        annotationProcessor 'org.projectlombok:lombok'
        implementation 'org.mapstruct:mapstruct:1.5.2.Final'
        annotationProcessor 'org.mapstruct:mapstruct-processor:1.5.2.Final'
        testImplementation 'org.springframework.boot:spring-boot-starter-test'
        testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
        testImplementation 'com.tngtech.archunit:archunit-junit5:1.2.1'
        testImplementation 'com.h2database:h2'
    }

---

### 📄 Modelo de Domínio
![modelo de dominio](/.github/modelo%20de%20dominio.jpg)

### Consulta

    public class Consultation {
        private Long id;
        private Doctor doctor;
        private Patient patient;

        private LocalTime startAt;
        private LocalTime endAt;
        private LocalDate date;

        private StatusConsultation status;
    }

### Doutor

    public class Doctor {
        private Long id;
        private String name;
        private String email;
        private String phone;
        private String specialty;
        private String password;
        private UserRole role;
        private List<Consultation> consultations;
    }

### Paciente

    public class Patient {
        private Long id;
        private String name;
        private String email;
        private String phone;
        private String password;
        private UserRole role;
        private List<Consultation> consultations;
    }

---

### 🔐 Autenticação e Segurança

- Implementação de autenticação via JWT.

- Proteção de rotas com Spring Security.

- Controle de acesso baseado em perfis e roles (Pacientes, Doutores e Admin).

- Crpitografia hash (HASH256) usando BCrypt

### ❌ Tratamento de Erros

O projeto conta com um handler global de exceções, padronizando as respostas de erro para a API.
Exemplo de resposta de erro:

    {
        "timestamp": "2025-02-14T12:00:00",
        "status": 404,
        "error": "Object not found",
        "message": "Doctor not found",
        "path": "/api/doctors/1"
    }
---

### 🤝 Contribuição

Fork este repositório.

Crie uma branch com sua feature (git checkout -b minha-feature).

Commit suas mudanças (git commit -m 'Adiciona nova funcionalidade').

Envie um Pull Request.

---

### 🤝 Entre em contato

[![Email](https://img.shields.io/badge/Email-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:vitorhugo.pozzi@gmail.com)  [![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/vitor-hugo-4a07a52ba/)  
