# Lattice-Java-Assignment
A Spring REST API that manages patient details and also the appointments.
Tools used: SQL Database, Hibernate, Spring Boot, Swagger
# REST end-points:
- POST: /api/create-> creates a new record, after validating every feild, else throws exception (if fields not validated)
- GET: /api/fetchDetails/{id}-> gets the record of the patient, corresponding to given ID
- GET: /api/fetchDetails-> gets all records, sorted by oldest appointment date assigned
- PUT: /api/modifybyID/{id}-> modifies the patient's record, corresponding to given ID
- PUT: /api/modifybyID/{name}-> modifes the patient's record, corresponding to given name
- DELETE: /api/deletebyID/{id}-> deletes the patient's record, corresponding to given id
- DELETE: /api/deletebyID/{name}-> deletes the patient's record, corresponding to given name
- PUT: /api/setDate/{id}-> modifies the patient record, corresponding to given ID, by assigning an appointment date in format (dd-mm-yyyy), passed as header in api request

## Fields in SQL DB:
- Name: min 3 characters
- Email: Valid Email
- Address: min 10 characters
- phone: Country code+ phone
- Password: min 8, max 15, with one uppercase, one lowercase, one digit

## Created Test classes for the api 
## Can test the API using Swagger
## How to run
- Enable SQL connection either using PHPMyadmin or SQL Server
- Modify the connections under applications.properties
- Run main application (LatticeAssignmentApplication.java)
- Test using Swagger: http://localhost:8080/swagger-ui.html
