package com.studentdataentrysql;

import com.studentdataentrysql.operations.StudentOperations;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        StudentOperations ops = new StudentOperations(); // Object to perform operations 
        int choice;

        do {
            System.out.println("\n===== Student Data Entry System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by PRN");
            System.out.println("4. Search Student by Name");
            System.out.println("5. Search Student by Position");
            System.out.println("6. Update Student");
            System.out.println("7. Delete Student");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> ops.addStudent();
                case 2 -> ops.displayStudents();
                case 3 -> ops.searchByPRN();
                case 4 -> ops.searchByName();
                case 5 -> ops.searchByPosition();
                case 6 -> ops.updateStudent();
                case 7 -> ops.deleteStudent();
                case 8 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 8);
    }
}