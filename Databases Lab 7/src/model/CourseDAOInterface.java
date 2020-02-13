package model;

import java.util.List;

public interface CourseDAOInterface {
    Course addCourse(Course course);

    void removeCourseById(int id);

    void addTeacherToCourse(int courseId, int teacherId);

    void updateCourseName(int id, String newName);

    List<Course> getCourses();

    List<Teacher> getCourseTeachers(int courseId);

    List<Education> getCourseEducations(int courseId);
}
