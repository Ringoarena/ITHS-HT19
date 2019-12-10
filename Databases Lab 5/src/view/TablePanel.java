package view;

import javax.swing.*;
import java.awt.*;

public class TablePanel extends JPanel {
    private JTable table;
    private ArtistTableModel artistTableModel;
    private SongTableModel songTableModel;
    private JMenuItem deleteItem;
    private JMenuItem updateItem;
    private JPopupMenu jPopupMenu;

    public TablePanel() {
        table = new JTable();
        artistTableModel = new ArtistTableModel();
        songTableModel = new SongTableModel();
        deleteItem = new JMenuItem("Delete");
        updateItem = new JMenuItem("Update");
        jPopupMenu = new JPopupMenu();

        jPopupMenu.add(deleteItem);
        jPopupMenu.add(updateItem);

        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public JTable getTable() {
        return table;
    }

    public ArtistTableModel getArtistTableModel() {
        return artistTableModel;
    }

    public SongTableModel getSongTableModel() {
        return songTableModel;
    }

    public JMenuItem getDeleteItem() {
        return deleteItem;
    }

    public JMenuItem getUpdateItem() {
        return updateItem;
    }

    public JPopupMenu getjPopupMenu() {
        return jPopupMenu;
    }
}
