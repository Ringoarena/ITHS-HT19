package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EntityDAO {
    EntityManagerFactory emf;

    public EntityDAO() {
        emf = Persistence.createEntityManagerFactory("NewPU");
    }

    public void addAuthor(String name) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Author author = new Author(name);
        em.persist(author);
        em.getTransaction().commit();
        em.close();
    }

    public void addBook(String title) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Book book = new Book(title);
        em.persist(book);
        em.getTransaction().commit();
        em.close();
    }

    public void removeAuthorByID(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Author author = em.find(Author.class, id);
        for (Book book : author.getBooks()) {
            author.removeBook(book);
        }
        em.remove(author);
        em.getTransaction().commit();
        em.close();
    }

    public void removeBookByID(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Book book = em.find(Book.class, id);
        for (Author author : book.getAuthors()) {
            book.removeAuthor(author);
        }
        em.remove(book);
        em.getTransaction().commit();
        em.close();
    }

    public void updateAuthor(String newName, int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Author author = em.find(Author.class, id);
        author.setName(newName);
        em.persist(author);
        em.getTransaction().commit();
        em.close();
    }

    public void updateBook(String newTitle, int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Book book = em.find(Book.class, id);
        book.setTitle(newTitle);
        em.persist(book);
        em.getTransaction().commit();
        em.close();
    }

    public void associate(int authorID, int bookID) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Author author = em.find(Author.class, authorID);
        Book book = em.find(Book.class, bookID);
        author.addBook(book);
        em.persist(author);
        em.getTransaction().commit();
        em.close();
    }

    public List<Author> getAuthors() {
        EntityManager em = emf.createEntityManager();
        List<Author> list = em.createQuery("SELECT a FROM Author a", Author.class).getResultList();
        em.close();
        return list;
    }

    public List<Book> getBooks() {
        EntityManager em = emf.createEntityManager();
        List<Book> list = em.createQuery("SELECT b FROM Book b", Book.class).getResultList();
        em.close();
        return list;
    }
}
