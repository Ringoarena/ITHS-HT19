package view;

import model.Artist;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ArtistTableModel extends AbstractTableModel {
    private List<Artist> artists;
    private String[] columnNames = {"ID", "Name", "nSongs"};

    public ArtistTableModel() {
        this.artists = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return artists.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Artist artist = artists.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return artist.getId();
            case 1:
                return artist.getName();
            case 2:
                return artist.getSongs().size();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void setData(List<Artist> artists) {
        this.artists = artists;
    }
}
