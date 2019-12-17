package view;

import javax.swing.*;
import java.awt.*;

public class AuthorTablePanel extends JPanel {
    private JTable table;
    private JPopupMenu jPopupMenu;
    private JMenuItem deleteItem, updateItem;

    public AuthorTablePanel() {
        table = new JTable();
        deleteItem = new JMenuItem("Delete");
        updateItem = new JMenuItem("Update");
        jPopupMenu = new JPopupMenu();
        jPopupMenu.add(deleteItem);
        jPopupMenu.add(updateItem);
        table.setModel(new AuthorTableModel());
        setMinimumSize(new Dimension(500,100));
        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public JTable getTable() {
        return table;
    }

    public AuthorTableModel getAuthorTableModel() {
        return (AuthorTableModel) table.getModel();
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
}
