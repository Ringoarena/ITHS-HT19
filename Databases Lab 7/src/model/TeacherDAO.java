package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAO {
    EntityManagerFactory emf;

    public TeacherDAO() {
        emf = Persistence.createEntityManagerFactory("DBLab7PU");
    }

    public Teacher addTeacher(Teacher teacher) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(teacher);
        em.getTransaction().commit();
        em.close();
        return teacher;
    }

    public void removeTeacherById(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Teacher teacher = em.find(Teacher.class, id);
        for (Course course : teacher.getCourses()) {
            course.getTeachers().remove(teacher);
        }
        em.remove(teacher);
        em.getTransaction().commit();
        em.close();
    }

    public void updateTeacherName(int id,String newName) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Teacher teacher = em.find(Teacher.class, id);
        teacher.setName(newName);
        em.persist(teacher);
        em.getTransaction().commit();
        em.close();
    }

    public List<Teacher> getTeachers() {
        EntityManager em = emf.createEntityManager();
        List<Teacher> teachers = em.createQuery(" SELECT t FROM Teacher AS t ", Teacher.class).getResultList();
        em.close();
        return teachers;
    }

    public List<Course> getTeacherCourses(int teacherId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Teacher teacher = em.find(Teacher.class, teacherId);
        List<Course> list = new ArrayList<>(teacher.getCourses());
        em.getTransaction().commit();
        em.close();
        return list;
    }
}
