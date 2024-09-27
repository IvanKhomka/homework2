package jdbctask.dao;

import jdbctask.DBConnection;
import jdbctask.oldprojectclasses.Ticket;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDao {

    private static final String SAVE_TICKET = "INSERT INTO Ticket (user_id, ticket_type) VALUES (?, ?::ticket_type);";
    private static final String GET_TICKET_BY_ID = "SELECT * FROM Ticket WHERE id = ?;";
    private static final String GET_TICKETS_BY_USER_ID = "SELECT * FROM Ticket WHERE user_id = ?;";
    private static final String UPDATE_TICKET_TYPE = "UPDATE Ticket SET ticket_type = ?::ticket_type WHERE id = ?;";
    private static final String DELETE_TICKET_BY_ID = "DELETE FROM Ticket WHERE id = ?;";

    private final DBConnection connectionManager;

    public TicketDao(DBConnection connectionManager) {
        this.connectionManager = new DBConnection(DBConnection.DB_URL,DBConnection.USERNAME,DBConnection.PASSWORD);
    }

    public void saveTicket(int userId, String ticketType) {

        try (PreparedStatement preparedStatement = connectionManager.createPreparedStatement(SAVE_TICKET)) {
            preparedStatement.setInt(1, userId);
            preparedStatement.setString(2, ticketType);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Ticket getTicketById(int ticketId) {
        Ticket ticket = null;

        try (PreparedStatement preparedStatement = connectionManager.createPreparedStatement(GET_TICKET_BY_ID)) {
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

        try (PreparedStatement preparedStatement = connectionManager.createPreparedStatement(GET_TICKETS_BY_USER_ID)) {
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

        try (PreparedStatement preparedStatement = connectionManager.createPreparedStatement(UPDATE_TICKET_TYPE)) {
            preparedStatement.setString(1, newTicketType);
            preparedStatement.setInt(2, ticketId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTicketById(int ticketId) {

        try (PreparedStatement preparedStatement = connectionManager.createPreparedStatement(DELETE_TICKET_BY_ID)) {
            preparedStatement.setInt(1, ticketId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
