package controller;

import model.MyEntityManager;
import view.MainFrame;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Controller {
    MyEntityManager myEntityManager;
    MainFrame mainFrame;

    public Controller(MyEntityManager myEntityManager, MainFrame mainFrame) {
        this.myEntityManager = myEntityManager;
        this.mainFrame = mainFrame;
    }

    public void initiateController() {
        mainFrame.getAuthorTablePanel().getTable().addMouseListener(myAuthorMouseAdapter());
        mainFrame.getBookTablePanel().getTable().addMouseListener(myBookMouseAdapter());
        mainFrame.getAuthorFormPanel().getOkButton().addActionListener(e -> createAuthor());
        mainFrame.getBookFormPanel().getOkButton().addActionListener(e -> createBook());
        mainFrame.getAuthorTablePanel().getDeleteItem().addActionListener(e -> deleteAuthor());
        mainFrame.getBookTablePanel().getDeleteItem().addActionListener(e -> deleteBook());
        mainFrame.getAuthorTablePanel().getUpdateItem().addActionListener(e -> updateAuthor());
        mainFrame.getBookTablePanel().getUpdateItem().addActionListener(e -> updateBook());
        mainFrame.getBookTablePanel().getAssignAuthorItem().addActionListener(e -> associateAuthorBook());
        mainFrame.getAuthorFormPanel().getClearButton().addActionListener(e -> mainFrame.getAuthorFormPanel().getNameField().setText(""));
        mainFrame.getBookFormPanel().getClearButton().addActionListener(e -> mainFrame.getBookFormPanel().getTitleField().setText(""));
        mainFrame.getBookFormPanel().getClearButton().addActionListener(e -> mainFrame.getBookFormPanel().getAuthorIDField().setText(""));
    }

    public void createAuthor() {
        myEntityManager.createAuthor(mainFrame.getAuthorFormPanel().getNameField().getText());
        refreshTables();
    }

    public void createBook() {
        myEntityManager.createBook(mainFrame.getBookFormPanel().getTitleField().getText());
        refreshTables();
    }

    public void deleteAuthor() {
        JTable table = mainFrame.getAuthorTablePanel().getTable();
        int row = table.getSelectedRow();
        int id = (int) table.getModel().getValueAt(row, 0);
        myEntityManager.removeAuthorByID(id);
        refreshTables();
    }

    private void deleteBook() {
        JTable table = mainFrame.getBookTablePanel().getTable();
        int row = table.getSelectedRow();
        int id = (int) table.getModel().getValueAt(row, 0);
        myEntityManager.removeBookByID(id);
        refreshTables();
    }

    private void updateAuthor() {
        JTable table = mainFrame.getAuthorTablePanel().getTable();
        int row = table.getSelectedRow();
        int id = (int) table.getModel().getValueAt(row, 0);
        String newName = mainFrame.updateEntity(0);
        myEntityManager.updateAuthor(newName,id);
        refreshTables();
    }

    private void updateBook() {
        JTable table = mainFrame.getBookTablePanel().getTable();
        int row = table.getSelectedRow();
        int id = (int) table.getModel().getValueAt(row, 0);
        String newTitle = mainFrame.updateEntity(1);
        myEntityManager.updateBook(newTitle,id);
        refreshTables();
    }

    private void associateAuthorBook() {
        JTable table = mainFrame.getBookTablePanel().getTable();
        int row = table.getSelectedRow();
        int authorID = Integer.parseInt(mainFrame.updateEntity(2));
        int bookID = (int) table.getModel().getValueAt(row, 0);
        myEntityManager.associate(authorID,bookID);
        refreshTables();
    }

    public void refreshTables() {
        myEntityManager.updateCache();
        mainFrame.getAuthorTablePanel().getAuthorTableModel().setData(myEntityManager.getAuthors());
        mainFrame.getAuthorTablePanel().getAuthorTableModel().fireTableDataChanged();
        mainFrame.getBookTablePanel().getBookTableModel().setData(myEntityManager.getBooks());
        mainFrame.getBookTablePanel().getBookTableModel().fireTableDataChanged();
    }

    public MouseAdapter myAuthorMouseAdapter() {
        return new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                JTable table = mainFrame.getAuthorTablePanel().getTable();
                JPopupMenu jPopupMenu = mainFrame.getAuthorTablePanel().getjPopupMenu();
                int row = table.rowAtPoint(e.getPoint());
                table.getSelectionModel().setSelectionInterval(row,row);
                if (e.getButton() == MouseEvent.BUTTON3) {
                    jPopupMenu.show(table,e.getX(),e.getY());
                }
            }
        };
    }

    public MouseAdapter myBookMouseAdapter() {
        return new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                JTable table = mainFrame.getBookTablePanel().getTable();
                JPopupMenu jPopupMenu = mainFrame.getBookTablePanel().getjPopupMenu();
                int row = table.rowAtPoint(e.getPoint());
                table.getSelectionModel().setSelectionInterval(row,row);
                if (e.getButton() == MouseEvent.BUTTON3) {
                    jPopupMenu.show(table,e.getX(),e.getY());
                }
            }
        };
    }
}