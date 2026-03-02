package dtos;

import models.Spot;

public class CreateSpotResponseDto {
    private Spot spot;

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }
}
