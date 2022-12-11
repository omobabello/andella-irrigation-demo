# Irrigation Demo 

This project is a solution to a test provided by Andela. 

## SetUp 

To properly test this project, we need to configure our postgres database using `Docker`. 

- Confirm your have `Docker` installed. 
- RUN `docker create --name postgres-demo -e POSTGRES_PASSWORD=Welcome -p 5432:5432 postgres:11.5-alpine` to create postgres database.
- RUN `docker start postgres-demo`.
- RUN `docker exec -it postgres-demo psql create database irrigation-demo -U postgres`
- NAVIGATE to src>resources>database on your terminal
- RUN this command to create table
```agsl
docker cp create_tables.sql postgres-demo:/create_tables.sql
docker exec -it postgres-demo psql -d conference_app -f create_tables.sql -U postgres
```
- RUN this command to seed table 
```agsl
docker cp seed_data.sql postgres-demo:/seed_data.sql
docker exec -it postgres-demo psql -d conference_app -f seed_data.sql -U postgres
```
- Run `IrrigationDemoApplication`. 
- You can test on `localhost:8080/api/plots`
- You can find documentation 

## Testing 

- Confirm that container `postgres-demo` is running 
- Confirm that `IrrigationDemoApplication` is running 
- Run `mvn test`