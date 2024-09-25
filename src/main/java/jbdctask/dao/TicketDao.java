package jbdctask.dao;

import jbdctask.oldprojectclasses.Ticket;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDao {
    private final String url;
    private final String username;
    private final String password;

    public TicketDao(String dbUrl, String username, String password) {
        this.url = dbUrl;
        this.username = username;
        this.password = password;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public void saveTicket(int userId, String ticketType) {
        String query = "INSERT INTO Ticket (user_id, ticket_type) VALUES (?, ?::ticket_type);";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userId);
            preparedStatement.setString(2, ticketType);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Ticket getTicketById(int ticketId) {
        Ticket ticket = null;
        String query = "SELECT * FROM Ticket WHERE id = ?;";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, ticketId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                int userId = resultSet.getInt("user_id");
                String ticketType = resultSet.getString("ticket_type");
                Timestamp creationDate = resultSet.getTimestamp("creation_date");

                ticket = new Ticket(id, userId, ticketType, creationDate.toLocalDateTime());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ticket;
    }

    public List<Ticket> getTicketsByUserId(int userId) {
        List<Ticket> tickets = new ArrayList<>();
        String query = "SELECT * FROM Ticket WHERE user_id = ?;";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String ticketType = resultSet.getString("ticket_type");
                Timestamp creationDate = resultSet.getTimestamp("creation_date");

                Ticket ticket = new Ticket(id, userId, ticketType, creationDate.toLocalDateTime());
                tickets.add(ticket);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tickets;
    }

    public void updateTicketType(int ticketId, String newTicketType) {
        String query = "UPDATE Ticket SET ticket_type = ?::ticket_type WHERE id = ?;";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, newTicketType);
            preparedStatement.setInt(2, ticketId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTicketById(int ticketId) {
        String query = "DELETE FROM Ticket WHERE id = ?;";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, ticketId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
