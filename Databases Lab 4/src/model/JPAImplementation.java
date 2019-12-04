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
        em.persist(new Person(name,localDate,gender));
        em.getTransaction().commit();
    }

    @Override
    public List<Person> getAll() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Person", Person.class)
                .getResultList();
    }

    @Override
    public void updateNameByID(int id, String name) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person p = em.find(Person.class, id);
        p.setName(name);
        em.getTransaction().commit();
    }

    @Override
    public void deleteByID(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person p = em.find(Person.class, id);
        em.remove(p);
        em.getTransaction().commit();
    }
}
