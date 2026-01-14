package app;

import java.util.ArrayList;
import java.util.Scanner;
import models.*;
import services.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StudentServices studentServices = new StudentServices();

    public static void main() {

        while(true) {
            System.out.println("Welcome to Course " +
                    "Management System\n1. Add a New Student\n" +
                    "2. Enroll a Student\n3. Assign Grades\n" +
                    "4. View Student Transcript\n5. List all students" +
                    "\n6. List all courses\n7. Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice) {
                case (1): { //Add a new student
                    System.out.println("Enter Student Name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter Student id:");
                    String code = sc.nextLine();
                    studentServices.addStudent(code, name);
                    System.out.println("Student Added Successfully!");
                    break;
                }
                case (2): { //Enroll a student in classes
                    System.out.println("Enter Student id:");
                    String code = sc.nextLine();
                    if(studentServices.findStudentById(code) != null) {
                        System.out.println("Enter Course Code:");
                        String courseCode = sc.nextLine();
                        Course course = studentServices.findCourseByCode(courseCode);
                        if(course != null) {
                            studentServices.enrollStudent(code, course);
                            System.out.println("Student Enrolled Successfully!");
                            break;
                        }
                        System.out.println("Course not found");
                        break;
                    }
                    System.out.println("Student not found");
                    break;
                }
                case (3): { //Assign Grades
                    System.out.println("Enter Student id:");
                    String studentID = sc.nextLine();
                    Student student = studentServices.findStudentById(studentID);
                    if(student != null) {
                        System.out.println("Enter Course Code:");
                        String courseCode = sc.nextLine();
                        ArrayList<Enrollment> transcript = new ArrayList<>(student.getEnrollments());
                        for (Enrollment enrollment : transcript) {
                            if (enrollment != null && enrollment.getCourse().getCourseCode().equals(courseCode)) {
                                System.out.println("Enter Grade:");
                                float grade = sc.nextFloat();
                                sc.nextLine();
                                if (grade >= 0 && grade <= 4) {
                                    studentServices.assignGrade(studentID, courseCode, grade);
                                    System.out.println("Grade Assigned Successfully!");
                                    break;
                                }
                                System.out.println("Invalid grade");
                                break;
                            }
                        }
                        System.out.println("Student is not enrolled in this course");
                        break;
                    }
                    System.out.println("Student not found");
                    break;
                }
                case (4): { //View Transcript
                    System.out.println("Enter Student id:");
                    String studentID = sc.nextLine();
                    Student student = studentServices.findStudentById(studentID);
                    if(student != null) {
                        for(Enrollment enrollment: student.getEnrollments()){
                            if(enrollment != null){
                                System.out.println(enrollment);
                            }
                        }
                        if(Float.isNaN(student.getGPA())) {
                            System.out.println("No Grade yet.");
                            break;
                        }
                        System.out.println("Total GPA: " + student.getGPA());
                        break;
                    }
                    System.out.println("Student not found");
                    break;
                }
                case (5): { //List all Students
                    studentServices.listStudents();
                    break;
                }
                case (6): { //List all Courses
                    studentServices.listCourses();
                    break;
                }
                case (7): { //Exit the program
                    sc.close();
                    return;
                }
                default:{
                    System.out.println("Command not recognized");
                }
            }
        }
    }
}