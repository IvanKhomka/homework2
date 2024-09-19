package andersen;

import java.time.LocalDate;
import java.util.*;

public class BusTicketService {

    private List<BusTicket> tickets;

    public static void main(String[] args) {

        BusTicketService ticketService = new BusTicketService();
        ticketService.addTicket(new BusTicket("CLA", "DAY",  LocalDate.now(), 0));
        ticketService.addTicket(new BusTicket("CLA", "DAY", LocalDate.now(), 10));
        ticketService.addTicket(new BusTicket("CLA", "PRIME", null, 1000));
        ticketService.addTicket(new BusTicket("STD", "DAY", LocalDate.now(), 0));
        ticketService.addTicket(new BusTicket("STD", "WEEK", LocalDate.now(), 50));
        ticketService.addTicket(new BusTicket("CLA", "YEAR", LocalDate.now(), 500));
        ticketService.addTicket(new BusTicket("CLA", "MONTH", LocalDate.now(), 100));
        ticketService.addTicket(new BusTicket("CLA", "DAY", LocalDate.now(), 100));
        ticketService.addTicket(new BusTicket(null, "MONTH", LocalDate.now(), 100));
        ticketService.addTicket(new BusTicket("STD", "MONTH", LocalDate.now(), 100));

        ticketService.validateTickets();
    }

    public BusTicketService() {
        this.tickets = new ArrayList<>();
    }

    public void addTicket(BusTicket ticket) {
        tickets.add(ticket);
    }

    public void validateTickets() {
        int totalTickets = tickets.size();
        int validTickets = 0;

        Map<String, Integer> violationCount = new HashMap<>();

        for (BusTicket ticket : tickets) {
            boolean isValid = true;

            if (ticket.getPrice() <= 0 || ticket.getPrice() % 2 != 0) {
                isValid = false;
                incrementViolationCount(violationCount, "price");
            }

            if (ticket.getStartDate() == null || ticket.getStartDate().isAfter(LocalDate.now())) {
                isValid = false;
                incrementViolationCount(violationCount, "start date");
            } else if (isTicketTypeRequiresStartDate(ticket) && ticket.getStartDate() == null) {
                isValid = false;
                incrementViolationCount(violationCount, "start date");
            }

            if (!isValidTicketType(ticket.getTicketType())) {
                isValid = false;
                incrementViolationCount(violationCount, "ticket type");
            }

            if (isValid) {
                validTickets++;
            }
        }

        System.out.println("Total = " + totalTickets);
        System.out.println("Valid = " + validTickets);
        System.out.println("Most popular violation = " + getMostPopularViolation(violationCount));
    }

    private boolean isTicketTypeRequiresStartDate(BusTicket ticket) {
        String type = ticket.getTicketType();
        return "DAY".equalsIgnoreCase(type) || "WEEK".equalsIgnoreCase(type) || "YEAR".equalsIgnoreCase(type);
    }

    private boolean isValidTicketType(String ticketType) {
        return "DAY".equalsIgnoreCase(ticketType) ||
                "WEEK".equalsIgnoreCase(ticketType) ||
                "MONTH".equalsIgnoreCase(ticketType) ||
                "YEAR".equalsIgnoreCase(ticketType);
    }

    private void incrementViolationCount(Map<String, Integer> violationCount, String violationType) {
        violationCount.put(violationType, violationCount.getOrDefault(violationType, 0) + 1);
    }

    private String getMostPopularViolation(Map<String, Integer> violationCount) {
        String mostPopularViolation = "None";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : violationCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostPopularViolation = entry.getKey();
            }
        }

        return mostPopularViolation;
    }
}