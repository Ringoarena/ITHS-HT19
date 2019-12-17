package view;

import model.Author;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class AuthorTableModel extends AbstractTableModel {
    private List<Author> authors;
    private String[] columnNames = {"ID", "Name", "nBooks"};

    public AuthorTableModel() {
        authors = new ArrayList<>();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Author author = authors.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return author.getId();
            case 1:
                return author.getName();
            case 2:
                return author.getBooks().size();
        }
        return null;
    }

    public void setData(List<Author> authors) {
        this.authors = authors;
    }

    public int getRowCount() {
        return authors.size();
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public String getColumnName(int column) {
        return columnNames[column];
    }
}
