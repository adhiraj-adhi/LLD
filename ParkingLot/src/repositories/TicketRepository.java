package repositories;

import models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
    private Map<Long, Ticket> tickets = new HashMap<>();
    private Long idCounter = 0L;
    public Ticket save(Ticket ticket) {
        idCounter+=1;
        ticket.setId(idCounter);
        tickets.put(idCounter, ticket);
        return ticket;
    }
}
