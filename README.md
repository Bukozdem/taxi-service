# Taxi service 🚕

## Project description
Web-application that allows you to register a driver, authenticate and CRUD operations with data.

## Features
- Driver registration;
- Driver authentication;
- Log out;
- Show a list of all drivers / cars / manufacturers;
- Adding / updating / removing drivers / cars / manufacturers;
- Recording and retrieving information from the database.

## Project structure
The project has four layers: filter, controller, service and dao.
When you start a project, the filter determines whether we have the right to go to a page. If we are not authenticated or want to access a not allowed page, the filter redirects us to the login page.
Going to the page /index, we have the opportunity to see the list and, if necessary, delete the drivers / cars / manufacturers, add the driver / car / manufacturer and add the driver to the car.
After receiving the command, the controller calls the desired method at the service level, which under the hood calls the method at the dao layer, where sends queries to the relational database (MySQL) to receives, records, edits or deletes information.

## Technologies
- Java Servlet API;
- Java Server Pages Technology;
- Java Database Connectivity (JDBC) API.

## Instructions for starting the project
- To start the project, you need to install and configure the Tomcat servlet container (version 9.0.50) in IntelliJ IDEA (Ultimate version);
- Configure the connection to the database in the ConnectionUtil class;
- Data for creating schema and tables (if not exists) can be found in the init_db.sql file (resource folder).
- Run Tomcat

### Link to the project on Heroku: https://taxi-service-hw.herokuapp.com/

