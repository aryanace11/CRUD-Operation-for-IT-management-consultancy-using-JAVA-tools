#Java Swing CRUD Application with JDBC & MySQL
This repository contains a simple CRUD (Create, Read, Update, Delete) application built with Java Swing for the frontend and JDBC with MySQL for the backend.

#Prerequisites
Java JDK (recommended version 8 or above)
MySQL Server
MySQL JDBC Driver (e.g., mysql-connector-java)
 Main
Features
Create: Add new records to the MySQL database.
Read: View existing records from the database.
Update: Modify existing records.
Delete: Remove records from the database.
Implementation Details
DatabaseConnection.java: This class is responsible for setting up a connection to the MySQL database using JDBC.

Login.java: Contains the main method to kick off the application.

Home.java: Defines the main window of the application using Java Swing components. This class contains buttons, text fields, and other GUI components required for CRUD operations.

Dependencies
The project uses the following dependencies:

MySQL JDBC Driver: To connect Java application to the MySQL database.
Add the JDBC driver to your classpath when compiling and running, or use a build tool like Maven or Gradle.

Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

License
This project is licensed under the MIT License - see the LICENSE.md file for details.
