package view;

import model.Song;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class SongTableModel extends AbstractTableModel {
    private List<Song> songs;
    private String[] columnNames = {"ID", "Title", "Artist"};

    public SongTableModel() {
        this.songs = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return songs.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Song song = songs.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return song.getId();
            case 1:
                return song.getTitle();
            case 2:
                return song.getArtist().getName();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void setData(List<Song> songs) {
        this.songs = songs;
    }
}
