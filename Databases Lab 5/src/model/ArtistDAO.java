package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
    }

    public Artist getArtistByID(int id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Artist.class, id);
    }

    public List<Artist> getArtists() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Artist", Artist.class).getResultList();
    }

    public void updateNameByID(String name, int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Artist artist = em.find(Artist.class, id);
        artist.setName(name);
        em.getTransaction().commit();
    }
}
