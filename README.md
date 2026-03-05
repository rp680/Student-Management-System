# Student-Management-System
Student Management System (Java + JDBC)
📌 Project Overview

The Student Management System is a simple Java console-based application that performs basic CRUD operations (Create, Read, Update, Delete) on student records using JDBC and MySQL.

This project demonstrates how to connect a Java application with a MySQL database and perform database operations using PreparedStatement.

It is designed as a beginner-friendly project to understand database connectivity, SQL queries, and Java programming concepts.

🛠️ Technologies Used

Java

JDBC (Java Database Connectivity)

MySQL Database

PreparedStatement

Git & GitHub

Project/ │ ├── StudentManager.java # Main program with menu-driven system ├── DBConfig.java # Database configuration (URL, username, password)


▶️ How to Run the Project

Install MySQL and create the database.

Create the table using the SQL schema provided above.

Update your database credentials in DBConfig.java.

static String url = "jdbc:mysql://127.0.0.1:3306/testDB";
static String user = "root";
static String password = "your_password";

Add the MySQL JDBC Driver to your project.

Compile and run the program.
