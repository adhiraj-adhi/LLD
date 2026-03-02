package strategies.spotAssignmentStrategy;

import models.EntryGate;
import models.ParkingLot;
import models.Spot;
import models.SpotType;

public interface SpotAssignmentStrategy {
    Spot assignSpot(SpotType spotType, EntryGate entryGate, ParkingLot parkingLot);
}
