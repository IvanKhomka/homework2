public class Client extends User {
    @Override
    public void printRole() {
        System.out.println("I am a Client.");
    }

    public Ticket getTicket(Ticket ticket) {
        System.out.println("Client received ticket: " + ticket);
        return ticket;
    }
}