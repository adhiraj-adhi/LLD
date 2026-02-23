package models;

import exceptions.InvalidMoveException;

public abstract class Player {
    private String name;
    private PlayerType playerType;

    private Symbol symbol;

    public Player(PlayerType playerType, Symbol symbol) {
        this.playerType = playerType;
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }
    public Symbol getSymbol() {
        return symbol;
    }
    public abstract Move makeMove(Board board, Player player) throws InvalidMoveException;
}