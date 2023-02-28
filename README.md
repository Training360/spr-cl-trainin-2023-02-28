# Spring Cloud tanfolyam

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