# Task Manager REST API

API REST de gestion de tâches développée avec Spring Boot, PostgreSQL et Docker, puis déployée sur AWS.

## 🚀 Présentation

Ce projet consiste à développer une API REST permettant de gérer des tâches à travers des opérations CRUD :

- Création d'une tâche
- Consultation des tâches
- Modification d'une tâche
- Suppression d'une tâche

L'application utilise Spring Boot et Spring Data JPA pour la couche backend et PostgreSQL pour la persistance des données.

## 🛠️ Technologies

- Java 21
- Spring Boot
- Spring Data JPA / Hibernate
- PostgreSQL
- Maven
- Docker
- Docker Compose
- Git / GitHub
- Docker Hub
- AWS EC2
- Amazon RDS
- Swagger / OpenAPI

## ☁️ Architecture de déploiement

```text
GitHub
   ↓
Docker Hub
   ↓
AWS EC2
   ↓
Docker
   ↓
Spring Boot
   ↓
Amazon RDS PostgreSQL
