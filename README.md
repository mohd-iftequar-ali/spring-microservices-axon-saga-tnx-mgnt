First Thing First
Download Axon Server & Install
==============================
Go To Axon Installed Directory
..AxonServer\AxonServer-2023.2.1[Version]
Here Start the Axon Server By Using Below Command
java -jar axonserver.jar

<br />
<br />
<br />
Eureka Discovery Server URL
===========================
http://localhost:8761/


<br />
<br />
<br />
Spring Cloud API Gateway
========================
http://localhost:8765/

<br />
<br />
<br />
AXON Server URL
===============
http://localhost:8024/#query

<br />
<br />
<br />
car inventoty H2 Database URL & connection details
==================================================
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
car booking H2 Database URL & connection details
==================================================
<br />
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
car inventory microservice post api endpoint & payload
======================================================
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
car booking microservice post api endpoint & payload
=====================================================
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
Negative Scanerio Test Car Booking Service
==========================================
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