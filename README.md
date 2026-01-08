# Assignments-for-JDBC-
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
* [cite_start]**Output:** Confirms "Database connection successful" upon success.

### 2. Fetch Data (Read)
* **File:** `Student.java`
* **Function:** Retrieves all records from the `student` table.
* [cite_start]**Output:** Displays data (ID, Name, Age) in a formatted tabular view in the console.

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
* [cite_start]**Logic:** Binds the ID to the delete command and executes the update.
