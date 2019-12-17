package view;

import model.Book;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class BookTableModel extends AbstractTableModel {
    private List<Book> books;
    private String[] columnNames = {"ID", "Title", "Author"};

    public BookTableModel() {
        books = new ArrayList<>();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Book book = books.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return book.getId();
            case 1:
                return book.getTitle();
            case 2:
                return book.getAuthorNames();
        }
        return null;
    }

    public void setData(List<Book> books) {
        this.books = books;
    }

    public int getRowCount() {
        return books.size();
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public String getColumnName(int column) {
        return columnNames[column];
    }
}
