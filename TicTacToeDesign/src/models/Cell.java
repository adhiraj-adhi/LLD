package models;

public class Cell {
    private int row;
    private int col;

    Cell(int r, int c) {
        this.row = r;
        this.col = c;
    }
    private Symbol symbol;

    public Symbol getSymbol() {
        return symbol;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }
    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public boolean isEmpty() {
        return symbol==null;
    }
}
