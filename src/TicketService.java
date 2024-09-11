import java.util.ArrayList;
import java.util.List;

public class TicketService {

    private Ticket[] tickets;
    private int ticketCount;

    public TicketService() {
        tickets = new Ticket[10];
    }

    public static void main(String[] args) {
        TicketService ticketService = new TicketService();
        Ticket fullTicket = new Ticket("1", "ArizonaHall", 118, 142354315,
                true, 'C', 3.421, 40.0);
        Ticket emptyTicket = new Ticket("0", "GardenHall", 176, 1132341321,
                false, 'A', 0.0, 40.0);
        Ticket limitedTicket = new Ticket("GardenHall", 177, 1132341321);

        ticketService.addTicket(fullTicket);
        ticketService.addTicket(emptyTicket);
        ticketService.addTicket(limitedTicket);
        fullTicket.setPrice(45.24);
        emptyTicket.setPrice(0.0);
        limitedTicket.setPrice(30.0);

        User client = new Client();
        User admin = new Admin();
        client.printRole();
        admin.printRole();
        ((Client) client).getTicket(fullTicket);
        ((Admin) admin).checkTicket(fullTicket);
        fullTicket.shareByPhone();
        fullTicket.shareByEmail();

        System.out.println(fullTicket);
        System.out.println(emptyTicket);
        System.out.println(limitedTicket);

        char sectorToSearch = 'A';
        List<Ticket> ticketsInSectorA = ticketService.getTicketsByStadiumSector(sectorToSearch);
        System.out.println("Tickets in Stadium Sector '" + sectorToSearch + "':");
        for (Ticket ticket : ticketsInSectorA) {
            ticket.print();
        }
    }

    private boolean addTicket(Ticket fullTicket) {
        if (ticketCount < tickets.length) {
            tickets[ticketCount] = fullTicket;
            ticketCount++;
            return true;
        }
        return false;
    }

    private Ticket getTicketById(String id) {
        for (int i = 0; i < ticketCount; i++) {
            if (tickets[i].getId().equals(id)) {
                return tickets[i];
            }
        }
        return null;
    }

    public List<Ticket> getTicketsByStadiumSector(char sector) {
        List<Ticket> result = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            if (tickets[i].getStadiumSector() == sector) {
                result.add(tickets[i]);
            }
        }
        return result;
    }
}

