package models;

import java.util.Map;

public class DisplayBoard {
    Map<SpotType, Integer> emptySpotCount;

    public Map<SpotType, Integer> getEmptySpotCount() {
        return emptySpotCount;
    }

    public void setEmptySpotCount(Map<SpotType, Integer> emptySpotCount) {
        this.emptySpotCount = emptySpotCount;
    }
}
