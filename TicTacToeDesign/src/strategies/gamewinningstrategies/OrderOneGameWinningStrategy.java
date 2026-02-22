package strategies.gamewinningstrategies;

import models.Board;
import models.Player;

public class OrderOneGameWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkIfWon(Board board, Player player) {
        return false;
    }
}
