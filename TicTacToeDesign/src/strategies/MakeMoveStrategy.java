package strategies;

import models.Board;
import models.Cell;
import models.Symbol;

public interface MakeMoveStrategy {
    Cell makeMove(Board board, Symbol symbol);
}
