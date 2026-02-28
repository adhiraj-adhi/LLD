package repositories;

import models.ExitGate;

import java.util.HashMap;
import java.util.Map;

public class ExitGateRepository {
    private Map<Long, ExitGate> exitGates = new HashMap<>();
    private Long idCounter = 0L;
    public ExitGate save(ExitGate exitGate) {
        idCounter+=1;
        exitGate.setId(idCounter);
        exitGates.put(idCounter, exitGate);
        return exitGate;
    }
}
