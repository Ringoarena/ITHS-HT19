package view;

import javax.swing.*;
import java.awt.*;

public class BookTablePanel extends JPanel {
    private JTable table;
    private JPopupMenu jPopupMenu;
    private JMenuItem deleteItem, updateItem, assignAuthorItem;

    public BookTablePanel() {
        table = new JTable();
        deleteItem = new JMenuItem("Delete");
        updateItem = new JMenuItem("Update");
        assignAuthorItem = new JMenuItem("Assign author");
        jPopupMenu = new JPopupMenu();
        jPopupMenu.add(deleteItem);
        jPopupMenu.add(updateItem);
        jPopupMenu.add(assignAuthorItem);
        table.setModel(new BookTableModel());
        setMinimumSize(new Dimension(500,100));
        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public BookTableModel getBookTableModel() {
        return (BookTableModel) table.getModel();
    }

    public JTable getTable() {
        return table;
    }

    public JPopupMenu getjPopupMenu() {
        return jPopupMenu;
    }

    public JMenuItem getDeleteItem() {
        return deleteItem;
    }

    public JMenuItem getUpdateItem() {
        return updateItem;
    }

    public JMenuItem getAssignAuthorItem() {
        return assignAuthorItem;
    }
}
