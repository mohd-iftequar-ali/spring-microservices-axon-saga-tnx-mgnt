#First Thing First
##Download Axon Server & Install
==============================
Go To Axon Installed Directory
..AxonServer\AxonServer-2023.2.1[Version]
Here Start the Axon Server By Using Below Command

java -jar axonserver.jar

Eureka Discovery Server URL
===========================
http://localhost:8761/
********************
********************
********************
********************
********************

Spring Cloud API Gateway
========================
http://localhost:8765/
********************
********************
********************
********************
********************

AXON Server URL
===============
http://localhost:8024/#query
********************
********************
********************
********************
********************

car inventoty H2 Database URL & connection details
==================================================
http://localhost:9091/h2-console/
driver Class: org.h2.Driver
JDBC URL : jdbc:h2:~/car-inventory
username : root
password : root
********************
********************
********************
********************
********************

car booking H2 Database URL & connection details
==================================================
http://localhost:8081/h2-console/
driver Class: org.h2.Driver
JDBC URL : jdbc:h2:~/car-booking
username : root
password : root
********************
********************
********************
********************
********************
********************
********************
********************
********************
********************

car inventory microservice post api endpoint & payload
======================================================
URL: http://localhost:8765/car-inventory-service/car-inventory
Method: POST
Payload:
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
response ==> 8227ee76-e1b8-43b5-9566-ecbb0ad45404
NOTE:- Copy the response UUID and paste in carModelId payload car booking endpoint
********************
********************
********************
********************
********************
********************
********************
********************
********************
********************

car booking microservice post api endpoint & payload
=====================================================
URL: http://localhost:8765/car-booking-service/car-booking
Method: POST
Payload:
```json
{	
"carModelId": "8227ee76-e1b8-43b5-9566-ecbb0ad45404", <<==== paste the reposne UUID of car-inventory endpoint here
"quantity":1,
"customerId": "abc@gmail.com",
"advanceBookingPaidAmount": 600,
"totalAmount": 82895
}
```
********************
********************
********************
********************
********************
********************
********************
********************
********************
********************

Negative Scanerio Test Car Booking Service
==========================================
http://localhost:8765/car-booking-service/car-booking

```json
{	
"carModelId": "8227ee76-e1b8-43b5-9566-ecbb0ad45404", <<==== paste the reposne UUID of car-inventory endpoint here
"quantity":50,
"customerId": "abc@gmail.com",
"advanceBookingPaidAmount": 600,
"totalAmount": 82895
}
```