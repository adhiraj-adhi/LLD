package models;

public class Move {
    Cell cell;

    public Cell getCell() {
        return cell;
    }

    Player player;  // Player details who performed the move

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
