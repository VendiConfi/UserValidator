# UserValidator
# User Validator Web Application

This is a web application that serves as a user validator system. Users can log in with their credentials and based on their role (user or validator), they will be redirected to specific pages with different functionalities.

## Prerequisites

Before running this application, ensure that you have the following:

1. Java Development Kit (JDK) installed on your machine.
2. An Integrated Development Environment (IDE) such as Eclipse or IntelliJ.
3. Apache Tomcat server installed and configured with your IDE.
4. MySQL database with two tables: `user` and `users`.

### Database Tables

#### Table: user

| Column Name | Data Type     | Description            |
|-------------|---------------|------------------------|
| name        | VARCHAR(100)  | User's name            |
| password    | VARCHAR(100)  | User's password        |
| role        | VARCHAR(20)   | User's role (user/validator) |

#### Table: users

| Column Name | Data Type     | Description                  |
|-------------|---------------|------------------------------|
| employee_id | VARCHAR(20)   | User's employee ID           |
| name        | VARCHAR(100)  | User's name                  |
| address     | VARCHAR(200)  | User's address               |
| doj         | DATE          | Date of joining (yyyy-mm-dd) |
| status      | VARCHAR(20)   | Status (not verified/verified)|

## How to Use

1. Clone or download the project from the repository.
2. Import the project into your IDE (Eclipse or IntelliJ).
3. Configure the Apache Tomcat server in your IDE and ensure it is running.
4. Create a MySQL database with the required tables as mentioned in the "Database Tables" section.
5. Update the database connection details in the `Validator` servlet (in `Validator.java`) and in the JSP files (if required).
6. Deploy the application to the Tomcat server and start the server.
7. Access the application by navigating to `http://localhost:8080/login.jsp`.

## Features

### Login Page (`login.jsp`)

The login page allows users to log in with their credentials (username and password). Upon successful login, the user is redirected to either `user.jsp` or `validator.jsp` based on their role.

### User Dashboard (`user.jsp`)

If the user has the role of a "user," they will be directed to the `user.jsp` page. In this page, the user can fill in their details, including name, employee ID, address, and date of joining. When the user clicks the "Submit" button, the entered data will be added to the `users` table in the database.

### Validator Dashboard (`validator.jsp`)

If the user has the role of a "validator," they will be directed to the `validator.jsp` page. On this page, the validator can view a table with all users' details from the `users` table. If a user is not yet verified, the validator has the option to verify the user by clicking the "Verify" button. When the validator verifies the user, the status of the user in the `users` table will change from "not verified" to "verified."

## Important Notes

1. It is recommended to use connection pooling and proper exception handling in production-ready applications.
2. Ensure that the database connection details are kept secure and not exposed in the code.
3. This is a simple example with minimal security measures. In real applications, you should implement proper authentication and authorization mechanisms.
4. Always sanitize and validate user inputs to prevent SQL injection and other security vulnerabilities.
5. Make sure the application is hosted on a secure and trusted server.

## Disclaimer

This application is provided as a sample project and should not be used in production without further enhancements to improve security and usability.

