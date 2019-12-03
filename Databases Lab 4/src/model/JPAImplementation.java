package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class JPAImplementation implements PersonDAO {
    EntityManagerFactory emf;

    public JPAImplementation() {
        emf = Persistence.createEntityManagerFactory("NPU");
    }

    @Override
    public void create(String name, LocalDate localDate, Gender gender) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person p = new Person();
        p.setName(name);
        p.setBirthDate(localDate);
        p.setGender(gender);
        em.persist(p);
        em.getTransaction().commit();
    }

    @Override
    public List<Person> getAll() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Person> list = em.createQuery("from Person", Person.class)
                .getResultList();
        em.getTransaction().commit();
        return list;
    }

    @Override
    public boolean updateNameByID(int id, String name) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person p = em.find(Person.class, id);
        p.setName(name);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public boolean deleteByID(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person p = em.find(Person.class, id);
        em.remove(p);
        em.getTransaction().commit();
        return true;
    }
}
