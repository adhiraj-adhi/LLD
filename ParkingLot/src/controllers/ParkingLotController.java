package controllers;

import dtos.ParkingLotRequestDTO;
import dtos.ParkingLotResponseDTO;
import dtos.UpdateParkingLotRequestDTO;
import dtos.UpdateParkingLotResponseDTO;
import services.ParkingLotService;

public class ParkingLotController {

    private ParkingLotService parkingLotService;
    public ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }
    public ParkingLotResponseDTO createParkingLot(ParkingLotRequestDTO parkingLotDTO) {
        return parkingLotService.createParkingLot(parkingLotDTO.getName(),
                parkingLotDTO.getAddress(), parkingLotDTO.getNumberOfFloors(),
                parkingLotDTO.getNumberOfEntryGates(), parkingLotDTO.getNumberOfExitGates());
    }

    public UpdateParkingLotResponseDTO updateParkingLot(Long id,
            UpdateParkingLotRequestDTO updateParkingLotRequestDTO) {
        return parkingLotService.updateParkingLotService(id, updateParkingLotRequestDTO);
    }
}
