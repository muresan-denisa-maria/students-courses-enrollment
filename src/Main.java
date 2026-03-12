import model.Courses;
import model.Student;
import repository.CoursesRepository;
import repository.StudentRepository;
import service.EnrollmentService;
import util.FileUtil;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StudentRepository studentRepository = new StudentRepository();
        CoursesRepository courseRepository = new CoursesRepository();
        EnrollmentService enrollmentService = new EnrollmentService(studentRepository, courseRepository);

        int studentIdCounter = 1;
        int courseIdCounter = 1;

        while (true) {
            System.out.println("\n      Menu     ");
            System.out.println("Press 1 to add a student");
            System.out.println("Press 2 to add a course");
            System.out.println("Press 3 to enroll a student in course");
            System.out.println("Press 4 to show all the students");
            System.out.println("Press 5 to search student by name");
            System.out.println("Press 6 to show all courses");
            System.out.println("Press 7 to delete student");
            System.out.println("Press 8 to delete course");
            System.out.println("Press 9 to save data");
            System.out.println("Press 0 for exit");
            System.out.print("Choose an option: ");

            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    System.out.print("Student name: ");
                    String studentName = scanner.nextLine();

                    System.out.print("Student email: ");
                    String studentEmail = scanner.nextLine();

                    System.out.print("Student phone number: ");
                    String phoneNumber = scanner.nextLine();

                    Student student = new Student(studentIdCounter++, studentName, studentEmail, phoneNumber);
                    studentRepository.addStudent(student);
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    System.out.print("Course title: ");
                    String courseTitle = scanner.nextLine();

                    System.out.print("Teacher name: ");
                    String teacher = scanner.nextLine();

                    Courses course = new Courses(courseIdCounter++, courseTitle, teacher);
                    courseRepository.addCourse(course);
                    System.out.println("Course added successfully.");
                    break;

                case 3:
                    System.out.print("Student ID: ");
                    int studentId = Integer.parseInt(scanner.nextLine());

                    System.out.print("Course ID: ");
                    int courseId = Integer.parseInt(scanner.nextLine());

                    boolean enrolled = enrollmentService.enrollStudentInCourse(studentId, courseId);

                    if (enrolled) {
                        System.out.println("Student enrolled successfully.");
                    } else {
                        System.out.println("Student or course not found.");
                    }
                    break;

                case 4:
                    List<Student> students = studentRepository.getAllStudents();

                    if (students.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        for (int i = 0; i < students.size(); i++) {
                            System.out.println(students.get(i));
                            System.out.println("END \n");
                        }
                    }
                    break;

                case 5:
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();

                    List<Student> foundStudents = studentRepository.findByName(searchName);

                    if (foundStudents.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        for (int i = 0; i < foundStudents.size(); i++) {
                            System.out.println(foundStudents.get(i));
                            System.out.println("END \n");
                        }
                    }
                    break;

                case 6:
                    List<Courses> courses = courseRepository.getAllCourses();

                    if (courses.isEmpty()) {
                        System.out.println("No courses found.");
                    } else {
                        for (int i = 0; i < courses.size(); i++) {
                            System.out.println(courses.get(i));
                            System.out.println("END \n");
                        }
                    }
                    break;
                case 7:
                    System.out.print("Enter student ID to delete: ");
                    int deleteStudentId = Integer.parseInt(scanner.nextLine());

                    boolean studentDeleted = studentRepository.deleteStudentById(deleteStudentId);

                    if (studentDeleted) {
                        enrollmentService.removeStudentEnrollments(deleteStudentId);
                        System.out.println("Student deleted successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 8:
                    System.out.print("Enter course ID to delete: ");
                    int deleteCourseId = Integer.parseInt(scanner.nextLine());

                    boolean courseDeleted = courseRepository.deleteCourseById(deleteCourseId);

                    if (courseDeleted) {
                        enrollmentService.removeCourseFromEnrollments(deleteCourseId);
                        System.out.println("Course deleted successfully.");
                    } else {
                        System.out.println("Course not found.");
                    }
                    break;
                case 9:
                    FileUtil.saveStudents(studentRepository.getAllStudents(), "students.txt");
                    FileUtil.saveCourses(courseRepository.getAllCourses(), "courses.txt");
                    FileUtil.saveEnrollments(enrollmentService.getAllEnrollments(), "enrollments.txt");
                    break;
                case 0:
                    System.out.println("Application closed.");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}