package models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Cell>> cells;

    public Board(int dimension) {
        this.cells = new ArrayList<>();

        for (int i = 0; i < dimension; i++) {
            List<Cell> row = new ArrayList<>();

            for (int j = 0; j < dimension; j++) {
                row.add(new Cell(i, j));
            }

            cells.add(row);
        }
    }

    public List<List<Cell>> getCells() {
        return cells;
    }

    public Cell getCells(int row, int col) {
        return cells.get(row).get(col);
    }

    public void display() {
        for (List<Cell> row : cells) {
            for (Cell cell : row) {
                if (cell.getSymbol() != null) {
                    System.out.print("| " + cell.getSymbol() + " |");
                } else {
                    System.out.print("|   |");
                }
            }
            System.out.println();
        }
    }
}
