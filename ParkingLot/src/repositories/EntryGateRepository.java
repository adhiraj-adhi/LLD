package repositories;

import models.EntryGate;

import java.util.HashMap;
import java.util.Map;

public class EntryGateRepository {
    private Map<Long, EntryGate> entryGates = new HashMap<>();
    private Long idCounter = 0L;
    public EntryGate save(EntryGate entryGate) {
        idCounter+=1;
        entryGate.setId(idCounter);
        entryGates.put(idCounter, entryGate);
        return entryGate;
    }
}
