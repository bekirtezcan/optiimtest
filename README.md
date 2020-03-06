**OPTIIM TEST PROJECT**

Spring Boot & Spring Webflux & RabbitMQ & MongoDB & Docker & Eureka / Zuul

**_MongoDB_**

Downloading image -> `_docker pull mongo_`
Deploying image -> `_docker run -d -p 27017-27019:27017-27019 --name mongodb mongo:4.0.4_`

Default ports are used.

**_RabbitMQ_**

Downloading image -> `_docker pull rabbitmq_`
Deploying image -> `_docker run -d --hostname rabbit --restart=always -p 5672:5672 -p 15672:15672  --name rabbit abbitmq:latest_`

Default ports are used.

_**To Make It Work**_

1. Maven update all projects/modules
2. Run all modules

"Server"

"EmailService"

"NoteService"

"UserService"

"SpringEurekaAuth"

"SpringEurekaCommon"

"ZuulProxy"


You can see all registered services by opening `localhost:8761`

And you can use all the system by `localhost:8762`

To get a Bearer Token please use one of the credentials below. They are hard-coded.

"admin:12345"

"optiim:12345"

"userName:12345"

**_Postman_**

You can import JSON file ("_optiim.postman_collection.json_") into the POSTMAN which is under the main directory of the project. After importing, you will see basic requests for this test project. To be able to use those requests, you may need to do some changes on body part of the request like "userId","noteId" etc.