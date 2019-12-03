package view;

import javax.swing.*;
import java.awt.*;

public class TablePanel extends JPanel {
    private JTable table;
    private JPopupMenu jPopupMenu;
    private JMenuItem deleteItem;
    private JMenuItem updateItem;

    public TablePanel() {
        table = new JTable();
        deleteItem = new JMenuItem("Delete");
        updateItem = new JMenuItem("Update");
        jPopupMenu = new JPopupMenu();
        jPopupMenu.add(deleteItem);
        jPopupMenu.add(updateItem);
        table.setModel(new PersonTableModel());
        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public PersonTableModel getModel() {
        return (PersonTableModel)table.getModel();
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
}
