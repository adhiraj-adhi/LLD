package models;

import factories.botplayingstrategyfactory.BotPlayingStrategyFactory;
import strategies.botplayingstrategies.BotPlayingStrategy;

public class BotPlayer extends Player {
    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public BotPlayer(Symbol symbol, BotDifficultyLevel botDifficultyLevel) {
        super(PlayerType.BOT, symbol);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = new BotPlayingStrategyFactory().createPlayingStrategyForDifficultyLevel(
                botDifficultyLevel
        );
    }

    @Override
    public Move makeMove(Board board, Player player) {
        return this.botPlayingStrategy.makeMove(board, player);
    }
}
