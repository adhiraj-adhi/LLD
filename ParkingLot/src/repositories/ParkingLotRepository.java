package repositories;

import models.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {
    private Map<Long, ParkingLot> parkingLots = new HashMap<>();
    private Long idCounter = 0L;


    public ParkingLot save(ParkingLot parkingLot) {
        idCounter+=1;
        parkingLot.setId(idCounter);
        parkingLots.put(idCounter, parkingLot);
        return parkingLot;
    }
}
