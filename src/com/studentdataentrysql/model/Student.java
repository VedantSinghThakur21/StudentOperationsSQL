package com.studentdataentrysql.model;


/**
 * This class represents a Student with attributes such as PRN, Name, Position, and Age.
 * It contains constructors, getters, and setters for the respective fields.
 */
public class Student {

    // Instance variables representing student details
    private int prn; // PRN (Personal Registration Number) of the student
    private String name;  // Name of the student
    private String position; // Position/Designation of the student
    private int age; // Age of the student

    /**
     * Constructor to initialize a Student object with given PRN, Name, Position, and Age.
     *
     * @param prn The PRN of the student
     * @param name The name of the student
     * @param position The position of the student
     * @param age The age of the student
     */
    public Student(int prn, String name, String position, int age) {
        this.prn = prn;  // Initializing PRN
        this.name = name;  // Initializing Name
        this.position = position;  // Initializing Position
        this.age = age;  // Initializing Age
    }

    /**
     * Getter method to retrieve the PRN of the student.
     *
     * @return The PRN of the student
     */
    public int getPrn() {
        return prn;
    }

    /**
     * Setter method to set the PRN of the student.
     *
     * @param prn The PRN to set
     */
    public void setPrn(int prn) {
        this.prn = prn;
    }

    /**
     * Getter method to retrieve the name of the student.
     *
     * @return The name of the student
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method to set the name of the student.
     *
     * @param name The name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method to retrieve the position of the student.
     *
     * @return The position of the student
     */
    public String getPosition() {
        return position;
    }

    /**
     * Setter method to set the position of the student.
     *
     * @param position The position to set
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Getter method to retrieve the age of the student.
     *
     * @return The age of the student
     */
    public int getAge() {
        return age;
    }

    /**
     * Setter method to set the age of the student.
     *
     * @param age The age to set
     */
    public void setAge(int age) {
        this.age = age;
    }
}