package repositories;

import models.Spot;

import java.util.HashMap;
import java.util.Map;

public class SpotRepository {
    private Map<Long, Spot> spots = new HashMap<>();
    private Long idCounter = 0L;

    public Spot save(Spot spot) {
        idCounter+=1;
        spot.setId(idCounter);
        spots.put(idCounter, spot);
        return spot;
    }
}
