package services;


import dtos.ParkingLotResponseDTO;
import models.EntryGate;
import models.ExitGate;
import models.ParkingFloor;
import models.ParkingLot;
import repositories.EntryGateRepository;
import repositories.ExitGateRepository;
import repositories.ParkingFloorRepository;
import repositories.ParkingLotRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingLotService {
    private ParkingLotRepository parkingLotRepository;
    private ParkingFloorRepository parkingFloorRepository;
    private EntryGateRepository entryGateRepository;
    private ExitGateRepository exitGateRepository;

    public ParkingLotService(ParkingLotRepository parkingLotRepository,
                             ParkingFloorRepository parkingFloorRepository,
                             EntryGateRepository entryGateRepository,
                             ExitGateRepository exitGateRepository) {
        this.parkingLotRepository = parkingLotRepository;
        this.parkingFloorRepository = parkingFloorRepository;
        this.entryGateRepository = entryGateRepository;
        this.exitGateRepository = exitGateRepository;
    }
    public ParkingLotResponseDTO createParkingLot(String name, String address,
                                                  int numberOfFloors, int numberOfEntryGates,
                                                  int numberOfExitGates) {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setName(name);
        parkingLot.setAddress(address);

        List<ParkingFloor> parkingFloors = new ArrayList<>();
        for (int i=0; i<numberOfFloors; i++) {
            parkingFloors.add(new ParkingFloor());
        }
        // we will be requiring to save the Floors via floor repository so:
        List<ParkingFloor> savedParkingFloors = parkingFloors.stream()
                .map(floor -> parkingFloorRepository.save(floor)).toList();
        parkingLot.setParkingFloors(savedParkingFloors);

        List<EntryGate> entryGates = new ArrayList<>();
        for (int i=0; i<numberOfEntryGates; i++) {
            entryGates.add(new EntryGate());
        }
        // we will be requiring to save the EntryGates via corresponding repository so:
        List<EntryGate> savedEntryGates = entryGates.stream()
                .map(entryGate -> entryGateRepository.save(entryGate))
                .collect(Collectors.toList());
        parkingLot.setEntryGates(savedEntryGates);

        List<ExitGate> exitGates = new ArrayList<>();
        for (int i=0; i<numberOfExitGates; i++) {
            exitGates.add(new ExitGate());
        }
        // we will be requiring to save the ExitGates via corresponding repository so:
        List<ExitGate> savedExitGates = exitGates.stream()
                .map(exitGate -> exitGateRepository.save(exitGate))
                .collect(Collectors.toList());
        parkingLot.setExitGates(savedExitGates);

        ParkingLot savedParkingLot = parkingLotRepository.save(parkingLot);
        ParkingLotResponseDTO parkingLotResponseDTO = new ParkingLotResponseDTO();
        parkingLotResponseDTO.setParkingLot(savedParkingLot);

       return parkingLotResponseDTO;
    }
}
