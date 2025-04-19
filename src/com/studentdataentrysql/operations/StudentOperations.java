package com.studentdataentrysql.operations;

import com.studentdataentrysql.database.DatabaseConnector;
import com.studentdataentrysql.model.Student;

import java.sql.*;
import java.util.Scanner;

/**
 * This class handles the CRUD operations (Add, Display, Search, Update, Delete)
 * for the Student data. It uses JDBC to interact with the MySQL database.
 */
public class StudentOperations {

    // Database connection established through DatabaseConnector
    Connection conn = DatabaseConnector.getConnection(); // Using DatabaseConnector for DB connection
    // Scanner object to take user inputs
    Scanner sc = new Scanner(System.in);

    /**
     * Constructor that establishes the database connection when an object is created.
     */
    public StudentOperations() throws SQLException {
    }

    /**
     * This method adds a new student to the database by accepting user input.
     */
    public void addStudent() {
        // Taking user input for student details
        System.out.print("Enter PRN: ");
        int prn = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Position: ");
        String position = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        // Insert student details into the database using PreparedStatement
        try {
            PreparedStatement pst = conn.prepareStatement("INSERT INTO students VALUES (?, ?, ?, ?)");
            pst.setInt(1, prn);
            pst.setString(2, name);
            pst.setString(3, position);
            pst.setInt(4, age);
            pst.executeUpdate(); // Execute the insert query
            System.out.println("Student added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    /**
     * This method displays all student records from the database.
     */
    public void displayStudents() {
        try {
            Statement st = conn.createStatement(); // Create a statement
            ResultSet rs = st.executeQuery("SELECT * FROM students"); // Execute the query to get all students

            System.out.println("\n-- Student Records --");
            // Loop through all the records and print them
            while (rs.next()) {
                System.out.println("PRN: " + rs.getInt(1) + ", Name: " + rs.getString(2) + ", Position: " + rs.getString(3) + ", Age: " + rs.getInt(4));
            }
        } catch (SQLException e) {
            System.out.println("Error displaying students: " + e.getMessage());
        }
    }

    /**
     * This method searches for a student by PRN.
     */
    public void searchByPRN() {
        System.out.print("Enter PRN to search: ");
        int prn = sc.nextInt();

        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM students WHERE prn = ?");
            pst.setInt(1, prn); // Set PRN in the query
            ResultSet rs = pst.executeQuery(); // Execute the search query

            if (rs.next()) { // If a record is found
                System.out.println("Found: " + rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getString(3) + ", " + rs.getInt(4));
            } else {
                System.out.println("Student not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error searching by PRN: " + e.getMessage());
        }
    }

    /**
     * This method searches for students by Name.
     */
    public void searchByName() {
        System.out.print("Enter Name to search: ");
        String name = sc.nextLine();

        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM students WHERE name = ?");
            pst.setString(1, name);  // Set name in the query
            ResultSet rs = pst.executeQuery(); // Execute the search query

            while (rs.next()) { // Loop through and print all records with matching name
                System.out.println("Found: " + rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getString(3) + ", " + rs.getInt(4));
            }
        } catch (SQLException e) {
            System.out.println("Error searching by name: " + e.getMessage());
        }
    }

    /**
     * This method searches for students by Position.
     */
    public void searchByPosition() {
        System.out.print("Enter Position to search: ");
        String position = sc.nextLine();

        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM students WHERE position = ?");
            pst.setString(1, position);  // Set position in the query
            ResultSet rs = pst.executeQuery(); // Execute the search query

            while (rs.next()) { // Loop through and print all records with matching position
                System.out.println("Found: " + rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getString(3) + ", " + rs.getInt(4));
            }
        } catch (SQLException e) {
            System.out.println("Error searching by position: " + e.getMessage());
        }
    }

    /**
     * This method updates a student's details by accepting user input.
     */
    public void updateStudent() {
        System.out.print("Enter PRN of student to update: ");
        int prn = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter new Name: ");
        String name = sc.nextLine();
        System.out.print("Enter new Position: ");
        String position = sc.nextLine();
        System.out.print("Enter new Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        try {
            PreparedStatement pst = conn.prepareStatement("UPDATE students SET name = ?, position = ?, age = ? WHERE prn = ?");
            pst.setString(1, name); // Set new name
            pst.setString(2, position); // Set new position
            pst.setInt(3, age);  // Set new age
            pst.setInt(4, prn); // Set PRN for updating the record
            int rows = pst.executeUpdate();  // Execute the update query
            if (rows > 0) {
                System.out.println("Student updated successfully.");
            } else {
                System.out.println("Student not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating student: " + e.getMessage());
        }
    }

    /**
     * This method deletes a student's record by their PRN.
     */
    public void deleteStudent() {
        System.out.print("Enter PRN of student to delete: ");
        int prn = sc.nextInt();

        try {
            PreparedStatement pst = conn.prepareStatement("DELETE FROM students WHERE prn = ?");
            pst.setInt(1, prn); // Set PRN in the delete query
            int rows = pst.executeUpdate(); // Execute the delete query
            if (rows > 0) {
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("Student not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting student: " + e.getMessage());
        }
    }
}
