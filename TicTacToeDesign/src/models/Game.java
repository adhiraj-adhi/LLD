package models;

import strategies.WinningStrategy;

import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<WinningStrategy> winningStrategies;
    int indexOfLastPlayerWhoMoved;
    private GameState gameState;
    private Winner winner;
    public static void main(String[] args) {

    }
}
