package jdbctask;

import jdbctask.dao.TicketDao;
import jdbctask.dao.UserDao;
import jdbctask.oldprojectclasses.Ticket;
import jdbctask.oldprojectclasses.User;

import java.util.List;

public class Demonstration {

       public static void main(String[] args) {

       DBConnection connectionManager = new DBConnection(DBConfig.DB_URL,DBConfig.USERNAME,DBConfig.PASSWORD);

       UserDao userDAO = new UserDao(connectionManager);
       TicketDao ticketDAO = new TicketDao(connectionManager);

        userDAO.saveUser("Ivan");
        userDAO.saveUser("Alexey");

        User userIvan = userDAO.getUserById(70);
        User userAlexey = userDAO.getUserById(71);

        System.out.println("Fetched User: " + userIvan.getName());
        System.out.println("Fetched User: " + userAlexey.getName());

        ticketDAO.saveTicket(userAlexey.getId(), "DAY");
        ticketDAO.saveTicket(userAlexey.getId(), "WEEK");
        ticketDAO.saveTicket(userIvan.getId(), "YEAR");

        List<Ticket> ivanTickets = ticketDAO.getTicketsByUserId(userIvan.getId());
        List<Ticket> alexeyTickets = ticketDAO.getTicketsByUserId(userAlexey.getId());

        System.out.println("Ivan's Tickets:");
        for (Ticket ticket : ivanTickets) {
            System.out.println(" - Ticket ID: " + ticket.getId() + ", Type: " + ticket.getTicketType());
        }

        System.out.println("Alexey's Tickets:");
        for (Ticket ticket : alexeyTickets) {
            System.out.println(" - Ticket ID: " + ticket.getId() + ", Type: " + ticket.getTicketType());
        }

        if (!alexeyTickets.isEmpty()) {
            Ticket firstTicket = alexeyTickets.get(0);
            ticketDAO.updateTicketType(firstTicket.getId(), "YEAR");
            System.out.println("Updated Ticket ID: " + firstTicket.getId() + " to new type: YEAR");
        }

        userDAO.deleteUserById(userIvan.getId());
        System.out.println("Deleted User: " + userIvan.getName() + " along with their tickets.");

        User deletedUser = userDAO.getUserById(userIvan.getId());
        System.out.println("Attempt to fetch deleted user: " + (deletedUser == null ? "User not found" : deletedUser.getName()));
    }
}

