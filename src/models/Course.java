package models;

public class Course { //an object to hold information about a course
    private String courseCode;
    private String courseName;
    private int credits;

    public Course(String code, String name, int cred){
        if(code != null) {courseCode = code;} else{courseCode = "InvalidCode";}
        if(name != null) {courseName = name;} else{courseName = "InvalidName";}
        if(cred > 0) {credits = cred;} else {credits = 0;}
    }

    public String getCourseCode() {
        return courseCode;
    }
    public String getCourseName() {
        return courseName;
    }
    public int getCredits() {
        return credits;
    }

    @Override
    public String toString() {
        return courseCode + " --- " + courseName
                + "   - " + credits + " credit hours";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course c = (Course) o;
        return courseCode.equals(c.courseCode);
    }

    @Override
    public int hashCode() {
        return courseCode.hashCode();
    }
}