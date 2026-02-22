package strategies;

import models.Board;
import models.Symbol;

public interface WinningStrategy {
    Symbol checkWin(Board board);
}
