package strategies.botplayingstrategies;

import models.*;

import java.util.List;

public class BotEasyMoveStrategy implements BotPlayingStrategy {
    @Override
    public Move makeMove(Board board, Player player) {
        /*
        * In Easy Move Strategy let us say we make our bot to place the
        * symbol wherever it finds the first empty cell.
        * */

        for (List<Cell> rows: board.getCells()) {
            for (Cell cell: rows) {
                if (cell.isEmpty()) {
                    // Bot will make the Move:
                    Move move = new Move();
                    move.setCell(cell);
                    move.setPlayer(player);
                    return move;
                }
            }
        }

        return null;
    }
}
