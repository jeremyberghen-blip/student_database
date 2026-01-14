package models;

import java.util.ArrayList;

public class Student extends Person{
    private final ArrayList<Enrollment> enrollments = new ArrayList<Enrollment>();

    public boolean enroll(Course c) {
        if(c != null){
            if(!enrollments.isEmpty()){
                for(Enrollment e: enrollments){
                    if(e.getCourse().equals(c)){
                        return false;
                    }
                }
            }
            enrollments.add(new Enrollment(c, -1));
            return true;
        }
        return false;
    }

    public boolean addGrade(Course c, float grade){
        if(c != null && grade >= 0 && grade <= 4){
            for(int i = 0; i < enrollments.size(); i++){
                if(enrollments.get(i).getCourse().equals(c)){
                    enrollments.get(i).setGrade(grade);
                    return true;
                }
            }
        }
        return false;
    }

    public Student(String name, String studentId){
        super(name, studentId);
    }

    public float getGPA(){
        float total = 0;
        int numberOfEnrollments = 0;
        for(Enrollment e: enrollments) {
            if(e != null && e.getGrade() >= 0){
                total += e.getGrade();
                numberOfEnrollments++;
            }
        }
        if(numberOfEnrollments != 0){
            return total/numberOfEnrollments;
        }
        return Float.NaN;
    }

    public ArrayList<Enrollment> getEnrollments(){
        return new ArrayList<>(enrollments);
    }

    @Override
    public String toString(){
        return name + " - " + personalId + " - " + (Float.isNaN(getGPA()) ? "Not graded yet." : getGPA());
    }

}