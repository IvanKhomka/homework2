package jdbctask.dao;

import jdbctask.DBConnection;
import jdbctask.oldprojectclasses.User;
import java.sql.*;

public class UserDao {
    private static final String SAVE_USER = "INSERT INTO \"User\" (name) VALUES (?);";
    private static final String GET_USER_BY_ID = "SELECT * FROM \"User\" WHERE id = ?;";
    private static final String DELETE_USER_BY_ID = "DELETE FROM \"User\" WHERE id = ?;";

    private final DBConnection connectionManager;

    public UserDao(DBConnection connectionManager) {
        this.connectionManager = new DBConnection(DBConnection.DB_URL,DBConnection.USERNAME,DBConnection.PASSWORD);
    }

    public void saveUser(String name) {

        try (PreparedStatement preparedStatement = connectionManager.createPreparedStatement(SAVE_USER)) {
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUserById(int userId) {
        User user = null;

        try (PreparedStatement preparedStatement = connectionManager.createPreparedStatement(GET_USER_BY_ID)){
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

        try (PreparedStatement preparedStatement = connectionManager.createPreparedStatement(DELETE_USER_BY_ID)) {
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
