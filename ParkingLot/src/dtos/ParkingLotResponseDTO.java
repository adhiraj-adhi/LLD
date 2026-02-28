package dtos;

import models.ParkingLot;

public class ParkingLotResponseDTO {
    private ParkingLot parkingLot;  // It doesn't happen this way in real, but for time-being

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }
}
