import java.time.Instant;
public class Ticket {
    private String id;
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
    public String getId() {
        return id;
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
}
