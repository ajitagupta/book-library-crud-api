# Book & Library API // work in progress

![Static Badge](https://img.shields.io/badge/Book%20&%20Library%20API-Bootcamp-blue) ![Static Badge](https://img.shields.io/badge/Spring%20Boot-Tutorial-green) ![Static Badge](https://img.shields.io/badge/Microservices-Tutorial-green)

The purpose of this bootcamp is to fill all knowledge gaps and take a deep dive into Spring Boot.

As a software engineer, in most projects you work on, Spring and Spring Boot are already implemented and used vigorously. So, you must have used a bit of Spring Boot yourself and extended the API. However, getting to know its essential functionality and setup is crucial in this age of flexible, highly available distributed systems, and scalable enterprise projects.

In this bootcamp we build a Book / Library CRUD API from the ground up. We will also use the Spring Cloud framework to build a distributed system with a microservice architecture. We create five Spring Boot projects:
1. Config Client
2. Config Server
3. Feign Consumer
4. RestTemplate Consumer
5. Eureka Server

Each of them depend on each other, and is mandatory to make the applications run. They can be downloaded and should be opened in an IDE like [Spring Tool Suite 4](https://spring.io/tools/). Additionally, we also use Postman for testing or *consuming* our API's, which is [freely available online](https://www.postman.com/downloads/).

These projects were created using [Spring Initialzr](https://start.spring.io/).

## 1. Config Client
Spring Boot makes the development of Spring applications faster and easier. Let's analyze our first project *or* microservice (which is simply a small service doing something).

Spring Boot is, like Spring, also based on **Inversion of Control (IoC)**, which is the delegation of creating objects and managing dependencies to a container and the idea behind a framework. It can also make use of annotation-based, setter-based or constructor-based **Dependency Injection (DI)**, where the goal is to create, initialize and wire a Java (or bean) objects defined in application classes and configurations, without the new keyword, and make them available to other components in the application.

Spring Boot uses additional annotations. This includes `RestController` annotation, which marks the class as a Controller, conventional URL's, along with subordinate annotations for HTTP verbs, to make it possible to handle RESTful service requests. Further, Spring uses **Aspect-Oriented Programming (AOP)** to separate individual concerns in different layer packages: one for model, controller, service, respositories, exceptions, and response.

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

## 2. Config Server (Microservice: from monolith to microservice)

We started with a monolith. We have learnt to write a well-designed, layered Spring Boot application where we used a three-tier approach: model, application, presentation, and data. This is a well-known pattern for its benefits related to loose coupling and clear separation of responsibilities. Now, we split up the functionality. Once we get several of these applications, how are they going to connect to each other? How do they see each other's instances if they start to scale up? It's time to move to microservices.

This Spring Boot project `Config Server` is written as a Maven project with general Maven dependencies for JPA, databases, testing and Web (server). Here, you will learn what dependencies are needed. Next, we make the project visible with the server-port defined as `8888` in `application.properties`, as well as `defaultZone` server URL set to `/eureka` under port `8761`. **Service Registry** (a new microservice!) maps the internal application name set to `client`. A *Registry Client* then translates these aliases to specific URL's, e.g. http://client/ to `http://localhost:8080` for our running Config Client. This outsources the code like in the cloud and makes it visible only through a Eureka server. An Eureka server is a centralized registry that knows all client applications running on each port and IP address. Each microservice has to register to it.

Spring Cloud Config Server provides an HTTP resource-based API for external configuration (name-value pairs or equivalent YAML content). The server is embeddable in a Spring Boot application, by using the @EnableConfigServer annotation. Consequently, the following application is a config server:

## 3. Feign Consumer

The Feign Consumer is a special type of consumer in the sense that there is need to write any implementation to call the RESTful services. This is called a *declarative* approach.

Feign allows you to abstract the mechanics of calling a REST service. Once you configure and annotate the Feign interface, you can call a REST service by making a simple Java function call. The actual implementation of making a REST call is handled at runtime by Feign. This means that the implementation can be configured without changing your business logic code.

By just changing the Feign configuration in Java or using properties you can add encoding/decoding, logging, and change the REST call implementation library. All this is done through configuration only, while the business logic that calls the service remains unchanged (inside Config Client).

Since Feign uses standard Java interfaces, it's also easy to mock them during unit tests.

## 4. RestTemplate Consumer


## 5. Eureka Server

Eureka is a service discovery tool supported by Spring. It enables loose coupling, i.e. two microservices don't have to talk to each other, e.g. to share under which IP and port they are available.

### Load Balancing

If we spin up two instances of a microservice, they will both register in Eureka with the same alias (since they have the same application name). Let's say we have our new instance located at http://localhost:8082. When the first microservice, as a client, wants to contact http://client/, Eureka will return both URL's and it's up to the consumer to decide which instance should be called (using Ribbon—the load balancer—together with Eureka's registry client). By default, Ribbon would apply a simple Round-Robin strategy.[

## Screenshots

// Eureka
// Postman


## References
- [YouTube Playlist by Telusko](https://www.youtube.com/watch?v=3WqDbU_Xnu4&list=PLsyeobzWxl7rRyGcqgZ3MP5pWGPwUvprI)
- [Learning Microservices with Spring Boot](https://www.amazon.com/Learn-Microservices-Spring-Boot-Containerization/dp/1484261305/ref=sr_1_1?crid=9U8WG19NS9E7&keywords=learning+microservices+with+spring+boot&qid=1704288545&sprefix=learning+microservi%2Caps%2C211&sr=8-1)
