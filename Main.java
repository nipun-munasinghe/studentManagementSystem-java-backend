import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        Scanner scanner = new Scanner(System.in);

        boolean run = true;

        System.out.println("Welcome to the Student Management System!");

        while(run) {
            System.out.print("\nMenu:\n" +
                    "1. Add a student\n" +
                    "2. View student\n" +
                    "3. Enroll student into a Course\n" +
                    "4. Assign a grade\n" +
                    "5. Remove a student\n" +
                    "6.Exit\n" +
                    "Enter your choice: ");
            int choice = scanner.nextInt();

            switch(choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    studentManager.addStudent(id, name);
                    break;

                case 2:
                    studentManager.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter student ID to enroll in a course: ");
                    int enrollID = scanner.nextInt();
                    scanner.nextLine();
                    Student student = studentManager.findStudentByID(enrollID);
                    if (student != null) {
                        System.out.print("Enter course name: ");
                        String course = scanner.nextLine();
                        student.enrollCourse(course);
                        System.out.print("Course enrolled successfully.\n");
                    }
                    else {
                        System.out.println("Student not found:(");
                    }
                    break;

                case 4:
                    System.out.print("Enter Student ID to assign a grade: ");
                    int gradeId = scanner.nextInt();
                    scanner.nextLine();
                    student = studentManager.findStudentByID(gradeId);
                    if (student != null) {
                        System.out.print("Enter Course Name: ");
                        String gradeCourse = scanner.nextLine();
                        System.out.print("Enter Grade: ");
                        float grade = scanner.nextFloat();
                        student.assignGrade(gradeCourse, grade);
                        System.out.println("Grade assigned successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter Student ID to remove: ");
                    int removeId = scanner.nextInt();
                    studentManager.deleteStudent(removeId);
                    break;

                case 6:
                    run = false;
                    System.out.println("Exiting the system, Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
    }
}
