# Student Data Entry System

## Project Overview

The **Student Data Entry System** is a Java-based application that allows users to manage student records in a MySQL database. This system supports various functionalities including adding, displaying, searching, updating, and deleting student records. The application uses JDBC (Java Database Connectivity) to interact with a MySQL database.

## Features

- **Add Student**: Allows the user to add a new student to the database by entering their PRN, name, position, and age.
- **Display All Students**: Displays all student records stored in the database.
- **Search Student by PRN**: Allows the user to search for a student by their PRN (Personal Registration Number).
- **Search Student by Name**: Allows the user to search for students by their name.
- **Search Student by Position**: Allows the user to search for students by their position.
- **Update Student**: Allows the user to update student details (name, position, age) based on their PRN.
- **Delete Student**: Allows the user to delete a student record by PRN.

## Technologies Used

- **Java**: The programming language used to implement the application.
- **MySQL**: The relational database used to store student records.
- **JDBC (Java Database Connectivity)**: A Java API used for connecting and executing SQL queries with the MySQL database.

## Setup Instructions

Follow the steps below to set up the project locally:

### Prerequisites

- **Java 8 or higher**: Ensure that Java is installed on your system. You can check by running `java -version` in your terminal.
- **MySQL**: Install MySQL server and create a database named `studentdb`. You can download MySQL from [here](https://dev.mysql.com/downloads/).
- **JDBC Driver**: The JDBC driver for MySQL is required to connect Java with MySQL. You can add the `mysql-connector-java` library to your project.

### Database Setup

1. Create a database `studentdb` in MySQL.
2. Create a `students` table with the following SQL command:

    ```sql
    CREATE TABLE students (
        prn INT PRIMARY KEY,
        name VARCHAR(100),
        position VARCHAR(100),
        age INT
    );
    ```

### Clone the Repository

Clone this repository to your local machine using the following command:

```bash
git clone https://github.com/your-username/student-data-entry-system.git
```

### Configure Database Connection

1. Open the DatabaseConnector.java file located in the com.studentdataentrysql.database package.

2. Modify the following fields to match your MySQL configuration:

```
private static final String URL = "jdbc:mysql://localhost:3306/studentdb";
private static final String USER = "root";
private static final String PASSWORD = "your_password";
```

### Compile and Run
1. Compile the Java files using the command:

```
javac -d bin src/com/studentdataentrysql/*.java
```
2. Run the Main class to start the application:

```
java -cp bin com.studentdataentrysql.Main
```

### Example Interaction
Here’s an example of how the system interacts with the user:
```
===== Student Data Entry System =====
1. Add Student
2. Display All Students
3. Search Student by PRN
4. Search Student by Name
5. Search Student by Position
6. Update Student
7. Delete Student
8. Exit
Enter your choice: 1
Enter PRN: 12345
Enter Name: John Doe
Enter Position: Manager
Enter Age: 22
Student added successfully.
```

### Contributing
Fork this repository.

Create a feature branch (git checkout -b feature-name).

Commit your changes (git commit -m 'Add new feature').

Push to the branch (git push origin feature-name).

Open a pull request.

### License
This project is licensed under the MIT License - see the LICENSE file for details.

### Acknowledgments
MySQL for providing the database platform.

JDBC for enabling Java to communicate with the MySQL database.

Inspiration from various JDBC tutorials and resources.
