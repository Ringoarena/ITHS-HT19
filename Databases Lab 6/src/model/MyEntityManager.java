package model;

import java.util.ArrayList;
import java.util.List;

public class MyEntityManager {
    EntityDAO entityDAO;
    List<Author> authors;
    List<Book> books;

    public MyEntityManager() {
        entityDAO = new EntityDAO();
        authors = new ArrayList<>();
        books = new ArrayList<>();
    }

    public void createAuthor(String name) {
        entityDAO.addAuthor(name);
    }

    public void createBook(String title) {
        entityDAO.addBook(title);
    }

    public void removeAuthorByID(int id) {
        entityDAO.removeAuthorByID(id);
    }

    public void removeBookByID(int id) {
        entityDAO.removeBookByID(id);
    }

    public void updateAuthor(String newName,int id) {
        entityDAO.updateAuthor(newName,id);
    }

    public void updateBook(String newTitle, int id) {
        entityDAO.updateBook(newTitle,id);
    }

    public void associate(int authorID, int bookID) {
        entityDAO.associate(authorID,bookID);
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void updateCache() {
        authors.clear();
        authors.addAll(entityDAO.getAuthors());
        books.clear();
        books.addAll(entityDAO.getBooks());
    }
}
