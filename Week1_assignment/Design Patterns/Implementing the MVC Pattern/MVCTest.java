public class MVCTest {
    public static void main(String[] args) {
        // Create a Student model
        Student student = new Student("John Doe", "12345", "A");

        // Create a StudentView
        StudentView studentView = new StudentView();

        // Create a StudentController
        StudentController studentController = new StudentController(student, studentView);

        // Display initial student details
        studentController.updateView();

        // Update student details
        studentController.setStudentName("Jane Smith");
        studentController.setStudentId("67890");
        studentController.setStudentGrade("B");

        // Display updated student details
        studentController.updateView();
    }
}
