package model;

import java.util.List;

public interface EducationDAOInterface {
    Education addEducation(Education education);

    void removeEducationById(int id);

    void addCourseToEducation(int educationId, int courseId);

    void addStudentToEducation(int educationId, int studentId);

    void updateEducationName(int id, String newName);

    List<Education> getEducations();

    List<Course> getEducationCourses(int educationId);

    List<Student> getEducationStudents(int educationId);
}
