package jdbctask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DBConnection {

    private final String url;
    private final String username;
    private final String password;

    public static final String DB_URL = "jdbc:postgresql://localhost:5432/my_ticket_service_db";
    public static final String USERNAME = "postgres";
    public static final String PASSWORD = "82463755";


    public PreparedStatement createPreparedStatement(String sql) throws SQLException {
        Connection connection = getConnection();
        return connection.prepareStatement(sql);
    }

    public DBConnection(String dbUrl, String username, String password) {
        this.url = dbUrl;
        this.username = username;
        this.password = password;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}

