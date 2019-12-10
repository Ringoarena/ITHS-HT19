package controller;

import model.Artist;
import model.ArtistDAO;
import model.Song;
import model.SongDAO;
import view.ArtistTableModel;
import view.MainFrame;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class Controller {
    private ArtistDAO artistdao;
    private SongDAO songDAO;
    private MainFrame mainFrame;

    public Controller(ArtistDAO artistdao, SongDAO songDAO, MainFrame mainFrame) {
        this.artistdao = artistdao;
        this.songDAO = songDAO;
        this.mainFrame = mainFrame;

        setViewArtists();
        initiateController();
    }

    public void setViewArtists() {
        mainFrame.getTablePanel().getTable().setModel(mainFrame.getTablePanel().getArtistTableModel());
        refreshArtists();
    }

    public void setViewSongs() {
        mainFrame.getTablePanel().getTable().setModel(mainFrame.getTablePanel().getSongTableModel());
        refreshSongs();
    }

    public void initiateController() {
        mainFrame.getArtistFormPanel().getOkButton().addActionListener(e -> createArtist());
        mainFrame.getSongFormPanel().getOkButton().addActionListener(e -> createSong());
        mainFrame.getViewArtists().addActionListener(e -> setViewArtists());
        mainFrame.getViewSongs().addActionListener(e -> setViewSongs());
        mainFrame.getTablePanel().getDeleteItem().addActionListener(e -> removeEntity());
        mainFrame.getTablePanel().getUpdateItem().addActionListener(e -> updateEntity());
        mainFrame.getTablePanel().getTable().addMouseListener(myMouseAdapter());
    }

    public void createArtist() {
        artistdao.addArtist(new Artist(mainFrame.getArtistFormPanel().getNameField().getText()));
        refreshArtists();
        refreshSongs();
    }

    public void createSong() {
        Artist artist = artistdao.getArtistByID(Integer.parseInt(mainFrame.getSongFormPanel().getIdField().getText()));
        String title = mainFrame.getSongFormPanel().getTitleField().getText();
        Song song = new Song(title, artist);
        songDAO.addSong(song);
        refreshArtists();
        refreshSongs();
    }

    public void removeEntity() {
        JTable table = mainFrame.getTablePanel().getTable();
        int row = table.getSelectedRow();
        int id = (int) table.getModel().getValueAt(row, 0);
        if (mainFrame.getTablePanel().getTable().getModel() instanceof ArtistTableModel) {
            artistdao.removeArtistByID(id);
        } else {
            songDAO.removeSongByID(id);
        }
        refreshArtists();
        refreshSongs();
    }

    private void updateEntity() {
        JTable table = mainFrame.getTablePanel().getTable();
        int row = table.getSelectedRow();
        int id = (int) table.getModel().getValueAt(row, 0);
        String newString = JOptionPane.showInputDialog("Enter new data");
        if (mainFrame.getTablePanel().getTable().getModel() instanceof ArtistTableModel) {
            artistdao.updateNameByID(newString,id);
        } else {
            songDAO.updateTitleByID(newString,id);
        }
        refreshArtists();
        refreshSongs();
    }

    public void refreshArtists() {
        mainFrame.getTablePanel().getArtistTableModel().setData(artistdao.getArtists());
        mainFrame.getTablePanel().getArtistTableModel().fireTableDataChanged();
    }

    public void refreshSongs() {
        mainFrame.getTablePanel().getSongTableModel().setData(songDAO.getSongs());
        mainFrame.getTablePanel().getSongTableModel().fireTableDataChanged();
    }

    public MouseAdapter myMouseAdapter() {
        return new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                JTable table = mainFrame.getTablePanel().getTable();
                JPopupMenu jPopupMenu = mainFrame.getTablePanel().getjPopupMenu();
                int row = table.rowAtPoint(e.getPoint());
                table.getSelectionModel().setSelectionInterval(row,row);
                if (e.getButton() == MouseEvent.BUTTON3) {
                    jPopupMenu.show(table,e.getX(),e.getY());
                }
            }
        };
    }

    public List<Artist> getArtists() {
        return artistdao.getArtists();
    }

    public List<Song> getSongs() {
        return songDAO.getSongs();
    }
}
