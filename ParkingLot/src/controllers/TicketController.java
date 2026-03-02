package controllers;

import dtos.GenerateTicketRequestDTO;
import dtos.GenerateTicketResponseDTO;
import services.TicketService;

public class TicketController {
    private TicketService ticketService;
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    public GenerateTicketResponseDTO generateTicket(GenerateTicketRequestDTO generateTicketRequestDTO) {
        return ticketService.generateTicketService(generateTicketRequestDTO.getVehicle(),
                generateTicketRequestDTO.getSpotType(), generateTicketRequestDTO.getEntryGate(),
                generateTicketRequestDTO.getParkingLotId());
    }
}
