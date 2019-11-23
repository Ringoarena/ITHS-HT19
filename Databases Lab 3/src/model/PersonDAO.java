package model;

import java.time.LocalDate;
import java.util.List;

public interface PersonDAO {
    void create(String name, LocalDate localDate, Gender gender);
    List<Person> getAll();
    boolean updateNameByID(int id, String name);
    boolean deleteByID(int id);
}
