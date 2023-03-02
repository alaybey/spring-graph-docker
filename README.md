# Getting Started

## Information

This repository created for a task.
Spring Framework used based Java 19 with Maven. GraphQL implemented for query manipulation. 
Docker and docker-compose used for containerization.


## Installation

You have to install docker and docker-compose if you want use with container: 

    docker-compose up --build
    
Without docker:

Firstly, you have to run a postgresql db and should change db url from `application.properties` 
    
    mvn clean install
    mvn spring-boot:run


`5432` is default Postgres Port

`8080` is default Spring Boot App Port

## Usage

So, GraphiQL enabled and you can reach from `/graphiql?path=/graphql`

Example: `http://localhost:8080/graphiql?path=/graphql`


### Tech Documentation

* [App Doc]()

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.3/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.3/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.0.3/reference/htmlsingle/#web)
* [Spring for GraphQL](https://docs.spring.io/spring-boot/docs/3.0.3/reference/html/web.html#web.graphql)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.0.3/reference/htmlsingle/#data.sql.jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Building a GraphQL service](https://spring.io/guides/gs/graphql-server/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

