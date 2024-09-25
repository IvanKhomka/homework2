package jdbctask.oldprojectclasses;

import java.time.LocalDateTime;

public class Ticket {
    private int id;
    private int userId;
    private String ticketType;
    private LocalDateTime creationDate;

    public Ticket(int id, int userId, String ticketType, LocalDateTime creationDate) {
        this.id = id;
        this.userId = userId;
        this.ticketType = ticketType;
        this.creationDate = creationDate;
    }


    public int getId() {
        return id; }
    public int getUserId() {
        return userId; }
    public String getTicketType() {
        return ticketType; }
    public LocalDateTime getCreationDate() {
        return creationDate; }
}