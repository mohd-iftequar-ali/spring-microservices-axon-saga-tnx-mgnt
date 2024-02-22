<h1> Distributed Transaction Managment in Java Microservices, Spring Boot|Cloud, Using SAGA & CQRS Design Patterns,  
AXON Framework</h1>

<p> We have created 2 microservices to demonstrate happy scanerio & error scanerio with compensating transaction rollback between these 2 microservices</p>
<h2>eureka naming server</h2>
<h2>spring cloud API Gateway</h2>
<h2>car-inventory microservice</h2>
<h2>car-booking microservice</h2>


<h3>First Thing First Download Axon Server & Install</h3>

Go To Axon Installed Directory
..AxonServer\AxonServer-2023.2.1[Version]
Here Start the Axon Server By Using Below Command
java -jar axonserver.jar

<br />
<br />
<br />
<h3>Eureka Discovery Server URL</h3>

http://localhost:8761/


<br />
<br />
<br />
<h3>Spring Cloud API Gateway</h3>

http://localhost:8765/

<br />
<br />
<br />
<h3>AXON Server URL</h3>

http://localhost:8024/#query

<br />
<br />
<br />
<h3>car inventoty H2 Database URL & connection details</h3>

http://localhost:9091/h2-console/
<br />
driver Class: org.h2.Driver
<br />
JDBC URL : jdbc:h2:~/car-inventory
<br />
username : root
<br />
password : root
<br />

<br />
<br />
<br />
<h3>car booking H2 Database URL & connection details</h3>

http://localhost:8081/h2-console/
<br />
driver Class: org.h2.Driver
<br />
JDBC URL : jdbc:h2:~/car-booking
<br />
username : root
<br />
password : root
<br />

<br />
<br />
<br />
<h3>car inventory microservice post api endpoint & payload</h3>

URL: http://localhost:8765/car-inventory-service/car-inventory
<br />
Method: POST
<br />
Payload:
<br />
```json
{
    "carName":"X5 xDrive40i xLine",
    "cc": "2998",
    "fuelType": "diesel",
    "yearOfManufacture": 2024,
    "color": "red",
    "inStockQuantity": 30
}
```
<br />
response ==> 8227ee76-e1b8-43b5-9566-ecbb0ad45404
<br />
NOTE:- Copy the response UUID and paste in carModelId payload car booking endpoint
<br />

<br />
<br />
<br />
<h3>car booking microservice post api endpoint & payload</h3>

URL: http://localhost:8765/car-booking-service/car-booking
<br />
Method: POST
<br />
Payload:
<br />
```json
{	
"carModelId": "8227ee76-e1b8-43b5-9566-ecbb0ad45404", <<==== paste the reposne UUID of car-inventory endpoint here
"quantity":1,
"customerId": "abc@gmail.com",
"advanceBookingPaidAmount": 600,
"totalAmount": 82895
}
```

<br />
<br />
<br />
<h3>Negative Scanerio Test Car Booking Service</h3>

http://localhost:8765/car-booking-service/car-booking
<br />
```json
{	
"carModelId": "8227ee76-e1b8-43b5-9566-ecbb0ad45404", <<==== paste the reposne UUID of car-inventory endpoint here
"quantity":50,
"customerId": "abc@gmail.com",
"advanceBookingPaidAmount": 600,
"totalAmount": 82895
}
```