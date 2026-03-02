package repositories;

import models.ParkingFloor;

import java.util.HashMap;
import java.util.Map;

public class ParkingFloorRepository {
    Map<Long, ParkingFloor> parkingFloors = new HashMap<>();
    Long idCounter=0L;

    public ParkingFloor save(ParkingFloor parkingFloor) {
        idCounter+=1;
        parkingFloor.setId(idCounter);
        parkingFloors.put(idCounter, parkingFloor);
        return parkingFloor;
    }

    public ParkingFloor findById(Long floorId) {
        return parkingFloors.get(floorId);
    }

    public void update(ParkingFloor parkingFloor) {
        parkingFloors.put(parkingFloor.getId(), parkingFloor);
    }
}
