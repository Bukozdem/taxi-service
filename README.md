﻿# Taxi service 🚕

## Project description
This is a web application that provides taxi administration. All information is stored in a database and conveniently displayed on a browser page. A web filter has been set up for the privacy of the service, which allows only authorized users to log in and work with the data. All actions are logged. The project is built on the principles of object-oriented programming, so it can be easily maintained and scaled.

## Features
- Driver registration;
- Driver authentication;
- Show a list of all drivers/cars/manufacturers and cars by driver;
- Adding/updating/removing drivers/cars/manufacturers;
- Adding driver to car and removing driver from car;
- Recording and retrieving information from the database;
- Logging all actions in file.

## Project structure
The project has four layers: web-filter, controller, service and dao.
When you start a project, the filter determines whether we have the right to go to a page. If we are not authenticated or want to access a not allowed page, the filter redirects us to the login page.
Going to the page /index, we have the opportunity to see the list and, if necessary, delete the drivers/cars/manufacturers, add the driver/car/manufacturer and add the driver to the car.
After receiving the command, the controller calls the desired method at the service level, which under the hood calls the method at the dao layer, where sends queries to the relational database (MySQL) to receives, records, edits or deletes information.

## Technologies
- Java Servlet API;
- Java Server Pages Technology;
- Java Database Connectivity (JDBC) API.

## Instructions for starting the project
- To start the project, you need to install and configure the Tomcat servlet container (version 9.0.50) in IntelliJ IDEA (Ultimate version);
- Configure the connection to the database in the ConnectionUtil class;
- Data for creating schema and tables (if not exists) can be found in the init_db.sql file (resource folder);
- Run Tomcat.
