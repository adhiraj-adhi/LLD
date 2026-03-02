package dtos;

import models.EntryGate;
import models.ExitGate;
import models.ParkingFloor;

import java.util.List;

public class UpdateParkingLotRequestDTO {
    private String name;
    private String address;
    private int numberOfFloors;
    private int numberOfEntryGates;
    private int numberOfExitGates;

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public void setNumberOfEntryGates(int numberOfEntryGates) {
        this.numberOfEntryGates = numberOfEntryGates;
    }

    public void setNumberOfExitGates(int numberOfExitGates) {
        this.numberOfExitGates = numberOfExitGates;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public int getNumberOfEntryGates() {
        return numberOfEntryGates;
    }

    public int getNumberOfExitGates() {
        return numberOfExitGates;
    }
}
