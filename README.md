# Book & Library API

![Static Badge](https://img.shields.io/badge/Book%20&%20Library%20API-Bootcamp-blue) ![Static Badge](https://img.shields.io/badge/Spring%20Boot-Tutorial-green) ![Static Badge](https://img.shields.io/badge/Microservices-Tutorial-green)

The purpose of this bootcamp is to fill all knowledge gaps and take a deep dive into Spring Boot. In most projects you encounter, Spring and Spring Boot are already implemented and used vigorously. So, you must've have used a bit of Spring Boot yourself and extended the API. However, getting to know its full functionality and setup is crucial in this age of scalable enterprise projects. Everyone uses it. Everyone needs it. Everyone is switching to this technology. Hence, a bootcamp becomes mandatory to grow in your career and get a good job.

In this bootcamp we build a Book / Library API from the ground up. For this need, we create five Spring Boot projects:
1. Config Client
2. Config Server
3. Feign Consumer
4. RestTemplate Consumer
5. Eureka Server

Each of them depend on each other, and is mandatory to make the applications run. They can be downloaded and should be opened in an IDE like [Spring Tool Suite 4](https://spring.io/tools/). Additionally, we also use Postman for testing our API's, which is [freely available online](https://www.postman.com/downloads/).

## Config Client
Spring Boot makes the development of Spring applications faster and easier. Spring Boot uses additional annotations. This includes ComponentScan to extend the packages to be search. It uses the RestController annotation along with subordinate annotations like Get-/Post-/Put-/DeleteMapping make it possible to handle requests and write API's for each RESTful service, using URL paths. Further, Spring uses Aspect-Oriented Programming to separate individual concerns in different programming packages: one for model, controller, exception, respositories, and response.

Config Client is written as a Maven project with general Maven dependencies for JPA, databases, testing and Web (server). We make the project visible with the server-port defined as 8888 in application.properties, as well as default-zone server URL set to /eureka and its internal access name set to client, and also include the cloud-client and cloud-eureka dependencies. This outsources the code like in the cloud and makes it accessible only through a Eureka server.
