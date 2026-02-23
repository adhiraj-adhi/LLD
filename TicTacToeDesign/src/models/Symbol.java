package models;

public class Symbol {
    private char aChar;

    public Symbol(char aChar) {
        this.aChar = aChar;
    }

    @Override
    public String toString() {
        return aChar+"";
    }
}
