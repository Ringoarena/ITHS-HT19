package model;

import java.util.List;

public interface StudentDAOInterface {
    Student addStudent(Student student);

    void removeStudentById(int id);

    void updateStudentName(int id, String newName);

    List<Student> getStudents();

    List<Education> getStudentEducation(int studentId);
}
