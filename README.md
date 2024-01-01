# Book & Library API // work in progress

![Static Badge](https://img.shields.io/badge/Book%20&%20Library%20API-Bootcamp-blue) ![Static Badge](https://img.shields.io/badge/Spring%20Boot-Tutorial-green) ![Static Badge](https://img.shields.io/badge/Microservices-Tutorial-green)

The purpose of this bootcamp is to fill all knowledge gaps and take a deep dive into Spring Boot.

As a software engineer, in most projects you work on, Spring and Spring Boot are already implemented and used vigorously. So, you must have used a bit of Spring Boot yourself and extended the API. However, getting to know its full functionality and setup is crucial in this age of flexible and scalable enterprise projects. Everyone wants it. Everyone needs it. Everyone is switching to this technology. Hence, a bootcamp becomes mandatory to grow in your career and get a good job.

In this bootcamp we build a Book / Library API from the ground up. For this need, we create five Spring Boot projects:
1. Config Client
2. Config Server
3. Feign Consumer
4. RestTemplate Consumer
5. Eureka Server

Each of them depend on each other, and is mandatory to make the applications run. They can be downloaded and should be opened in an IDE like [Spring Tool Suite 4](https://spring.io/tools/). Additionally, we also use Postman for testing our API's, which is [freely available online](https://www.postman.com/downloads/).

These projects were created using [Spring Initialzr](https://start.spring.io/).

## 1. Config Client
Spring Boot makes the development of Spring applications faster and easier. Let's analyze our first project *or* microservice (which is simply a small service doing something).

Spring Boot uses additional annotations. This includes `ComponentScan` to extend the packages to be searched for beans. For RESTful services, it uses the `RestController` annotation along with subordinate annotations like Get-/Post-/Put-/DeleteMapping to make it possible to handle different RESTful service requests. Further, Spring uses Aspect-Oriented Programming (AOP) to separate individual concerns in different programming packages: one for model, controller, service, respositories, exception, and response. 

Spring Boot is, like Spring, also based on **Inversion of Control (IoC)**, which is the delegation of creating objects and managing dependencies to a container and the idea behind a framework. It can also make use of annotation-based, setter-based or constructor-based **Dependency Injection (DI)**, where the goal is to create, initialize and wire a Java (or bean) objects defined in application classes and configurations, without the new keyword, and make them available to other components in the application.

This Spring Boot project `Config Client` is written as a Maven project with general Maven dependencies for JPA, databases, testing and Web (server). Here, you will learn what dependencies are needed. Next, we make the project visible with the server-port defined as `8888` in `application.properties`, as well as `default-zone` server URL set to `/eureka` and its internal access name set to `client`, and also include the cloud-client and cloud-eureka dependencies. This outsources the code like in the cloud and makes it visible only through a Eureka server. An Eureka server is a centralized registry that knows all client applications running on each port and IP address. Each microservice has to register to it.

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
For each of the model entities in the application, we define a repository interface. A repository includes all the methods such as sorting, paginating data and CRUD operations. For specifying that the underlying interface is a repository, a marker annotation `@Repository` is used.



