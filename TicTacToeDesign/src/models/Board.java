package models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Cell>> cells;

    public Board(int dimension) {
        this.cells = new ArrayList<>(dimension);
        for (int i=0; i<dimension; i++) {
            cells.add(new ArrayList<>(dimension));
        }
    }

    public List<List<Cell>> getCells() {
        return cells;
    }
}
