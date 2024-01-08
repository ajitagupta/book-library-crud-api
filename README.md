# Book & Library API // work in progress

![Static Badge](https://img.shields.io/badge/Book%20&%20Library%20API-Bootcamp-blue) ![Static Badge](https://img.shields.io/badge/Spring%20Boot-Tutorial-green) ![Static Badge](https://img.shields.io/badge/Microservices-Tutorial-green)

The purpose of this bootcamp is to fill all knowledge gaps and take a deep dive into Spring Boot Microservices.

As a software engineer, in most projects you work on, Spring and Spring Boot are already implemented and used vigorously. So, you must have used a bit of Spring Boot yourself and extended the API. However, getting to know its essential functionality and setup is crucial in this age of flexible, highly available distributed systems, and scalable enterprise projects.

In this bootcamp we build a Book / Library CRUD API from the ground up using Spring Boot. We will also use the Spring Cloud framework to build a distributed system with a microservice architecture. We create six Spring Boot projects or *six microservices*:

1. Config Client
2. Config Server
3. Feign Consumer
4. RestTemplate Consumer
5. Eureka Server
6. Spring Cloud API Gateway

Each of them depend on each other, and is mandatory to make the applications run. They can be downloaded and should be opened in an IDE like [Spring Tool Suite 4](https://spring.io/tools/). Here, you can quickly create a new project via `File -> New -> Spring Starter Project`. Additionally, we also use Postman for calling or *consuming* our API's, which is [freely available online](https://www.postman.com/downloads/).


## 1. Config Client
Let's analyze our first project *or* microservice (which is simply a small service doing something).

Spring Boot makes the development of Spring applications faster and easier.

Spring Boot is, like Spring, also based on **Inversion of Control (IoC)**, which is the delegation of creating objects and managing dependencies to a container and the idea behind a framework. It can also make use of annotation-based, setter-based or constructor-based **Dependency Injection (DI)**, where the goal is to create, initialize and wire a Java (or bean) objects defined in application classes and configurations, without the new keyword, and make them available to other components in the application.

Spring Boot uses additional annotations. This includes `RestController` annotation, which marks the class as a Controller, conventional URL's, along with subordinate annotations for HTTP verbs, to make it possible to handle RESTful service requests.

Now, let's have a look at some more unwieldy terms to support our API, which simply contains **CRUD (Create, Read, Update, Delete) operations** for the Book and Library class.


### Service
A Spring boot service is defined as a class file that includes the `@Service` annotation and allows developers to add business functionalities *or* business *logic*. The annotation is used with the classes that provide these business functionalities.

### Controller
The Spring boot framework is used to make the enterprise application which can be based on Groovy, Java, and Kotlin. By the use of this, we can make a web application; in order to have communication between the front and the backend, we require controllers in our applications; these controllers are responsible for handling the request from the client and providing them with the response in return.

The `@RestController` annotation is mainly used to mark the controller as a basic API endpoint used to access a service. This is what we call a REST API.

### Model
Model is an essential part of **MVC (Model-View-Controller) pattern** which is widely used in Spring. A Model is a holder of the context data (obtained from the database) passed by a Controller to be displayed on a View.
### View
All MVC frameworks for web applications provide a way to address views. Spring provides view resolvers, which enable you to render models in a browser without tying you to a specific view technology. All controllers in the Spring Web MVC framework return a `ModelAndView` instance. Views in Spring are addressed by a view name and are resolved by a view resolver. 

### Repository
Now that we have our model designed, we can create our JPA repositories (alert: you must be familiar with basic database concepts and the JPA framework to be able to follow) so we can store and read our Java objects. Following our packaging structure and the layered application pattern, we'll create repositories in a new repository
package.

For each of the model entities in the application, we define a repository interface. The repository `JPARepository` includes all the methods such as sorting, paginating data and CRUD operations, making it a very convenient solution that is available under Spring JPA. One can thus implement this interface with an underlying interface. For specifying that the underlying interface is a repository, a marker annotation `@Repository` is used.

### Altogether...
We run the application by specifying a portnumber (e.g. `8080`) in `application.properties`. Our application can be accessed in the browser under `http://localhost:portnumber`.

## 2. Config Server

### Configuration
Configuration is the process of specifying and loading external values to the software application statically or dynamically.

In a monolith architecture, there is a single application server running and we traditionally store the application configuration in the environment or application level. Since all the modules of the application are running on a single server it is easy to handle the config in a single place.

Microservices architecture is a distributed system architecture where there are a lot of independent services running and it is very challenging to maintain the config with the dynamic growth of the application instances based on demand. Moreover, each microservice needs different configurations for different environments like Dev, QA, UAT, and Prod.

### Configuration Server
The solution to these problems is externalizing the microservices configuration to an external location to handle it from a single place using a dedicated microservice called Configuration Server.

The centralized configuration works using a typical client-server architecture pattern. There is a dedicated microservices application called Config Server which has access to the Configuration store like a git repository. Then each microservices in the system is a Config Client that gets the location of the Config Server from the Discovery server (here we use Eureka) during application startup. Hence, the names Config Server and Config Client.

An Eureka server is a centralized registry that knows all client applications running on each port and IP address. Each microservice has to register to it.

## 3. Feign Consumer

The Feign Consumer doesn't add new functionality. It simply *consumes* our CRUD API without exposing it to the outside world.

The Feign Consumer is a special type of consumer in the sense that there is need to write any implementation to call the RESTful services. This is called a *declarative* approach.

Feign allows you to abstract the mechanics of calling a REST service. Once you configure and annotate the Feign interface, you can call a REST service by making a simple Java function call. The actual implementation of making a REST call is handled at runtime by Feign. This means that the implementation can be configured without changing your business logic code.

By just changing the Feign configuration in Java or using properties you can add encoding/decoding, logging, and change the REST call implementation library. All this is done through configuration only, while the business logic that calls the service remains unchanged (inside Config Client).

Since Feign uses standard Java interfaces, it's also easy to mock them during unit tests.

## 4. RestTemplate Consumer

The RestTemplate doesn't add new functionality either. It also simply consumer our CRUD API using the class `RestTemplate`.

Spring RestTemplate class is part of Spring Web, introduced in Spring 3. RestTemplate class provides overloaded methods for different HTTP methods, such as GET, POST, PUT, DELETE etc.

When we use the RestTemplate to call the RESTful service, it creates duplication of code that talks to RESTful services. When we define Feign, we need only to define a proxy and define a single method into it. Feign helps us to simplify client code to talk to the RESTful web services.

RestTemplate offers developers a high degree of flexibility and control over HTTP requests, which is advantageous in intricate scenarios.

## 5. Eureka Server

Eureka is a service discovery tool supported by Spring. It enables loose coupling, i.e. two microservices don't have to talk to each other, e.g. to share under which IP and port they are available.

### Load Balancing

If we spin up two instances of a microservice, they will both register in Eureka with the same alias (since they have the same application name). Let's say we have our new instance located at http://localhost:8082. When the first microservice, as a client, wants to contact http://client/, Eureka will return both URL's and it's up to the consumer to decide which instance should be called (using Ribbon—the load balancer—together with Eureka's registry client). By default, Ribbon would apply a simple Round-Robin strategy.

## 6. Spring Cloud API Gateway

After adding a dependency in `pom.xml` and several routing entries to `application.properties` we access our CRUD API via `http://localhost:8099/client/library/22`.


## Screenshots


### Postman: Testing the Config Server
Config Server lets us send out a get request to the library API under port `8080` (as specified by `application-dev.properties`). We get the `404 - NOT FOUND` error as a response, since we haven't added a library to our H2 database yet.

![Postman testing](https://i.ibb.co/WyWByWK/postman-testconfigserver.png "Postman testing")

### Testing Eureka
All registered microservices are visible under Eureka under port 8761.

![Eureka on port 8761](https://i.ibb.co/H7PCQm3/eureka.png "Eureka on port 8761")


## References
- [YouTube Playlist by Telusko](https://www.youtube.com/watch?v=3WqDbU_Xnu4&list=PLsyeobzWxl7rRyGcqgZ3MP5pWGPwUvprI)
- [Learning Microservices with Spring Boot](https://www.amazon.com/Learn-Microservices-Spring-Boot-Containerization/dp/1484261305/ref=sr_1_1?crid=9U8WG19NS9E7&keywords=learning+microservices+with+spring+boot&qid=1704288545&sprefix=learning+microservi%2Caps%2C211&sr=8-1)
- Stackoverflow
- Medium
