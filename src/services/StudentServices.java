package services;

import models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StudentServices { //This class handles all the heavy lifting
    private final Map<String, Student> students = new HashMap<>();
    private final Map<String, Course> courseCatalog = new HashMap<>();

    public StudentServices() {  //populate some Courses to use
        for (int i = 0; i < 3; i++) {
            courseCatalog.put(("MTH" + (i * 10 + 101)),
                    new Course("MTH" + (i * 10 + 101),
                            "Math " + (i * 10 + 101), 3));
            courseCatalog.put(("LIT" + (i * 10 + 101)),
                    new Course("LIT" + (i * 10 + 101),
                            "Literature "  + (i * 10 + 101), 3));
            courseCatalog.put(("SCI" + (i * 10 + 101)),
                    new Course("SCI" + (i * 10 + 101),
                            "Science " + (i * 10 + 101), 3));
        }
    }

    public void listCourses(){
        System.out.println("Courses:");
        for (Course c : courseCatalog.values()){
            System.out.println(c);
        }
    }

    public void addStudent(String code, String name){
        Student Stud = new Student(name, code);
        if (!students.containsKey(Stud.getID())){students.put(Stud.getID(),Stud);}
    }

    public Course findCourseByCode(String code){
        return courseCatalog.get(code);
    }

    public Student findStudentById(String id){
        return students.get(id);
    }

    public void listStudents(){
        if(!students.isEmpty()) {
            System.out.println("Student list:\n");
            students.forEach((k,v)-> System.out.println(k + ": " + v));
        }else {
            System.out.println("Student list is empty.");
        }
    }

    public void enrollStudent(String studentId, Course course){
        Student student = findStudentById(studentId);
        if(student != null){
            student.enroll(course);
        }
    }

    public void assignGrade(String studentID, String courseCode, float grade){
        Student student = findStudentById(studentID);
        if(student == null){System.out.println("Student not found."); return;}
        ArrayList<Enrollment> enrollments = student.getEnrollments();
        boolean found = false;
        int index = -1;
        for(int i = 0; i < enrollments.size(); i++){
            if(enrollments.get(i).getCourse().getCourseCode().equals(courseCode)){found = true; index = i;}
        }
        if(!found){System.out.println("Course not found."); return;}
        if(grade >= 0.0 && grade <= 4.0) {
            enrollments.get(index).setGrade(grade);
            return;
        }
        System.out.println("Invalid grade.");
    }
}