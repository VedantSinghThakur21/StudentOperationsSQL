package StudentOperations.src;// Importing Java utility classes for ArrayList and Scanner
import java.util.*;

public class StudentManager {
    // List to store student objects
    private ArrayList<Student> studentList;

    // Constructor to initialize the student list
    public StudentManager() {
        studentList = new ArrayList<>();
    }

    // Method to add a new student to the list
    public void addStudent(Scanner sc) {

        sc.nextLine();

        System.out.print("Enter PRN: ");
        //Read PRN
        String prn = sc.nextLine();
        System.out.print("Enter Name: ");
        //Read Name
        String name = sc.nextLine();
        System.out.print("Enter Date of Birth(DD/MM/YYYY): ");
        //Read Date of Birth
        String dob = sc.nextLine();
        System.out.print("Enter Marks: ");
        //Read Marks
        double marks = sc.nextDouble();

        // Add student object to the list
        studentList.add(new Student(prn, name, dob, marks));
        System.out.print("Student Added Successfully!\n");

    }

    // Method to display all students in the list
    public void displayStudents() {

        //Checking if List is empty
        if (studentList.isEmpty()) {
            System.out.println("Nothing to show!");
            return;
        }
        //Iterating through list
        for (Student s : studentList) {
            System.out.println(s);

            //Call Display Method to display all details of student
            s.displayStudent();
        }
    }

    // Method to search for a student by PRN
    public void searchByPRN(Scanner sc) {
        System.out.print("Enter PRN to search: ");
        //Read PRN input
        String prn = sc.next();
        //Iterate through list
        for (Student s : studentList) {
            //Matching PRN
            if (s.getPrn().equals(prn)) {
                System.out.println("Student Found:");
                //Displaying Student Details
                s.displayStudent();
                return;
            }
        }
        System.out.println("Student not found!");
    }

    // Method to search for a student by Name
    public void searchByName(Scanner sc) {
        System.out.print("Enter Name to search: ");
        //Read Name Input
        String name = sc.next();

        //Iterating through list
        for (Student s : studentList) {
            //Matching Student Name
            if (s.getName().equalsIgnoreCase(name)) {
                System.out.println("Student Found:");
                s.displayStudent();
                return;
            }
        }
        System.out.println("Student not found!");
    }

    // Method to search for a student by position in the list
    public void searchByPosition(Scanner sc) {
        System.out.print("Enter Position (Index starts from 0): ");
        //Read Position
        int pos = sc.nextInt();

        //Checking if position is Valid
        if (pos >= 0 && pos < studentList.size()) {
            System.out.println(" Student at Position " + pos + ":");
            //Displaying Student at given Index
            studentList.get(pos).displayStudent();
        } else {
            System.out.println(" Invalid position!");
        }
    }

    // Method to update student details using PRN
    public void updateStudent(Scanner sc) {
        System.out.print("Enter PRN to update details: ");
        //Reading PRN Input
        String prn = sc.next();

        //Iterating through List
        for (Student s : studentList) {
            //Checking if Matching the PRN available in Db
            if (s.getPrn().equals(prn)) {
                System.out.print("Enter new Name: ");
                //Update Name
                s.setName(sc.next());
                System.out.print("Enter new Date of Birth: ");
                //Update DOB
                s.setDob(sc.next());
                System.out.print("Enter new Marks: ");
                //Update Marks
                s.setMarks(sc.nextDouble());

                System.out.println("Student details updated!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    // Method to delete a student from the list using PRN
    public void deleteStudent(Scanner sc) {
        System.out.print("Enter PRN to delete: ");
        //Reading PRN Input
        String prn = sc.next();

        //Iterating through the list
        for (int i = 0; i < studentList.size(); i++) {
            //matching PRN
            if (studentList.get(i).getPrn().equals(prn)) {
                //Removing student from the list
                studentList.remove(i);
                System.out.println("Student deleted!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

}
