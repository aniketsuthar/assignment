# Assignment
Retail store applicaiton

1) Run the application: 
 
 - Right click on the project and run it as spring boot application.
 - It will start embedded Tomcat server on port 8080.
 - Test it using postman or curl
 e.g. 
 
 curl --location --request POST 'http://localhost:8080/discount/getnetAmount' \
--header 'Content-Type: application/json' \
--data-raw '{
    "userType": "EMPLOYEE",
    "yearsSinceCustomer": 4,
    "totalBill": {
        "items": [
            {
                "type": "NOT_GROCERRY",
                "value": 100.0
            },
            {
                "type": "GROCERRY",
                "value": 490.0
            }
        ]
    }
}'

2) For Code coverage Right click on the project then Coverage As -> JUnit Test to generate coverage report  (Download the EclEmma Java Code Coverage from eclipse market place.)

3) To Run the unit tests Right click on the project and then Click on Run As -> JUnit Test

4) Swagger Ui is configured to check the API documentation and can be accessed via below link:

http://localhost:8080/swagger-ui.html
   
5) Calling API using Postman    
![image](https://user-images.githubusercontent.com/6484152/132824137-ae6aa021-c0b5-41b0-950c-357fe814a4a2.png)

