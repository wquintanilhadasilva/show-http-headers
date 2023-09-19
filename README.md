# Read Me First
The following was discovered as part of building this project:

* The JVM level was changed from '11' to '17', review the [JDK Version Range](https://github.com/spring-projects/spring-framework/wiki/Spring-Framework-Versions#jdk-version-range) on the wiki for more details.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.3/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.3/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.3/reference/htmlsingle/index.html#web)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

# Cositas.... sobre o docker

## Gerar a imagem
```
docker build -t wquintanilhadasilva/show-http-headers .
```

## Logar no docker hub
```
docker login
```


## Publicar a imagem no docker hub
```
docker push wquintanilhadasilva/show-http-headers
```

## Subir o container da imagem
```
docker run -d --rm --name show-http-headers \
-p 8081:8081 \
wquintanilhadasilva/show-http-headers
```

## Testar

```
curl --request GET \
  --url http://localhost:8081/api/testes/headers
```
