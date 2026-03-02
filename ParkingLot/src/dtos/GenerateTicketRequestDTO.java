package dtos;

import models.EntryGate;
import models.ParkingLot;
import models.SpotType;
import models.Vehicle;

public class GenerateTicketRequestDTO {
    private Vehicle vehicle;
//    private Operator operator;  // Can be get from Entry gate - so no need to explicitly accept this
    // private Date entryTime;  -> No need as it will be current time of system
    private EntryGate entryGate;
    private Long parkingLotId;  // to set the address

    private SpotType spotType;

    public Long getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(Long parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public void setSpotType(SpotType spotType) {
        this.spotType = spotType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public EntryGate getEntryGate() {
        return entryGate;
    }

    public void setEntryGate(EntryGate entryGate) {
        this.entryGate = entryGate;
    }
}
