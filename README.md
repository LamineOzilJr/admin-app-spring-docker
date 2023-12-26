# admin-app-spring-docker
Ce projet est un projet Spring Boot.

## Structure du Projet

La structure du projet se presente comme suit :

### Le package `sn.isi.entities`

Ce package contient les entités JPA avec les annotations obligatoires pour la configuration de notre base de donnees.

### Le package `sn.isi.dto`

Ce package contient des classes DTO (Data Transfer Object) pour les mêmes entités mais cette fois ci sans les annotations. 
Pour une forme de securite cela permet d'eviter une manipulation directe des objets de la base.

### Le package `sn.isi.dao`

Ce package contient des interfaces DAO (Data Access Object) pour chaque entité qui étendent `JpaRepository` pour la gestion des opérations CRUD.

### Le package `sn.isi.mapping`

Ce package contient des interfaces pour les mappers qui permettent de transformer chaque entité en Dto et chaque dto en entite

### Le package `sn.isi.exception`

Ce package contient des classes pour la gestion des exceptions.

### Le package `sn.isi.service`

Ce package contient des services pour chaque entité qui gèrent les opérations CRUD et d'autres plus personnalisés associées.

### Le package `sn.isi.config`

Ce package contient des configurations pour l'application, y compris la gestion des messages sources ainsi que la configuration des logs

### Le package `sn.isi.controller`

Ce package contient des RestControllers pour chaque entité pour gérer les opérations REST.

### `sn.isi`

Ce package contient la classe de base pour le démarrage de l'application Spring Boot.

## Docker

Nous avons utilisé du docker pour la conteneurisation  avec le fichier `docker-compose.yml` qui se trouve à la racine du projet
Ce fichier est un fichier de configuration YAML utilisé pour définir des services Docker dans le contexte de Docker Compose. Docker Compose est un outil qui permet de définir et de gérer des applications Docker multi-conteneurs. Il permet de spécifier l'ensemble des services, des réseaux et des volumes nécessaires pour qu'une application fonctionne. Ci après le contenu de ce fichier et les explications de chaque ligne.

```
version: '3.9'

services:
  mysql-admin-db: # cree un contemeur nomme  mysql-admin-db
    image: mysql:8.0
    container_name: container_mysql-admin-db
    environment: #configuration du conteneur mysql...
      MYSQL_ROOT_PASSWORD: root
      MYSQL_ALLOW_EMPTY_PASSWORD: yes
      MYSQL_DATABASE: adminapp-db
      MYSQL_USER: user
      MYSQL_PASSWORD: user
    ports:
      - 3306:3306
    volumes:
      - mysql_data:/var/lib/mysql
    healthcheck:
      test: mysqladmin ping -h 127.0.0.1 -u $$MYSQL_USER --password=$$MYSQL_PASSWORD


  phpmyadmin-admin-db:
    container_name: container_phpmyadmin-admindb
    image: phpmyadmin/phpmyadmin:latest
    ports:
      - 8085:80
    environment:  # Configuration PHPMyAdmin avec les informations nécessaires pour se connecter au serveur MySQL
      MYSQL_ROOT_PASSWORD: root
      PMA_HOST: mysql-admin-db
      PMA_USER: user
      PMA_PASSWORD: user
    depends_on: # Sugnifie que ce service dépend du service mysql-admin-db et ne devrait démarrer que si mysql-admin-db est prêt.
      - mysql-admin-db
    restart: unless-stopped

volumes:
  mysql_data:
    driver: local
```
