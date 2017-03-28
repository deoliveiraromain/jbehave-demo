# jbehave-demo
Jbehave examples used for presentation

## How-to

First, need a postgresql DB init with sql script sql/client.sql.

Make sur docker is installed.

```bash
docker build -t jbehave_postgresql .
docker run -p 5432:5432 jbehave_postgresql
```

Run app :

```bash
mvnw spring-boot:run
```

For tests, we need selenium server running :

```bash
java -jar selenium/selenium-server-standalone-3.3.1.jar
```

Finally, run the tests :

```bash
mvnw test -DargLine="-Dwebdriver.gecko.driver=<path-to-project>/selenium/geckodriver"
```
