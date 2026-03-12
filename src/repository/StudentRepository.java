package repository;

import model.Student;
import java.util.ArrayList;
import java.util.List;
public class StudentRepository {
private final List<Student> students = new ArrayList<>();

public void addStudent(Student student){
    students.add(student); // adaug student
}

public List<Student> getAllStudents(){
    return students; //returnez student
}

    public Student findById(int id) {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);

            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public List<Student> findByName(String name) {
        List<Student> foundStudents = new ArrayList<>();

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);

            String studentName = student.getName().toLowerCase();
            String searchedName = name.toLowerCase();

            if (studentName.contains(searchedName)) {
                foundStudents.add(student);
            }
        }

        return foundStudents;
    }
    public boolean deleteStudentById(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }
}
