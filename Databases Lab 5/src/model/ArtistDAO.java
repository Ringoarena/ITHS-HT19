package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class ArtistDAO {
    EntityManagerFactory emf;

    public ArtistDAO() {
        emf = Persistence.createEntityManagerFactory("PU");
    }

    public void addArtist(Artist artist) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(artist);
        em.getTransaction().commit();
    }

    public void removeArtistByID(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Artist artist = em.find(Artist.class, id);
        em.remove(artist);
        em.getTransaction().commit();
//        em.getTransaction().begin();
//        Query query = em.createQuery("DELETE FROM Artist a WHERE a.id = :p");
//        query.setParameter("p", id);
//        query.executeUpdate();
//        em.getTransaction().commit();
    }

    public Artist getArtistByID(int id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Artist.class, id);
    }

    public List<Artist> getArtists() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("SELECT a FROM Artist a", Artist.class).getResultList();
    }

    public void updateNameByID(String name, int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Artist artist = em.find(Artist.class, id);
        artist.setName(name);
        em.getTransaction().commit();
//        em.getTransaction().begin();
//        Query query = em.createQuery("UPDATE Artist a SET a.name = :p1 WHERE a.id = :p2");
//        query.setParameter("p1", name).setParameter("p2", id);
//        query.executeUpdate();
//        em.getTransaction().commit();
    }
}
