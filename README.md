# LacosBabyAgenda

```sh
AgendaCli

```

## 1. Requisitos 

Instalar as seguintes ferramentas:

    1. JDK 1.8
    3. Maven
    4. Docker

##  2. Executar no linux  utilizando o docker ( pelo cmd )
```sh
    1- $ mvn clean
    2- $ mvn clean install
    3- $ docker-compose up -d && mvn spring-boot:run

```


##  3. Executar no windows  utilizando o sgbd postgres sem o docker ( pelo cmd )
```sh

  Antes no arquivo:( application.properties ) altere o usuario e a senha do seu postgres:

    1-  mvn clean
    2-  mvn clean install
    

```


##  4 Verificando a seguinte url

```sh
   http://localhost:8080


```
