# Spring Cloud Discovery 

[![Build Status](https://travis-ci.org/geraldoms/spring-cloud-discovery.svg?branch=master)](https://travis-ci.org/geraldoms/spring-cloud-discovery)

This is a very basic example using Eureka Service Discovery from Spring Cloud in a containerized environment.
It has basically three modules:

* [Client module](https://github.com/geraldoms/spring-cloud-discovery/tree/master/client): 
 This module contains a simple client using Netflix Ribbon in a round-robin fashion to access the service through the service discovery.
 
* [Discovery-server module](https://github.com/geraldoms/spring-cloud-discovery/tree/master/discovery-server):
This module contains the service discovery to keep the info to access the services.

* [Service module](https://github.com/geraldoms/spring-cloud-discovery/tree/master/service): 
This module contains the service that needs to be accessed and can be replicated according to demand.

The order to run the services, in this example, matters. Then, first you need to run the Discovery-server, 
then the Service (one or more instances) and finally the Client. When the Service starts, it will try to 
register into the Discovery-server and it will be ready to receive calls from the Client. 
To see the registered instances on Eureka access `http://localhost:8761`. A basic flow of the application is shown in the figure below.

<p align="center">
  <img width="500" height="400" src="https://user-images.githubusercontent.com/13106549/43099809-5023010e-8e91-11e8-935c-4a9962f6a39e.png">
</p>

## Requirements
* JDK 8 or later
* Maven 3.2+
* Docker 18+
* Docker-compose 1.2+

## Installation 
`$ mvn package`

## Usage 

After running the command above (in the installation section), you can start the application by running:   
 
`docker-compose up -d`

This command will create the images and start the containers in a correct order. It will start two instances of services.
The first time it can take a while. To make a resquest from the Client, you need to call this endpoint: `http://localhost:8080/services`.
 
To stop all containers, you need to run: 

`docker-compose down`

## Request samples

The client is using the Netflix Ribbon for Load Balancing in a round-robin fashion. 

Request:
```bash
curl http://localhost:8080/services
```
Response:
```json
This is the service: INSTANCE A
```

Request:
```bash
curl http://localhost:8080/services
```
Response:
```json
This is the service: INSTANCE B
```
