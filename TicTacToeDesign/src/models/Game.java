package models;

import strategies.gamewinningstrategies.WinningStrategy;

import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<WinningStrategy> winningStrategies;
    int indexOfLastPlayerWhoMoved;
    private GameState gameState;
    private Player winner;
    private List<Move> moves; // to store the list of moves performed
}
