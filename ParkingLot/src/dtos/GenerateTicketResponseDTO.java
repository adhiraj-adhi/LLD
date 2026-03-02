package dtos;

import models.Ticket;

public class GenerateTicketResponseDTO {
    private Ticket ticket;  // Temporarily

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
