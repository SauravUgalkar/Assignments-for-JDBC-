# Assignments-for-JDBC- task 1 , 2, 3, 4, 5 and next 4th cart JDBC
This assignment demonstrates Java Database Connectivity (JDBC) principles by performing CRUD (Create, Read, Update, Delete) operations on a MySQL database named advjava.

## Overview
This project contains five Java applications designed to interact with a MySQL database (`advjava`) to manage a `student` table. It covers the full lifecycle of database operations from connection to data modification.

## Prerequisites
* Java Development Kit (JDK)
* MySQL Database Server
* MySQL JDBC Driver (`com.mysql.cj.jdbc.Driver`)
* Database Name: `advjava` 

## File Structure & Usage

### 1. Database Connection
* **File:** `DBConnection.java`
* **Function:** Establishes a connection to the MySQL database using `DriverManager`.
* **Output:** Confirms "Database connection successful" upon success.

### 2. Fetch Data (Read)
* **File:** `Student.java`
* **Function:** Retrieves all records from the `student` table.
* **Output:** Displays data (ID, Name, Age) in a formatted tabular view in the console.

### 3. Insert Data (Create)
* **File:** `Input.java`
* **Function:** Accepts user input (ID, Name, Age) via `Scanner` and inserts a new record.
* [cite_start]**Key Feature:** Uses `PreparedStatement` with placeholders (`?`) to prevent SQL injection.

### 4. Update Data (Update)
* **File:** `Update.java`
* **Function:** Updates the **marks** column for a specific Student ID provided by the user.
* **Query:** `UPDATE student SET marks = ? WHERE id = ?`.

### 5. Delete Data (Delete)
* **File:** `Delete.java`
* **Function:** Prompts the user for a Student ID and permanently removes that record from the database.
* **Logic:** Binds the ID to the delete command and executes the update.




# Shopping Cart Management System (JDBC)

## 📌 Project Overview
This project is a Java-based console application designed to simulate the backend operations of an E-commerce platform. It provides a comprehensive system for managing a product inventory ("Admin" side) and a user shopping cart ("User" side) using **JDBC (Java Database Connectivity)**.

The application allows users to interact with a MySQL database to persistently store product details and cart selections. It emphasizes secure database coding practices and modular architecture.

## 🚀 Key Features

### 1. Product Management (Admin Module)
* **Inventory Control:** Add new products to the database with details like ID, Name, Price, and Quantity.
* **Update System:** Modify existing product details (e.g., updating price or stock levels).
* **Removal:** Delete obsolete products from the catalog.

### 2. Cart Management (User Module)
* **Shopping Experience:** Add specific products from the inventory to the cart.
* **Cart Updates:** Adjust quantities of items currently in the cart.
* **Review:** View the full list of items in the cart with detailed pricing.
* **Checkout/Remove:** Remove items from the cart.

## 💻 Technical Highlights

### 🛡️ Parameterized Queries (PreparedStatement)
Just like modern enterprise applications, this project strictly uses `PreparedStatement` instead of `Statement`.
* **Security:** Prevents SQL Injection attacks by treating user input as parameters rather than executable code.
* **Efficiency:** Optimizes database performance by pre-compiling SQL queries.

### ⚙️ External Configuration (Properties File)
Hardcoding database credentials is a security risk. This project utilizes a `database.properties` file to securely manage:
* Database URL
* Driver Class Name
* Username
* Password

This follows industry best practices for configuration management, making the code cleaner and more secure.

### Code Example: Secure Insert
```java
// From Operations.java
String sql = "insert into product values(?,?,?,?)";
PreparedStatement stmt = con.prepareStatement(sql);

// Binding parameters prevents SQL injection
stmt.setInt(1, id);
stmt.setString(2, name);
stmt.setDouble(3, price);
stmt.setInt(4, quantity);

int count = stmt.executeUpdate();
