package models;

import java.util.List;

public class ParkingLot extends BaseModel {
    private String name;
    private List<ParkingFloor> parkingFloors;
    private List<EntryGate> entryGates;
    private List<ExitGate> exitGates;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public List<EntryGate> getEntryGates() {
        return entryGates;
    }

    public void setEntryGates(List<EntryGate> entryGates) {
        this.entryGates = entryGates;
    }

    public List<ExitGate> getExitGates() {
        return exitGates;
    }

    public void setExitGates(List<ExitGate> exitGates) {
        this.exitGates = exitGates;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
