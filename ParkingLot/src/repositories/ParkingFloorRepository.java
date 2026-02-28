package repositories;

import models.ParkingFloor;

import java.util.HashMap;
import java.util.Map;

public class ParkingFloorRepository {
    Map<Long, ParkingFloor> parkingFloors = new HashMap<>();
    Long idCounter=0L;

    public ParkingFloor save(ParkingFloor parkingFloor) {
        parkingFloor.setId(idCounter);
        parkingFloors.put(idCounter, parkingFloor);
        return parkingFloor;
    }
}
