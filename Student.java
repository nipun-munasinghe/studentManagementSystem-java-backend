import java.util.ArrayList;

public class Student {

    private int studentID;
    private String name;
    private ArrayList<String> courses;
    private ArrayList<Float> grades;

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.courses = new ArrayList<>();
        this.grades = new ArrayList<>();
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getCourses() {
        return courses;
    }

    public ArrayList<Float> getGrades() {
        return grades;
    }

    public void enrollCourse(String course) {
        courses.add(course);
        grades.add(null);
    }

    public void assignGrade(String course, float grade) {
        int index = courses.indexOf(course);
        if (index != -1) {
            grades.set(index, grade);
        }
    }

    @Override
    public String toString() {
        StringBuilder studentInfo = new StringBuilder("ID: " + studentID + ", Name: " + name + "\nCourses and Grades:\n");
        for (int i = 0; i < courses.size(); i++) {
            studentInfo.append(courses.get(i)).append(" - ").append(grades.get(i) == null ? "N/A" : grades.get(i)).append("\n");
        }
        return studentInfo.toString();
    }
}
