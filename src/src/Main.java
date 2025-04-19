package StudentOperations.src;// Name: Vedant Singh Thakur
// PRN: 23070126144
// Batch: B3


// Importing Java utility package for Scanner and other utilities
import java.util.*;

public class Main {
    public static void main(String[] args) {

                //Scanner Object for taking UserInput
                Scanner sc = new Scanner(System.in);
                //Creating Instance of StudentManager
                StudentManager manager = new StudentManager();

                //Variable to store user choice
                int choice;

                //Menu Driven Program using Do-While Loop
                do {
                    //Displaying all the options in Menu
                    System.out.println("\n===== Student Management System =====");
                    System.out.println("1. Add Student");
                    System.out.println("2. Display All Students");
                    System.out.println("3. Search by PRN");
                    System.out.println("4. Search by Name");
                    System.out.println("5. Search by Position");
                    System.out.println("6. Update Student");
                    System.out.println("7. Delete Student");
                    System.out.println("0️. Exit");
                    System.out.print("Enter your choice: ");

                    //Reading user Input of choice
                    choice = sc.nextInt();

                    //Switch cases to handle diff menu options
                    switch (choice) {
                        case 1:
                            //Calling method to add Student
                            manager.addStudent(sc);
                            break;
                        case 2:
                            //Calling method to display all student in list
                            manager.displayStudents();
                            break;
                        case 3:
                            //Calling method to Search student by PRN
                            manager.searchByPRN(sc);
                            break;
                        case 4:

                            //Calling method to Search student by Name
                            manager.searchByName(sc);
                            break;
                        case 5:

                            //Calling Method to Search student by Position in List
                            manager.searchByPosition(sc);
                            break;
                        case 6:

                            //Calling method to Update Student Details such as Name,Dob, etc.
                            manager.updateStudent(sc);
                            break;
                        case 7:

                            //Calling method to delete details of a particular Student
                            manager.deleteStudent(sc);
                            break;
                        case 0:

                            //Exit Message
                            System.out.println(" Exiting...");
                            break;
                        default:
                            //Default case to handle Invalid Choice
                            System.out.println("Invalid choice! Try again.");
                    }
                }
                //Never Ending Loop until user Selects 0 to exit out of the Loop
                while (choice != 0);

                //Closing Scanner Obj
                sc.close();
            }
        }
