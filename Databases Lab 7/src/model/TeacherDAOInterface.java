package model;

import java.util.List;

public interface TeacherDAOInterface {
    Teacher addTeacher(Teacher teacher);

    void removeTeacherById(int id);

    void updateTeacherName(int id, String newName);

    List<Teacher> getTeachers();

    List<Course> getTeacherCourses(int teacherId);
}
