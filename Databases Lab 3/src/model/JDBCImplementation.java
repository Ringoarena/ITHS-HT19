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
            throw new RuntimeException("PersonDAO constructor() problem");
        }
    }

    public boolean updateNameByID(int id, String name) {
        try {
            updateName.setString(1,name);
            updateName.setInt(2, id);
            if (updateName.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
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
            throw new RuntimeException("PersonDAO create() error");
        }
    }

    public List<Person> getAll() {
        try {
            return listFromStatement(findAll);
        } catch (SQLException e) {
            throw new RuntimeException("PersonDAO getALL() error");
        }
    }

    public boolean deleteByID(int id) {
        try {
            delete.setInt(1, id);
            if (delete.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException("PersonDAO deleteByID() error");
        }
    }

    private List<Person> listFromStatement(PreparedStatement statement) throws SQLException {
        List<Person> list = new ArrayList<>();
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            list.add(new Person(rs.getInt("idpersons"),
                    rs.getString("name"),
                    rs.getDate("dateofbirth").toLocalDate(),
                    Gender.valueOf(rs.getString("gender"))));
        }
        return list;
    }
}
