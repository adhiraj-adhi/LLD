import controllers.ParkingLotController;
import dtos.ParkingLotRequestDTO;
import dtos.ParkingLotResponseDTO;
import repositories.EntryGateRepository;
import repositories.ExitGateRepository;
import repositories.ParkingFloorRepository;
import repositories.ParkingLotRepository;
import services.ParkingLotService;

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

        ParkingLotRequestDTO parkingLotRequestDTO = new ParkingLotRequestDTO();
        parkingLotRequestDTO.setName("IGI Airport Parking");
        parkingLotRequestDTO.setAddress("Delhi Airport");
        parkingLotRequestDTO.setNumberOfEntryGates(5);
        parkingLotRequestDTO.setNumberOfExitGates(4);
        parkingLotRequestDTO.setNumberOfFloors(5);

        ParkingLotController parkingLotController =
                (ParkingLotController) ObjectRegistry.get("parkingLotController");
        ParkingLotResponseDTO parkingLotResponseDTO =
                parkingLotController.createParkingLot(parkingLotRequestDTO);

        System.out.println(parkingLotResponseDTO.getParkingLot());
    }
}

//Two ways to structure the code:
//1. Package By Layer:
//    Move all the models together
//    Move all the services together and so on.
//2. Package By Features:
//    Move all the controllers, services, repositories, and other dependencies of a feature inside
//    a package (like move all ParkingLot related stuffs in one package and so on).