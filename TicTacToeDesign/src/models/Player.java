package models;

public abstract class Player {
    private String name;
    private PlayerType playerType;

    public PlayerType getPlayerType() {
        return playerType;
    }

    private Symbol symbol;

    public Player(PlayerType playerType, Symbol symbol) {
        this.playerType = playerType;
        this.symbol = symbol;
    }
}