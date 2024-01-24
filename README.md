# Book & Library CRUD API

![Static Badge](https://img.shields.io/badge/Book%20&%20Library%20API-Bootcamp-blue) ![Static Badge](https://img.shields.io/badge/Spring%20Boot-Tutorial-green) ![Static Badge](https://img.shields.io/badge/Microservices-Tutorial-green) ![Static Badge](https://img.shields.io/badge/Spring%20Cloud-Tutorial-green) ![Static Badge](https://img.shields.io/badge/Architecture%20Patterns-Tutorial-green)

The purpose of this bootcamp is to take a deep dive into each concept, give an overview, and explain the foundational ideas behind Springboot and microservice architecture.

As a software engineer, in most projects you work on, Spring and Spring Boot are already implemented and used vigorously. So, you must have used a bit of Spring Boot yourself and extended the API. However, getting to know its essential functionality and setup is crucial in this age of flexible, highly available distributed systems, and scalable enterprise projects.

In this bootcamp we build a Book / Library CRUD API from the ground up using Spring Boot. We will also use the Spring Cloud framework to build a distributed system with a microservice architecture. We create seven Spring Boot projects or *seven microservices*. Each of these projects can be opened in an IDE like [Spring Tool Suite 4](https://spring.io/tools/):

1. [Config Client](https://github.com/ajitagupta/book-library-api/tree/main/springbootpractice-config-client)
2. [Config Server](https://github.com/ajitagupta/book-library-api/tree/main/springbootpractice-config-server)
3. [Spring Cloud OpenFeign Consumer](https://github.com/ajitagupta/book-library-api/tree/main/springbootpractice-consumer-feign)
4. [RestTemplate Consumer](https://github.com/ajitagupta/book-library-api/tree/main/springbootpractice-consumer-resttemplate)
5. [Pattern: Service Discovery with Eureka Server](https://github.com/ajitagupta/book-library-api/tree/main/springbootpractice-eureka)
6. [Spring Cloud API Gateway](https://github.com/ajitagupta/book-library-api/tree/main/springbootpractice-gateway)
7. [Pattern: Fault Tolerance with Resilience4j Consumer](https://github.com/ajitagupta/book-library-api/tree/main/springbootpractice-consumer-resilience4j)

### Note

A **microservice** scales as a single entity and communicates with other microservices. We will take advantage of Spring Cloud (one of the most robust ways of creating microservices today) and the Service Discovery pattern to make the microservices *discoverable* to each other and work well together.

While a framework like Spring boot is a set of common libraries and code, an **architecture pattern** like Service Discovery is a concept, or a receipt for how to get a specific problem done.

We need a way for calling or *consuming* our API's programmatically. We do this using Postman, which is [freely available](https://www.postman.com/downloads/).

We make use of two databases for two separate user profiles: Dev (H2 database, accessible over `http://localhost:portnumber/h2-console`) and QA (mySQL database, accessible over a client like SQLyog).

## 1. Config Client
Let's analyze our first project *or* microservice, the Config Client.

We clarify some unwieldy terms to support our API, which contains a simple **CRUD (Create, Read, Update, Delete) backend for Books and Libraries**. Familiarizing yourself with these terms is very important to understand how the backend of an enterprise web application works.

### Spring Boot

Spring Boot makes the development of Spring applications faster and easier.

Spring Boot is, like Spring, also based on **Inversion of Control (IoC)**, which is the delegation of creating objects and managing dependencies to a container and the idea behind a framework. It can also make use of annotation-based, setter-based or constructor-based **Dependency Injection (DI)**, where the goal is to create, initialize and wire a Java (or bean) objects defined in application classes and configurations, without the new keyword, and make them available to other components in the application.

Spring Boot uses additional annotations. This includes `SpringBootApplication` annotation, which marks the class as a Springboot application.

### Service
A Spring Boot service is defined as a class file that includes the `@Service` annotation and allows developers to add business functionalities *or* business *logic*. The annotation is used with the classes that provide these business functionalities.

### Controller
The Spring Boot framework is used to make the enterprise application which can be based on Groovy, Java, and Kotlin. By the use of this, we can make a web application; in order to have communication between the front and the backend, we require controllers in our applications; these controllers are responsible for handling the request from the client and providing them with the response in return.

The `@RestController` annotation is mainly used to mark the controller as a basic API endpoint used to access a service. This is what we call a REST API.

### Model
Model is an essential part of **MVC (Model-View-Controller) pattern** which is widely used in Spring. A Model is a holder of the context data (obtained from the database) or *domain logic* passed to a Controller to be displayed on a View.
### View
All MVC frameworks for web applications provide a way to address views. Spring provides view resolvers, which enable you to render models in a browser without tying you to a specific view technology. All controllers in the Spring Web MVC framework return a `ModelAndView` instance. Views in Spring are addressed by a view name and are resolved by a view resolver. 

### Repository
Now that we have our model designed, we can create our JPA repositories (alert: you must be familiar with basic database concepts and the JPA framework to be able to follow) so we can store and read our Java objects. Following our packaging structure and the layered application pattern, we'll create repositories in a new repository package.

For each of the model entities in the application, we define a repository interface. The repository `JPARepository` includes all the methods such as sorting, paginating data and CRUD operations, making it a very convenient solution that is available under Spring JPA. One can thus implement this interface with an underlying interface. For specifying that the underlying interface is a repository, a marker annotation `@Repository` is used.

### Putting it all together

We add the dependencies for web applications, JPA, and the database in `pom.xml`.

We write the CRUD Rest API.

![MVC pattern](https://i.ibb.co/pK0s6z4/mvc-drawio.png "MVC pattern")

![MVC pattern](
https://viewer.diagrams.net/?tags=%7B%7D&highlight=0000ff&edit=_blank&layers=1&nav=1&title=mvc.drawio.svg#R5Vpdd6I4GP41XuoJRD68rFJn95yZ1lN3O9O9i5JqtoFgCFXn128CQYGgrZ06x229UHjyQfI%2Bb97nTbADR9HmC0fJ8hsLMe3YINx0YNCxbRsAIH8Usi0Qz7MLYMFJWEDWHpiSn1iDut0iIyFOaxUFY1SQpA7OWRzjuahhiHO2rld7ZLT%2B1AQtsAFM54ia6HcSimWB%2Bra3x%2F%2FAZLEsn2y5g6IkQmVlPZN0iUK2rkDwugNHnDFRXEWbEabKeKVdinbjA6W7gXEci9c0gNPx8%2Febv3%2Feu9nTQ7b45m9Xq67u5RnRTE94xGLBGaWY62GLbWkLzrI4xKo7qwOH6yUReJqguSpdS%2FYlthQR1cWPhNIRo4znbaHnusBHCpf9V%2FDH%2FCPxVD71CVdK%2BtAOHE%2BWmBMtR425wJsKpCf%2BBbMIC76VVcrS0g21F9qevl%2FvOR1oaFmhs68xpL1oset5b2h5oW19gt1tw%2B5TzJ%2BJtOXHMfrOepdidGgY%2FQ4nLCWC6c4%2Fht2hf2F2dwy7a534MCZ37AszuW%2BYPEACzVBqBhipS4m6nG8pkebn8GXbzwqivs52AJo%2FLXL6bjMhu8EaTws9txyTMLfvub53CmHQ6kOn%2Fz6ESW%2BpE9Z3DML8FsJ2QvLujFmeQdlBqh4p3lyp5EYaA8ehvgzmFKUpmde52i8qYJIAgANwq7EBsILh6JixcVjLnExTV0zptJiyxDimSJDner7VZl79hAkjciR7aW8uPbvBUMoyPse6VTU%2FanTkWS90JBBfYGF0lLO9m%2FYvOIC5ZkPCZU5LWCxh9qi%2BEsxRATRcQ%2Fq9qBOPKFnEyiskcTKZg0O1OojMbK90QUTCUDUfcizXKZrlXSknSdQU80k7w44TqL4ywcq1bHhLzNR6r7lWCcmlPdVjbMlXT1e2BkWWb4ZZq83X4NlW7eB3rFppMb79oYp6AMISeFClPae8DTbV2sG2ejfBnMgJKzf4oGGguXqhB98WBixr0BtUPr53vN8zR4UyCB2LCiF%2BxpQlEdZD%2BHxxobG9g75vxgXvTHGB%2FEnh%2BN%2B%2FwtU%2Fqxs6vIsn43W%2F67aEBZcKPff8vKJcY%2B4qU0cAw3y1gfzAZA%2B5C%2F2bt52VwISlIkJxicshzpp1JVY8qoQPRKUsoldzwaqO8BXNMJ2ojZFyMhjMmBAsavEUwRqJISuyv9HuMKYl2CDgSB8%2BJfFzA2sMwPskft2mr%2BxkvuIrblvmZ53LV6w2Z2mwdaJebIj4UbkulMJz9O1eKdRNKRQtsX8wADX5Ab2BP2jIT%2F9NAnSQySJMH1Pcol4Rdot6KzF5WA9%2BCpokQXZ%2F62QRvOleljzBRpbaPzlLLUObe7astN05X7EtOc05D%2FvZpecYXeNEy3%2FjXsM4j2x2dG5Wzb2GoTHqwKBdYP4PKcY7SIXl1JMK2%2B2ZhwTn2m200rabwxHa7vAqw6n41Mx1reZevm%2BK%2FLnywWNqVCHunuD1waQsZgK%2F4hjuwKlbiPjTrWxFRK7BPdBy%2FGbNkIXtU7IwANzrq%2FF7EdTM2AF8VRbmeWciyHw38IsyZ2yxfQQOyJ%2FjHZe%2Fak7UOnjHzImO7UouRU4NJygPYU%2BVU7lLbvR0vrO7VgLa5PRSvOfFTNn5sF5hpGveb%2FUK871Xi1qnCYvVW5nPLNd2Y3cErde9jXmDXMvb%2FV8uCqL3f1yB1%2F8B "MVC pattern")

## 2. Config Server

### Configuration
Configuration is the process of specifying and loading external values to the software application statically or dynamically.

In a monolith architecture, there is a single application server running and we traditionally store the application configuration in the environment or application level. Since all the modules of the application are running on a single server it is easy to handle the config in a single place.

Microservices architecture is a distributed system architecture where there are a lot of independent services running and it is very challenging to maintain the config with the dynamic growth of the application instances based on demand. Moreover, each microservice needs different configurations for different environments like Dev, QA, UAT, and Prod.

### Configuration Server
The solution to these problems is externalizing the microservices configuration to an external location to handle it from a single place using a dedicated microservice called Configuration Server.

The centralized configuration works using a typical client-server architecture pattern. There is a dedicated microservices application called Config Server which has access to the Configuration store like a git repository. Then each microservice in the system is a Config Client that gets the location of the Config Server from the Discovery server (here we use Eureka) during application startup. Hence, the names Config Server and Config Client.

### Putting it all together

![Config Server](https://i.ibb.co/NjSLxxH/config-server.webp "Config Server")

To simulate the real world, we separate databases with respect to a user's profile inside `application-dev.properties` and `application-qa.properties`, place and link them to GitHub (or *Cloud*, which is where the name Spring Cloud comes from), using `spring.cloud.config.server.git.uri=https://github.com/ajitagupta/book-library-crud-api`.

We add database and Spring Cloud dependencies inside `pom.xml`.

We set the active profile of Config Client to `spring.profiles.active=dev`.

Later, the discovery server will come into the picture.


## 3. Spring Cloud OpenFeign Consumer

The Feign Consumer doesn't add new functionality. It simply *consumes* our CRUD API without exposing it to the outside world.

The Feign Consumer is a special type of consumer in the sense that there is need to write any implementation to call the RESTful services. We use the code already written (inside Config Client).

All we need is the additional `@EnableFeignClients`annotation, a new dependency, and a Feign interface, where we declare all the REST API's to be called. This is called a *declarative* approach.

With this declarative approach Feign abstracts the mechanics of calling a REST service. Once you configure and annotate the Feign interface, you can call your REST service by making a simple Java function call from your controller. The actual implementation of making a REST call is handled at runtime by Feign.


## 4. RestTemplate Consumer

The RestTemplate doesn't add new functionality either. It also simply consumer our CRUD API using the class `RestTemplate`.

Spring RestTemplate class is part of Spring Web, introduced in Spring 3. RestTemplate class provides overloaded methods for different HTTP methods, such as GET, POST, PUT, DELETE etc.

When we use the RestTemplate to call the RESTful service, it creates duplication of code that talks to RESTful services. When we define Feign, we need only to define a proxy and define a single method into it. Feign helps us to simplify client code to talk to the RESTful web services.

RestTemplate offers developers a high degree of flexibility and control over HTTP requests, which is advantageous in intricate scenarios.

## 5. Pattern: Service Discovery using Eureka Server

An Eureka server is a centralized naming registry that knows all client applications running on each port and IP address. Each microservice has to register to it.

Eureka is a service discovery tool supported by Spring. Two microservices will communicate by using the application name (instead of port and URL) via synchronous REST calls.

Mark `SpringbootpracticeEurekaApplication` with `@EnableEurekaServer` and add the Netflix dependency. Define a port. Eureka is online now!

![Eureka online](https://i.ibb.co/Kzf9d28/eureka-online.png "Eureka online")

Eureka has to be enabled on each microservice so that it becomes visible to the Eureka Server. This is done in each service's `application.properties` and with a new dependency in eacb `pom.xml`.

Don't forget to run a `Maven -> Update Project`. Your client has been registered on Eureka now:

![Eureka client online](https://i.ibb.co/DzFpv5M/eureka-discoveryclient.png "Eureka client online")


## 6. Spring Cloud API Gateway

This is a NO-JAVA project.

The gateway microservice contains a routing table that points to microservice aliases registered in Eureka, instead of physical addresses. This gives us a full solution based on an API gateway, service discovery, and 
load balancing.

With the help of an API gateway we can keep microservices unaware of the location  of a given functionality. No matter if we're splitting a  monolith or we decide to move some functionality to a different microservice, we can have all the other microservices working without any impact if they always pass through the API gateway. We get even looser coupling between our microservices. In addition, this edge service adds load balancing to our infrastructure.

After adding a dependency in `pom.xml` and several routing entries to `application.properties` we can access our CRUD API via `http://localhost:8099/client/library/22`.

Now start the gateway, the Eureka server, the config server, the config client, and the two other applications, in the respective order.


## 7. Pattern: Fault Tolerance with Resilience4j Consumer
In microservices, an application or service makes a lot of remote calls to applications running in different services, usually on different machines across a network. If there are many callers to an unresponsive service, you can run out of critical resources leading to cascading failures across multiple systems.

In case one of our microservices, especially the Config Client is down, we must have a fallback mechanism in place.

**Circuit breakers** are a design pattern to create resilient microservices by limiting the impact of service failures and latencies. The major aim of the Circuit Breaker pattern is to prevent any cascading failure in the system. In a microservice system, failing fast is critical. If there are failures in the Microservice ecosystem, then you need to fail fast by opening the circuit. This ensures that no additional calls are made to the failing service so that we return an exception immediately. This pattern also monitors the system for failures and, once things are back to normal, the circuit is closed to allow normal functionality.

Resilience4j is a new option for Spring developers to implement the circuit breaker, after Spring Cloud Hystrix got deprecated.

To test our new consumer we launch it once alongside Config Client and once without. We see our default message in the first (as shown in the screenshot below), and a dummy message in the second setting. 

## Screenshots

### Postman: Testing the Config Server
Config Server lets us send out a get request to the library API under port `8080` (as specified by `application-dev.properties`). We get the `404 - NOT FOUND` error as a response, since we haven't added a library to our H2 database yet.

![Postman testing](https://i.ibb.co/WyWByWK/postman-testconfigserver.png "Postman testing")

### Testing Eureka
All registered microservices are visible under Eureka under port `8761`.

![Eureka on port 8761](https://i.ibb.co/H7PCQm3/eureka.png "Eureka on port 8761")

### Testing Circuit Breaker
Our default message is shown when the Config Client is up.

![Circuit Breaker on port 8100](https://i.ibb.co/4gnKbBz/hystrix.png "Circuit Breaker on port 8100")


## References
- [YouTube Playlist by Telusko](https://www.youtube.com/watch?v=3WqDbU_Xnu4&list=PLsyeobzWxl7rRyGcqgZ3MP5pWGPwUvprI)
- [Learning Microservices with Spring Boot](https://www.amazon.com/Learn-Microservices-Spring-Boot-Containerization/dp/1484261305/ref=sr_1_1?crid=9U8WG19NS9E7&keywords=learning+microservices+with+spring+boot&qid=1704288545&sprefix=learning+microservi%2Caps%2C211&sr=8-1)
- Stackoverflow
- [Medium](https://dineshchandgr.medium.com/?source=post_page-----a48d4464722--------------------------------)
- [YouTube Playlist by Java Brains](https://www.youtube.com/playlist?list=PLqq-6Pq4lTTZSKAFG6aCDVDP86Qx4lNas)


## License
![Public Domain](https://i.ibb.co/74t3hCb/public-domain.png "Public Domain")

To the extent possible under law, Ajita Gupta has waived all copyright and related or neighboring rights to this work.


