package models;

public class Enrollment {
    private Course course;  //This class primarily is to be an object that can pair
    private float grade;          //a Course with a Grade, and be owned by a student

    public Enrollment(Course course, float grade) {
        if(course != null) {this.course = course;}
        if(grade >= 0 && grade <= 4) {this.grade = grade;} else {
            this.grade = Float.NaN;
        }
    }

    public Enrollment(Enrollment e){
        this.grade = e.getGrade();
        this.course = e.getCourse();
    }

    public Course getCourse() {
        return course;
    }

    public float getGrade() {
        return grade;

    }

    public boolean setGrade(float grade) {
        if(grade >= 0 && grade <= 4){
            this.grade = grade;
            return true;
        }
        return false;
    }

    @Override
    public String toString() { //simplifies printing a students classes and grades
        return "Course: " + course.getCourseName() + ", Grade: " +
                ((grade >= 0 && grade <= 4) ? grade : "Ungraded");
    }
}
