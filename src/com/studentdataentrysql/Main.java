// Name : Vedant Singh Thakur
// PRN : 23070126144
// Batch : AIML B3

package com.studentdataentrysql;

import com.studentdataentrysql.operations.StudentOperations;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * This is the main class for the Student Data Entry System.
 * It provides a menu for the user to interact with the system and perform various operations.
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in); // Scanner to take user input
        StudentOperations ops = new StudentOperations(); // Object to perform operations 
        int choice; // Variable to store user's menu choice

        // Infinite loop to keep showing the menu until user chooses to exit (choice 8)
        do {
            // Displaying the menu options
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
            choice = scanner.nextInt(); // Taking input for menu choice
            scanner.nextLine(); // consume newline

            // Switch case to execute the corresponding operation based on user's choice
            switch (choice) {
                case 1 -> ops.addStudent(); // Call method to add student
                case 2 -> ops.displayStudents(); // Call method to display all students
                case 3 -> ops.searchByPRN(); // Call method to search student by PRN
                case 4 -> ops.searchByName(); // Call method to search student by Name
                case 5 -> ops.searchByPosition(); // Call method to search student by Position
                case 6 -> ops.updateStudent(); // Call method to update student
                case 7 -> ops.deleteStudent(); // Call method to delete student
                case 8 -> System.out.println("Exiting... Goodbye!"); // Exit message
                default -> System.out.println("Invalid choice. Try again."); // Invalid choice handling
            }
        } while (choice != 8); // Continue the loop until user chooses to exit
    }
}