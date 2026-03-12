package service;

import model.Student;
import model.Courses;
import repository.StudentRepository;
import repository.CoursesRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnrollmentService {
    private final StudentRepository studentRepository;
    private final CoursesRepository courseRepository;
    private final Map<Integer, List<Integer>> enrollments = new HashMap<>();

    public EnrollmentService(StudentRepository studentRepository, CoursesRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public boolean enrollStudentInCourse(int studentId, int courseId) {
        Student student = studentRepository.findById(studentId);
        Courses course = courseRepository.findById(courseId);

        if (student == null || course == null) {
            return false;
        }

        if (!enrollments.containsKey(studentId)) {
            enrollments.put(studentId, new ArrayList<>());
        }

        List<Integer> studentCourses = enrollments.get(studentId);

        if (!studentCourses.contains(courseId)) {
            studentCourses.add(courseId);
        }

        return true;
    }

    public List<Integer> getCoursesForStudent(int studentId) {
        if (enrollments.containsKey(studentId)) {
            return enrollments.get(studentId);
        }
        return new ArrayList<>();
    }

    public Map<Integer, List<Integer>> getAllEnrollments() {
        return enrollments;
    }
    public void removeStudentEnrollments(int studentId) {
        enrollments.remove(studentId);
    }

    public void removeCourseFromEnrollments(int courseId) {
        for (Map.Entry<Integer, List<Integer>> entry : enrollments.entrySet()) {
            List<Integer> studentCourses = entry.getValue();

            for (int i = 0; i < studentCourses.size(); i++) {
                if (studentCourses.get(i) == courseId) {
                    studentCourses.remove(i);
                    i--;
                }
            }
        }
    }
}