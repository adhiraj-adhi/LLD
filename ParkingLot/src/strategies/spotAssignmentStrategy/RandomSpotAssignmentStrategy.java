package strategies.spotAssignmentStrategy;

import models.*;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy {
    @Override
    public Spot assignSpot(SpotType spotType, EntryGate entryGate, ParkingLot parkingLot) {
        for(ParkingFloor parkingFloor: parkingLot.getParkingFloors()) {
            for (Spot spot: parkingFloor.getSpots()) {
                if (spot.getSpotStatus().equals(SpotStatus.AVAILABLE) && spot.getSpotType().equals(spotType)) {
                    return spot;
                }
            }
        }
        return null;
    }
}
