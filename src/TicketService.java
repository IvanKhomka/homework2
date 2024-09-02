public class TicketService {
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
}
