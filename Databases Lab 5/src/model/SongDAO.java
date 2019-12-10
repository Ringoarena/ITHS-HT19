package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class SongDAO {
    EntityManagerFactory emf;

    public SongDAO() {
        emf = Persistence.createEntityManagerFactory("PU");
    }

    public void addSong(Song song) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(song);
        em.getTransaction().commit();
    }

    public void removeSongByID(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Song song = em.find(Song.class, id);
        em.remove(song);
        em.getTransaction().commit();
    }

    public Song getSongByID(int id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Song.class, id);
    }

    public List<Song> getSongs() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Song", Song.class).getResultList();
    }

    public void updateTitleByID(String name, int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Song song = em.find(Song.class, id);
        song.setTitle(name);
        em.getTransaction().commit();
    }
}
