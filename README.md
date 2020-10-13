## fibonacci

**install and running**: \
run commands: 
- mvn clean package spring-boot:repackage -Dactive.profile=Production
- sudo docker build . --tag demo
- cd ./src/main/docker
- docker-compose -f app.yml up\
 go to http://localhost:8080/fibonacci/swagger-ui.html for testing \
**TODO** 
- add liquibase and change security model
 
