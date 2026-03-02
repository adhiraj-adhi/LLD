package dtos;

import models.ParkingLot;

public class UpdateParkingLotResponseDTO {
    private ParkingLot parkingLot;  // Temporarily

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }
}
