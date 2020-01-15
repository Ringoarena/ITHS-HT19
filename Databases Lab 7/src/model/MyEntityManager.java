package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MyEntityManager {
    EducationDAO educationDAO;
    CourseDAO courseDAO;
    TeacherDAO teacherDAO;
    StudentDAO studentDAO;
    List<Education> educations;
    List<Course> courses;
    List<Teacher> teachers;
    List<Student> students;

    public MyEntityManager() {
        educationDAO = new EducationDAO();
        courseDAO = new CourseDAO();
        teacherDAO = new TeacherDAO();
        studentDAO = new StudentDAO();
        educations = new ArrayList<>();
        courses = new ArrayList<>();
        teachers = new ArrayList<>();
        students = new ArrayList<>();
    }

    public void createEducation(String name, LocalDate startDate, LocalDate endDate) {
        Education education = new Education();
        education.setName(name);
        education.setStartDate(startDate);
        education.setEndDate(endDate);
        educations.add(educationDAO.addEducation(education));
    }

    public void createCourse(String name, LocalDate startDate, LocalDate endDate) {
        Course course = new Course();
        course.setName(name);
        course.setStartDate(startDate);
        course.setEndDate(endDate);
        courses.add(courseDAO.addCourse(course));
    }

    public void createTeacher(String name, LocalDate birthDate) {
        Teacher teacher = new Teacher();
        teacher.setName(name);
        teacher.setBirthDate(birthDate);
        teachers.add(teacherDAO.addTeacher(teacher));
    }

    public void createStudent(String name, LocalDate birthDate) {
        Student student = new Student();
        student.setName(name);
        student.setBirthDate(birthDate);
        students.add(studentDAO.addStudent(student));
    }

    public void addCourseToEducation(int educationId, int courseId) {
        educationDAO.addCourseToEducation(educationId, courseId);
    }

    public void addStudentToEducation(int educationId, int studentId) {
        educationDAO.addStudentToEducation(educationId,studentId);
    }

    public void addTeacherToCourse(int courseId, int teacherId) {
        courseDAO.addTeacherToCourse(courseId, teacherId);
    }

    public void removeEducationById(int id) {
        educationDAO.removeEducationById(id);
    }

    public void removeCourseById(int id) {
        courseDAO.removeCourseById(id);
    }

    public void removeTeacherById(int id) {
        teacherDAO.removeTeacherById(id);
    }

    public void removeStudentById(int id) {
        studentDAO.removeStudentById(id);
    }

    public void updateEducationName(int id, String newName) {
        educationDAO.updateEducationName(id, newName);
    }

    public void updateCourseName(int id, String newName) {
        courseDAO.updateCourseName(id, newName);
    }

    public void updateTeacherName(int id, String newName) {
        teacherDAO.updateTeacherName(id, newName);
    }

    public void updateStudentName(int id, String newName) {
        studentDAO.updateStudentName(id, newName);
    }

    public void updateCache() {
        educations.clear();
        educations.addAll(educationDAO.getEducations());
        courses.clear();
        courses.addAll(courseDAO.getCourses());
        teachers.clear();
        teachers.addAll(teacherDAO.getTeachers());
        students.clear();
        students.addAll(studentDAO.getStudents());
    }

    public List<Education> getEducations() {
        return educationDAO.getEducations();
    }

    public List<Course> getCourses() {
        return courseDAO.getCourses();
    }

    public List<Teacher> getTeachers() {
        return teacherDAO.getTeachers();
    }

    public List<Student> getStudents() {
        return studentDAO.getStudents();
    }

    public List<Course> getEducationCourses(int educationId) {
        return educationDAO.getEducationCourses(educationId);
    }

    public List<Student> getEducationStudents(int educationId) {
        return educationDAO.getEducationStudents(educationId);
    }

    public List<Teacher> getCourseTeachers(int courseId) {
        return courseDAO.getCourseTeachers(courseId);
    }

    public List<Education> getCourseEducations(int courseId) {
        return courseDAO.getCourseEducations(courseId);
    }

    public List<Course> getTeacherCourses(int teacherId) {
        return teacherDAO.getTeacherCourses(teacherId);
    }

    public List<Education> getStudentEducation(int studentId) {
        return studentDAO.getStudentEducation(studentId);
    }
}
