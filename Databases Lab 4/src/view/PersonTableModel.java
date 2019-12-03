package view;

import model.Person;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class PersonTableModel extends AbstractTableModel {
    private List<Person> persons;
    private String[] columnNames = {"ID", "Name", "Date of Birth", "Gender"};

    public PersonTableModel() {
        persons = new ArrayList<>();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Person person = persons.get(rowIndex);
        switch (columnIndex){
            case 0:
                return person.getId();
            case 1:
                return person.getName();
            case 2:
                return person.getBirthDate();
            case 3:
                return person.getGender().name();
        }
        return null;
    }

    public int getColumnCount() {
        return 4;
    }

    public String getColumnName(int column) {
        return columnNames[column];
    }

    public int getRowCount() {
        return persons.size();
    }

    public void setData(List<Person> persons) {
        this.persons = persons;
    }
}
