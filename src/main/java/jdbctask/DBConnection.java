package jdbctask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {
    private final String url;
    private final String username;
    private final String password;

    public DBConnection(String dbUrl, String username, String password) {
        this.url = dbUrl;
        this.username = username;
        this.password = password;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public PreparedStatement createPreparedStatement(String sql) throws SQLException {
        Connection connection = getConnection();
        return connection.prepareStatement(sql);
    }
}

