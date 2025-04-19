package com.studentdataentrysql.operations;

import com.studentdataentrysql.database.DatabaseConnector;
import com.studentdataentrysql.model.Student;

import java.sql.*;
import java.util.Scanner;

public class StudentOperations {
    Connection conn = DatabaseConnector.getConnection(); // Using DatabaseConnector for DB connection
    Scanner sc = new Scanner(System.in);

    public StudentOperations() throws SQLException {
    }

    public void addStudent() {
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

        try {
            PreparedStatement pst = conn.prepareStatement("INSERT INTO students VALUES (?, ?, ?, ?)");
            pst.setInt(1, prn);
            pst.setString(2, name);
            pst.setString(3, position);
            pst.setInt(4, age);
            pst.executeUpdate();
            System.out.println("Student added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    public void displayStudents() {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students");

            System.out.println("\n-- Student Records --");
            while (rs.next()) {
                System.out.println("PRN: " + rs.getInt(1) + ", Name: " + rs.getString(2) + ", Position: " + rs.getString(3) + ", Age: " + rs.getInt(4));
            }
        } catch (SQLException e) {
            System.out.println("Error displaying students: " + e.getMessage());
        }
    }

    public void searchByPRN() {
        System.out.print("Enter PRN to search: ");
        int prn = sc.nextInt();

        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM students WHERE prn = ?");
            pst.setInt(1, prn);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                System.out.println("Found: " + rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getString(3) + ", " + rs.getInt(4));
            } else {
                System.out.println("Student not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error searching by PRN: " + e.getMessage());
        }
    }

    public void searchByName() {
        System.out.print("Enter Name to search: ");
        String name = sc.nextLine();

        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM students WHERE name = ?");
            pst.setString(1, name);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                System.out.println("Found: " + rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getString(3) + ", " + rs.getInt(4));
            }
        } catch (SQLException e) {
            System.out.println("Error searching by name: " + e.getMessage());
        }
    }

    public void searchByPosition() {
        System.out.print("Enter Position to search: ");
        String position = sc.nextLine();

        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM students WHERE position = ?");
            pst.setString(1, position);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                System.out.println("Found: " + rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getString(3) + ", " + rs.getInt(4));
            }
        } catch (SQLException e) {
            System.out.println("Error searching by position: " + e.getMessage());
        }
    }

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
            pst.setString(1, name);
            pst.setString(2, position);
            pst.setInt(3, age);
            pst.setInt(4, prn);
            int rows = pst.executeUpdate();
            if (rows > 0) {
                System.out.println("Student updated successfully.");
            } else {
                System.out.println("Student not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating student: " + e.getMessage());
        }
    }

    public void deleteStudent() {
        System.out.print("Enter PRN of student to delete: ");
        int prn = sc.nextInt();

        try {
            PreparedStatement pst = conn.prepareStatement("DELETE FROM students WHERE prn = ?");
            pst.setInt(1, prn);
            int rows = pst.executeUpdate();
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
