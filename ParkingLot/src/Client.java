import controllers.ParkingLotController;
import controllers.SpotController;
import controllers.TicketController;
import dtos.*;
import models.*;
import repositories.*;
import services.ParkingLotService;
import services.SpotService;
import services.TicketService;
import strategies.spotAssignmentStrategy.RandomSpotAssignmentStrategy;
import strategies.spotAssignmentStrategy.SpotAssignmentStrategy;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        ObjectRegistry.put("parkingLotRepository", new ParkingLotRepository());
        ObjectRegistry.put("parkingFloorRepository", new ParkingFloorRepository());
        ObjectRegistry.put("entryGateRepository", new EntryGateRepository());
        ObjectRegistry.put("exitGateRepository", new ExitGateRepository());

        ObjectRegistry.put("parkingLotService",
                new ParkingLotService((ParkingLotRepository) ObjectRegistry.get("parkingLotRepository"),
                        (ParkingFloorRepository) ObjectRegistry.get("parkingFloorRepository"),
                        (EntryGateRepository) ObjectRegistry.get("entryGateRepository"),
                        (ExitGateRepository) ObjectRegistry.get("exitGateRepository")));
        ObjectRegistry.put("parkingLotController", new ParkingLotController(
                (ParkingLotService) ObjectRegistry.get("parkingLotService")));


        ObjectRegistry.put("spotRepository", new SpotRepository());
        ObjectRegistry.put("spotService", new SpotService(
                (ParkingFloorRepository) ObjectRegistry.get("parkingFloorRepository"),
                (SpotRepository) ObjectRegistry.get("spotRepository")));
        ObjectRegistry.put("spotController", new SpotController(
                (SpotService) ObjectRegistry.get("spotService")
        ));

        ObjectRegistry.put("ticketRepository", new TicketRepository());
        ObjectRegistry.put("spotAssignmentStrategy", new RandomSpotAssignmentStrategy());
        ObjectRegistry.put("ticketService", new TicketService(
                (TicketRepository) ObjectRegistry.get("ticketRepository"),
                (SpotAssignmentStrategy) ObjectRegistry.get("spotAssignmentStrategy"),
                (ParkingLotRepository) ObjectRegistry.get("parkingLotRepository")
        ));
        ObjectRegistry.put("ticketController", new TicketController(
                (TicketService) ObjectRegistry.get("ticketService")
        ));
        /*
        * If we see here, before creating object of TicketService, we must have object of
        * TicketRepository and RandomSpotAssignmentStrategy created. Similarly, before
        * creating object of TicketController we must have object of TicketService created.
        * It is kind of ordering and this is what we did in Topological sort. Here, we are
        * handling the object creation and them being only one for entire application but when
        * we will use Spring this part will be handled by container and the container uses
        * Topological sort behind the scenes when creating the objects.
        * */

        ParkingLotRequestDTO parkingLotRequestDTO = new ParkingLotRequestDTO();
        parkingLotRequestDTO.setName("IGI Airport Parking");
        parkingLotRequestDTO.setAddress("Delhi");
        parkingLotRequestDTO.setNumberOfEntryGates(5);
        parkingLotRequestDTO.setNumberOfExitGates(4);
        parkingLotRequestDTO.setNumberOfFloors(5);

        ParkingLotController parkingLotController =
                (ParkingLotController) ObjectRegistry.get("parkingLotController");
        ParkingLotResponseDTO parkingLotResponseDTO =
                parkingLotController.createParkingLot(parkingLotRequestDTO);

        System.out.println(parkingLotResponseDTO.getParkingLot());


        // Updating the address of Parking Lot:
        UpdateParkingLotRequestDTO updateParkingLotRequestDTO = new UpdateParkingLotRequestDTO();
        updateParkingLotRequestDTO.setAddress("Delhi Airport");
        UpdateParkingLotResponseDTO updateParkingLotResponseDTO =
                parkingLotController.updateParkingLot(1L, updateParkingLotRequestDTO);
        System.out.println(updateParkingLotResponseDTO.getParkingLot());

        // Creating Spot - For now only CAR and CAR_PREMIUM type:
        SpotController spotController = (SpotController) ObjectRegistry.get("spotController");
        List<CreateSpotRequestDto> createSpotRequestDtos = new ArrayList<>();
        for (int i=0; i<10; i++) {
            CreateSpotRequestDto createSpotRequestDto = null;
            if (i<=5) {
                createSpotRequestDto = new CreateSpotRequestDto();
                createSpotRequestDto.setSpotType(SpotType.CAR);

            } else {
                createSpotRequestDto = new CreateSpotRequestDto();
                createSpotRequestDto.setSpotType(SpotType.CAR_PREMIUM);
            }
            createSpotRequestDtos.add(createSpotRequestDto);
        }

        List<CreateSpotResponseDto> createSpotResponseDtos =
                spotController.createSpot(1L, createSpotRequestDtos);
        System.out.println(createSpotResponseDtos);


        // Generating the ticket:
        TicketController ticketController = (TicketController) ObjectRegistry.get("ticketController");
        Vehicle vehicle = new Vehicle();
        vehicle.setId(1L); // temporarily setting here - should be set in backend using VehicleRepository
        vehicle.setVehicleType(VehicleType.CAR);
        vehicle.setRegNum("XYU123");

        EntryGate entryGate = new EntryGate();
        entryGate.setId(1L);
        entryGate.setGateNumber(1);
        entryGate.setGateType(GateType.ENTRY);
        entryGate.setGateStatus(GateStatus.OPEN);

        GenerateTicketRequestDTO generateTicketRequestDTO = new GenerateTicketRequestDTO();
        generateTicketRequestDTO.setEntryGate(entryGate);
        generateTicketRequestDTO.setParkingLotId(1L);
        generateTicketRequestDTO.setVehicle(vehicle);
        generateTicketRequestDTO.setSpotType(SpotType.CAR_PREMIUM);
        GenerateTicketResponseDTO generateTicketResponseDTO =
                ticketController.generateTicket(generateTicketRequestDTO);

        /*
        * (Q1) Why are we passing SpotType explicitly when we are passing Vehicle - because we want to
        *      give flexibility for a vehicle owner to decide the type of Spot they want. Ex: A Car owner
        *      can choose for premium spot.
        * (Q2) Why are we passing EntryGate - because what if tomorrow we decide to assign spot that is
        *      closest to the entry gate.
        * */

        System.out.println(generateTicketResponseDTO);
    }
}

//Two ways to structure the code:
//1. Package By Layer:
//    Move all the models together
//    Move all the services together and so on.
//2. Package By Features:
//    Move all the controllers, services, repositories, and other dependencies of a feature inside
//    a package (like move all ParkingLot related stuffs in one package and so on).