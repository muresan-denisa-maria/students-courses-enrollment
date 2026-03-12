package util;

import model.Student;
import model.Courses;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class FileUtil {

    public static void saveStudents(List<Student> students, String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);

            for (int i = 0; i < students.size(); i++) {
                Student student = students.get(i);
                writer.write(student.getId() + "," +
                        student.getName() + "," +
                        student.getEmail() + "," +
                        student.getPhoneNumber() + "\n");
            }

            writer.close();
            System.out.println("Students saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving students.");
        }
    }

    public static void saveCourses(List<Courses> courses, String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);

            for (int i = 0; i < courses.size(); i++) {
                Courses course = courses.get(i);
                writer.write(course.getId() + "," +
                        course.getTitle() + "," +
                        course.getTeacher() + "\n");
            }

            writer.close();
            System.out.println("Courses saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving courses.");
        }
    }

    public static void saveEnrollments(Map<Integer, List<Integer>> enrollments, String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);

            for (Map.Entry<Integer, List<Integer>> entry : enrollments.entrySet()) {
                writer.write("Student ID: " + entry.getKey() +
                        " Courses: " + entry.getValue() + "\n");
            }

            writer.close();
            System.out.println("Enrollments saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving enrollments.");
        }
    }
}