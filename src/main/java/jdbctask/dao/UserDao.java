package jdbctask.dao;

import jdbctask.DBConnection;
import jdbctask.oldprojectclasses.User;
import java.sql.*;

public class UserDao {

    private final DBConnection connectionManager;

    public UserDao(DBConnection connectionManager) {
        this.connectionManager = new DBConnection(DBConnection.DB_URL,DBConnection.USERNAME,DBConnection.PASSWORD);
    }

    public void saveUser(String name) {
        String query = "INSERT INTO \"User\" (name) VALUES (?);";

        try (PreparedStatement preparedStatement = connectionManager.createPreparedStatement(query)) {
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUserById(int userId) {
        User user = null;
        String query = "SELECT * FROM \"User\" WHERE id = ?;";

        try (PreparedStatement preparedStatement = connectionManager.createPreparedStatement(query)){
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                Timestamp creationDate = resultSet.getTimestamp("creation_date");
                user = new User(userId, name, creationDate.toLocalDateTime());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void deleteUserById(int userId) {
        String query = "DELETE FROM \"User\" WHERE id = ?;";

        try (PreparedStatement preparedStatement = connectionManager.createPreparedStatement(query)) {
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
