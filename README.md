# ALUNO ONLINE API

API REST desenvolvida com Spring Boot para gerenciamento acadêmico de alunos, professores, disciplinas e matrículas.

O sistema permite realizar operações completas de gerenciamento escolar, incluindo controle de matrículas, atualização de notas, emissão de histórico acadêmico e gerenciamento de status do aluno.

---

# Funcionalidades

## 👨‍🎓 Alunos
- Cadastro de alunos
- Listagem de alunos
- Busca por ID
- Atualização de dados
- Remoção de alunos

---

## 👨‍🏫 Professores
- Cadastro de professores
- Listagem de professores
- Busca por ID
- Atualização de dados
- Remoção de professores

---

## 📘 Disciplinas
- Cadastro de disciplinas
- Listagem de disciplinas
- Busca por ID
- Atualização de disciplinas
- Remoção de disciplinas

---

## 📝 Matrículas
- Realizar matrícula de alunos
- Trancar matrícula
- Atualizar notas
- Aprovação/Reprovação automática
- Emissão de histórico escolar

---

# Regras de Negócio

O sistema possui regras acadêmicas automatizadas:

- Caso a média do aluno seja maior ou igual à média mínima:
  - Status → `APROVADO`

- Caso a média seja inferior:
  - Status → `REPROVADO`

- Matrículas também podem possuir os status:
  - `MATRICULADO`
  - `TRANCADO`
  - `DESLIGADO`

---

# 🛠️ Tecnologias Utilizadas

## Backend
- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- Lombok

## Banco de Dados
- PostgreSQL

## Ferramentas
- Insomnia
- DBeaver
- IntelliJ IDEA

---

# Arquitetura do Projeto

O projeto segue arquitetura em camadas:

```bash
src/main/java
│
├── controller
├── service
├── repository
├── model
├── dtos
├── enums
└── config
```

## Camadas

### Controller
Responsável pelos endpoints da API.

### Service
Contém as regras de negócio.

### Repository
Comunicação com banco de dados utilizando JPA.

### Model
Entidades do sistema.

### DTOs
Objetos de transferência de dados.

---

# Endpoints da API

# 👨‍🎓 Alunos

| Método | Endpoint |
|--------|----------|
| GET | /alunos |
| GET | /alunos/{id} |
| POST | /alunos |
| PUT | /alunos/{id} |
| DELETE | /alunos/{id} |

---

# 👨‍🏫 Professores

| Método | Endpoint |
|--------|----------|
| GET | /professores |
| GET | /professores/{id} |
| POST | /professores |
| PUT | /professores/{id} |
| DELETE | /professores/{id} |

---

# 📘 Disciplinas

| Método | Endpoint |
|--------|----------|
| GET | /disciplinas |
| GET | /disciplinas/{id} |
| POST | /disciplinas |
| PUT | /disciplinas/{id} |
| DELETE | /disciplinas/{id} |

---

# 📝 Matrículas

| Método | Endpoint |
|--------|----------|
| POST | /matriculas |
| PATCH | /matriculas/trancar/{id} |
| PATCH | /matriculas/atualizar-notas/{id} |
| GET | /matriculas/emitir-historico/{alunoId} |

---


# Exemplo de Histórico Escolar

O endpoint de histórico retorna:
- Disciplinas cursadas
- Notas
- Status das matrículas
- Média final

---

# Imagens
### Dbeaver

- Aluno
