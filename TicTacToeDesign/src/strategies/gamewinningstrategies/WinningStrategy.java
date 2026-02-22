package strategies.gamewinningstrategies;

import models.Board;
import models.Player;

public interface WinningStrategy {
//    Symbol checkWin(Board board);
    boolean checkIfWon(Board board, Player player);
}
