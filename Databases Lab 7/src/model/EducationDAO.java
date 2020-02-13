package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EducationDAO implements EducationDAOInterface {
    EntityManagerFactory emf;

    public EducationDAO() {
        emf = Persistence.createEntityManagerFactory("DBLab7PU");
    }

    @Override
    public Education addEducation(Education education) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(education);
        em.getTransaction().commit();
        em.close();
        return education;
    }

    @Override
    public void removeEducationById(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Education education = em.find(Education.class, id);
        for (Course course: education.getCourses()) {
            course.getEducations().remove(education);
        }
        education.getCourses().clear();
        for (Student student : education.getStudents()) {
            student.clearEducation();
        }
        education.getStudents().clear();
        em.remove(education);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void addCourseToEducation(int educationId, int courseId){
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        Education education = em.find(Education.class, educationId);
        Course course = em.find(Course.class, courseId);
        education.addCourse(course);
        em.persist(education);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void addStudentToEducation(int educationId, int studentId) {
        EntityManager em = emf.createEntityManager();
        Student student = em.find(Student.class, studentId);
        Education education = em.find(Education.class, educationId);
        if (student.getEducation() != null) {
            em.getTransaction().begin();
            student.removeEducation(student.getEducation());
            em.getTransaction().commit();
        }
        em.getTransaction().begin();
        education.addStudent(student);
        em.persist(education);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void updateEducationName(int id, String newName) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Education education = em.find(Education.class, id);
        education.setName(newName);
        em.persist(education);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Education> getEducations() {
        EntityManager em = emf.createEntityManager();
        List<Education> educations = em.createQuery("SELECT e FROM Education AS e ", Education.class).getResultList();
        em.close();
        return educations;
    }

    @Override
    public List<Course> getEducationCourses(int educationId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Education education = em.find(Education.class, educationId);
        List<Course> list = new ArrayList<>(education.getCourses());
        em.getTransaction().commit();
        em.close();
        return list;
    }

    @Override
    public List<Student> getEducationStudents(int educationId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Education education = em.find(Education.class, educationId);
        List<Student> list = new ArrayList<>(education.getStudents());
        em.getTransaction().commit();
        em.close();
        return list;
    }
}
