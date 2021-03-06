package model;

import java.time.LocalDate;
import java.util.List;

public interface PersonDAO {
    void create(String name, LocalDate localDate, Gender gender);
    List<Person> getAll();
    void updateNameByID(int id, String name);
    void deleteByID(int id);
}
