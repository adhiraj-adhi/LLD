package factories.botplayingstrategyfactory;

import models.BotDifficultyLevel;
import strategies.botplayingstrategies.BotEasyMoveStrategy;
import strategies.botplayingstrategies.BotHardMoveStrategy;
import strategies.botplayingstrategies.BotMediumMoveStrategy;
import strategies.botplayingstrategies.BotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public BotPlayingStrategy createPlayingStrategyForDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        return switch (botDifficultyLevel) {
            case EASY -> new BotEasyMoveStrategy();
            case MEDIUM -> new BotMediumMoveStrategy();
            case HARD -> new BotHardMoveStrategy();
        };
    }
}
