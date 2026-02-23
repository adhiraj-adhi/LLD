package controllers;

import exceptions.EmptyMovesUndoOperationException;
import exceptions.InvalidMoveException;
import exceptions.MultipleBotsException;
import models.Game;
import models.GameState;
import models.Player;
import strategies.gamewinningstrategies.WinningStrategy;

import java.util.List;

/**
 * Client will interact with Game Controller and Game Controller will interact with the Game.
 * GameController class will have the methods that a client will require to play the Game. Here,
 * it can be: creating game, making move, and undo. It can also be to get the winner and displaying
 * the board.
 */

public class GameController {
    public Game createGame(List<Player> players, List<WinningStrategy> winningStrategies, int dimension) {
        try {
            return new Game.Builder()
                    .addPlayers(players)
                    .addWinningStrategies(winningStrategies)
                    .setDimension(dimension)
                    .build();
        } catch (MultipleBotsException e) {
            System.out.println("Something went wrong");
        }
        return null;
    }

    public void makeMove(Game game) {
        game.makeMove();
    }

    public void undo(Game game) throws EmptyMovesUndoOperationException {
        game.undo();
    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }

    public GameState getGameState(Game game) {
        return game.getGameState();
    }

    public void displayBoard(Game game) {
        game.getBoard().display();
    }
}
