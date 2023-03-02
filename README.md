# Spring Cloud tanfolyam

## Felhasznált irodalom

Chris Richardson: Microservices Patterns, https://microservices.io/patterns/microservices.html
Vaughn Vernon: Domain-Driven Design Distilled

## Ajánlott irodalom

Microservices with Spring Boot and Spring Cloud: Build resilient and scalable microservices using Spring Cloud, Istio, and Kubernetes, 2nd Edition 2nd ed. Edition
Building Microservices - Designing Fine-Grained Systems 2nd Edition
Cloud Native Spring in Action

## Klónozás

```shell
git clone https://github.com/Training360/spr-cl-trainin-2023-02-28
```

## Saját projekt létrehozása

* `mentoring-app` könyvtár létrehozása
* A klónozott repo-ból az `employee-service` könyvtár átmásolása

## employee-service elindítása

* Docker Desktop indítása
* `docker ps` parancs kiadása

```shell
docker run -d -e POSTGRES_DB=employees -e POSTGRES_USER=employees -e POSTGRES_PASSWORD=employees -p 5432:5432  --name employees-postgres postgres
```

* JDK beállítása
* Alkalmazás indítása az `Application` osztállyal
* A Swagger elérhető a `http://localhost:8081/swagger-ui` címen

## REST kliens

* Vagy Postman
* Vagy Swagger 
* Vagy Visual Studio Code, REST Client Extension telepítésével képes kezelni a `.http` fájlokat

## course-service indítása és kiegészítése

* `Service` osztály kiegészítése (entitás, repo is)

```shell
docker run -d -e POSTGRES_DB=course -e POSTGRES_USER=course -e POSTGRES_PASSWORD=course -p 5434:5432  --name course-postgres postgres
```

* `enroll()` metódus implementálása

## frontend-service indítása és kiegészítése

* Kliens interfész használata REST webszolgáltatás híváshoz
* API composition, MapStruct használatával
* ConfigurationProperties bevezetése

## bff-service - Backend for frontend GraphQL használatával

* GraphQL bevezetése
* Grphiql kliens: `http://localhost:8088/graphiql`

## Gateway

## Caching

```shell
docker run --name employees-redis -p 6379:6379 -d redis
docker exec -it employees-redis redis-cli ping
docker exec -it employees-redis redis-cli --scan
docker exec -it employees-redis redis-cli get employee::1  
docker exec -it employees-redis redis-cli get "employees::SimpleKey []"
```

## Kafka

Kafka és Kafdrop elindítása:

```shell
docker compose up -d
```

## Carrier-service

```shell
docker run -d -e POSTGRES_DB=career -e POSTGRES_USER=career -e POSTGRES_PASSWORD=career -p 5435:5432  --name career-postgres postgres
```
## Keycloak indítása

```shell
docker run -d -e KEYCLOAK_USER=root -e KEYCLOAK_PASSWORD=root -p 8089:8080 --name keycloak jboss/keycloak
```

Keycloak elérés: `http://localhost:8089/`

Client Scopes/roles/Mappers/realm roles/Add to ID token