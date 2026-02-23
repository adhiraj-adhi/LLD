import controllers.GameController;
import models.*;
import strategies.gamewinningstrategies.OrderOneGameWinningStrategy;
import strategies.gamewinningstrategies.WinningStrategy;

import java.util.List;

// Assuming this is our Client - This class is to simulate client behavior
public class GameSimulator {
    public static void main(String[] args) {
        int dimension = 3;
        Player player1 = new HumanPlayer(new Symbol('X'));
        Player player2 = new BotPlayer(new Symbol('O'), BotDifficultyLevel.EASY);

        WinningStrategy winningStrategy1 = new OrderOneGameWinningStrategy();

        GameController gameController = new GameController();
        Game game = gameController.createGame(List.of(player1, player2), List.of(winningStrategy1), dimension);

        gameController.displayBoard(game);
        while (gameController.getGameState(game).equals(GameState.RUNNING)) {
            System.out.println("Make the move: ");
            gameController.makeMove(game);
            gameController.displayBoard(game);
        }

        if (gameController.getGameState(game).equals(GameState.DRAW)) {
            System.out.println("It is a draw");
        }
    }
}