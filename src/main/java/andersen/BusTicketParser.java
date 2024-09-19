package andersen;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BusTicketParser extends BusTicketService {
    public void parseAndValidateTickets(String jsonInput) {
        Gson gson = new Gson();
        try {
            BusTicket ticket = gson.fromJson(jsonInput, BusTicket.class);
            addTicket(ticket);
        } catch (JsonSyntaxException e) {
            System.out.println("Invalid JSON format: " + jsonInput);
        }
    }

    public void readTicketsFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                parseAndValidateTickets(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
