package dtos;

import models.SpotStatus;
import models.SpotType;

public class CreateSpotRequestDto {
    private SpotType spotType;

    public SpotType getSpotType() {
        return spotType;
    }

    public void setSpotType(SpotType spotType) {
        this.spotType = spotType;
    }
}
