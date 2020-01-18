package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    EntityManagerFactory emf;

    public StudentDAO() {
        emf = Persistence.createEntityManagerFactory("DBLab7PU");
    }

    public Student addStudent(Student student) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        em.close();
        return student;
    }

    public void removeStudentById(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Student student = em.find(Student.class, id);
        student.removeEducation(student.getEducation());
        em.remove(student);
        em.getTransaction().commit();
        em.close();
    }

    public void updateStudentName(int id,String newName) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Student student = em.find(Student.class, id);
        student.setName(newName);
        em.persist(student);
        em.getTransaction().commit();
        em.close();
    }

    public List<Student> getStudents() {
        EntityManager em = emf.createEntityManager();
        List<Student> students=em.createQuery("SELECT s FROM Student s",Student.class).getResultList();
        em.close();
        return students;
    }

    public List<Education> getStudentEducation(int studentId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Student student = em.find(Student.class, studentId);
        List<Education> list = new ArrayList<>();
        if (student.getEducation() != null) {
            list.add(student.getEducation());
        } else {
            Education noEducation = new Education();
            noEducation.setName("No education assigned");
            noEducation.setId(-1337);
            list.add(noEducation);
        }
        return list;
    }
}
