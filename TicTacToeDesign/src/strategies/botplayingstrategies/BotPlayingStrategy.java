package strategies.botplayingstrategies;

import models.Board;
import models.Move;
import models.Player;
import models.Symbol;

public interface BotPlayingStrategy {
    Move makeMove(Board board, Player player);
}
