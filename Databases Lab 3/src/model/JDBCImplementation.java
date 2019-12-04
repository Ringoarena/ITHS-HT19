package model;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JDBCImplementation implements PersonDAO {
    Connection connection;
    PreparedStatement insert, findAll, delete, updateName;

    public JDBCImplementation() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db0", "root", "root");
            insert = connection.prepareStatement("INSERT INTO persons (name, dateofbirth, gender) VALUES (?,?,?)");
            findAll = connection.prepareStatement("SELECT * FROM persons");
            delete = connection.prepareStatement("DELETE FROM persons WHERE idpersons = ?");
            updateName = connection.prepareStatement("UPDATE persons SET name = ? WHERE idpersons = ?");
        } catch (Exception e) {
            throw new RuntimeException("JDBCImplementation constructor() problem");
        }
    }

    public void updateNameByID(int id, String name) {
        try {
            updateName.setString(1,name);
            updateName.setInt(2, id);
            updateName.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("PersonDAO updateNameByID() error");
        }
    }

    public void create(String name, LocalDate localDate, Gender gender) {
        try {
            insert.setString(1,name);
            insert.setDate(2, Date.valueOf(localDate));
            insert.setString(3,gender.name());
            insert.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("JDBCImplementation create() error");
        }
    }

    public List<Person> getAll() {
        List<Person> list = new ArrayList<>();
        try {
            ResultSet rs = findAll.executeQuery();
            while (rs.next()) {
                list.add(new Person(rs.getInt("idpersons"),
                        rs.getString("name"),
                        rs.getDate("dateofbirth").toLocalDate(),
                        Gender.valueOf(rs.getString("gender"))));
            }
        } catch (SQLException e) {
            throw new RuntimeException("JDBCImplementation getAll() error");
        }
        return list;
    }

    public void deleteByID(int id) {
        try {
            delete.setInt(1, id);
            delete.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("PersonDAO deleteByID() error");
        }
    }
}
