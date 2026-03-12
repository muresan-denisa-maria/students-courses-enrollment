package repository;
import model.Courses;
import java.util.ArrayList;
import java.util.List;

public class CoursesRepository {
    private final List<Courses> courses = new ArrayList<>();

    public void addCourse(Courses course) {
        courses.add(course);
    }

    public List<Courses> getAllCourses() {
        return courses;
    }

    public Courses findById(int id) {
        for (int i = 0; i < courses.size(); i++) {
            Courses course = courses.get(i);

            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }
    public boolean deleteCourseById(int id) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId() == id) {
                courses.remove(i);
                return true;
            }
        }
        return false;
    }
}
