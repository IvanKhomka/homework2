package andersen;

import java.time.Instant;
import java.util.Objects;

    public class Ticket extends Identifiable implements Printable {
    @NullableWarning
    private String concertHall;
    private int eventCode;
    private long time;
    private boolean isPromo;
    private char stadiumSector;
    private double backpackWeight;
    private double price;

    public Ticket(String id, String concertHall, int eventCode,
                 long time,boolean isPromo, char stadiumSector,
                 double backpackWeight, double price) {
       this.id = id;
       this.concertHall = concertHall;
       this.eventCode = eventCode;
       this.time = time;
       this.isPromo = isPromo;
       this.stadiumSector = stadiumSector;
       this.backpackWeight = backpackWeight;
       this.price = price;
       this.time = Instant.now().getEpochSecond();
    }
    public Ticket(String concertHall, int eventCode, long time) {
        this.id = "0";
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.time = time;
        this.isPromo = false;
        this.stadiumSector = 'A';
        this.backpackWeight = 0.0;
        this.price = price;
        this.time = Instant.now().getEpochSecond();
    }
    public String toString() {
        return "Ticket: ID=" + id + ", Concert Hall=" + concertHall +
                ", Event Code=" + eventCode + ", Purchase time=" + time +", Promo=" +
                isPromo +" ,Stadium Sector=" + stadiumSector + ", Backpack Weight=" + backpackWeight +
                ", Price=" + price;
    }

    public String getConcertHall() {
        return concertHall;
    }

    public int getEventCode() {
        return eventCode;
    }

    public long getTime() {
        return time;
    }

    public boolean isPromo() {
        return isPromo;
    }

    public char getStadiumSector() {
        return stadiumSector;
    }

    public double backpackWeight() {
        return backpackWeight;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket ticket)) return false;
        return Objects.equals(id, ticket.id);
    }
    public int hashCode() {
        return Objects.hash(id);
    }
    public void shareByPhone() {
        System.out.println("Ticket shared by phone!");
    }

    public void shareByEmail() {
        System.out.println("Ticket shared by email!");
    }

    public void print() {
        System.out.println(this.toString());
        }
    }

