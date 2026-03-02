package services;

import dtos.GenerateTicketResponseDTO;
import models.*;
import repositories.ParkingLotRepository;
import repositories.TicketRepository;
import strategies.spotAssignmentStrategy.SpotAssignmentStrategy;

import java.util.Date;

public class TicketService {
    private TicketRepository ticketRepository;
    private SpotAssignmentStrategy spotAssignmentStrategy;
    private ParkingLotRepository parkingLotRepository;

    public TicketService(TicketRepository ticketRepository, SpotAssignmentStrategy strategy,
                         ParkingLotRepository parkingLotRepository) {
        this.ticketRepository = ticketRepository;
        this.spotAssignmentStrategy = strategy;
        this.parkingLotRepository = parkingLotRepository;
    }
    public GenerateTicketResponseDTO generateTicketService(Vehicle vehicle, SpotType spotType,
                                                           EntryGate entryGate, Long parkingLotId) {
        // LOGIC
        // Getting Parking Lot:
        ParkingLot parkingLot = parkingLotRepository.findById(parkingLotId);
        // Assigning Spot
        Spot spot = spotAssignmentStrategy.assignSpot(spotType, entryGate, parkingLot);
        if (spot==null) {
            // No empty spot
            return null;
        }

        spot.setSpotStatus(SpotStatus.BOOKED);

        Ticket ticket = new Ticket();
        ticket.setEntryGate(entryGate);
        ticket.setOperator(entryGate.getOperator());
        ticket.setVehicle(vehicle);
        ticket.setParkingLotAddress(parkingLot.getAddress());
        ticket.setFloorNumber(spot.getFloorNumber());
        ticket.setEntryTime(new Date());
        ticket.setSpot(spot);

        Ticket savedTicket = ticketRepository.save(ticket);

        GenerateTicketResponseDTO generateTicketResponseDTO = new GenerateTicketResponseDTO();
        generateTicketResponseDTO.setTicket(ticket);
        return generateTicketResponseDTO;
    }
}
