public class TicketService {

    private Ticket[] tickets;
    private int ticketCount;

    public TicketService() {
        tickets = new Ticket[10];
        ticketCount;
    }
    public static void main(String[] args) {
        Ticket fullTicket = new Ticket("01","ArizonaHall",118,142354315,
                true,'C',3.421, 40.0);
        Ticket emptyTicket = new Ticket("0","GardenHall",176,1132341321,
                false,'A',0.0, 40.0);
        Ticket limitedTicket = new Ticket("GardenHall",177,1132341321);


        fullTicket.setPrice(45.24);
        emptyTicket.setPrice(0.0);
        limitedTicket.setPrice(30.0);


        System.out.println(fullTicket);
        System.out.println(emptyTicket);
        System.out.println(limitedTicket);

    }
    private boolean addTicket(Ticket ticket) {
        if (ticketCount < tickets.length) {
            tickets[ticketCount] = ticket;
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
}
