import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public void addStudent(int id, String name) {
        students.add(new Student(id, name));
        System.out.println("Student added successfully!");
    }

    public void viewStudents() {
        if(students.isEmpty()) {
            System.out.println("No students available.");
        }
        else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public Student findStudentByID(int id) {
        for (Student student : students) {
            if (student.getStudentID() == id) {
                return student;
            }
        }
        return null;
    }

    public void deleteStudent(int id) {
        Student student = findStudentByID(id);
        if (student != null) {
            students.remove(student);
            System.out.println("Student removed successfully.");
        }
        else {
            System.out.println("Student not found:(");
        }
    }
}
