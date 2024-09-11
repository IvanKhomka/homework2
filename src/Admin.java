public class Admin extends User {
    @Override
    public void printRole() {
        System.out.println("I am an Admin.");
    }

    public boolean checkTicket(Ticket ticket) {
        System.out.println("Admin checking ticket: " + ticket);
        return false;
    }
}