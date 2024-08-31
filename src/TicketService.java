public class TicketService {
    public static void main(String[] args) {
        Ticket fullTicket = new Ticket("01","GardenHall",118,142354315,
                true,'C',3.421, 40.0);
        Ticket emptyTicket = new Ticket("0","GardenHall",176,1132341321,
                false,'A',0.0, 40.0);
        Ticket limitedTicket = new Ticket("GardenHall",177,1132341321);

        emptyTicket.setPrice(0.0);
        limitedTicket.setPrice(30.0);

        System.out.println("Full Ticket: ID=" + fullTicket.getId() + ", Concert Hall=" + fullTicket.getConcertHall() +
                ", Event Code=" + fullTicket.getEventCode() + ", Purchase time=" + fullTicket.getTime() +", Promo=" +
                fullTicket.isPromo() +" ,Stadium Sector=" + fullTicket.getStadiumSector() + ", Backpack Weight=" + fullTicket.backpackWeight() +
                ", Price=" + fullTicket.getPrice());
        System.out.println("Empty Ticket: ID=" + emptyTicket.getId() + ", Concert Hall=" + emptyTicket.getConcertHall() +
                ", Event Code=" + emptyTicket.getEventCode() + ", Purchase time=" + emptyTicket.getTime() +", Promo=" +
                emptyTicket.isPromo() +" ,Stadium Sector=" + emptyTicket.getStadiumSector() + ", Backpack Weight=" + emptyTicket.backpackWeight() +
                ", Price=" + emptyTicket.getPrice());
        System.out.println("Concert Hall=" + limitedTicket.getConcertHall() + ", Event Code=" + limitedTicket.getEventCode() +
                ", Purchase time=" + limitedTicket.getTime());

    }
}
