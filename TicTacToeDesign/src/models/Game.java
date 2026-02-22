package models;

import exceptions.MultipleBotsException;
import strategies.gamewinningstrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<WinningStrategy> winningStrategies;
    int indexOfLastPlayerWhoMoved;
    private GameState gameState;
    private Player winner;
    private List<Move> moves; // to store the list of moves performed
    private Game() {
        this.players = new ArrayList<>();
        this.winningStrategies = new ArrayList<>();
        this.indexOfLastPlayerWhoMoved = -1;
        this.gameState = GameState.RUNNING;
        this.moves = new ArrayList<>();
    }


    // The very first step will be building the Game to play. Using Builder pattern:
    public static class Builder {
        /*
        * Ideally, this Builder class should have all the attributes of Game class but
        * it doesn't make to take input of board, indexOfLastPlayerWhoMoved, gameState,
        * winner, moves from client i.e. who is starting the game. Instead, we can ask
        * client to enter players detail, winningStrategies they want, and dimension of board.
        * */
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;
        private int dimension; // Dimension of the board

        Builder() {
            this.players = new ArrayList<>();
            this.winningStrategies = new ArrayList<>();
        }

        // To add player one by one to our players list:
        public Builder addPlayer(Player player) {
            this.players.add(player);
            return this;
        }

        // To add players as a list into our players list:
        public Builder addPlayers(List<Player> players) {
            this.players.addAll(players);
            return this;
        }

        // To add game winning strategy one by one to our winningStrategies list:
        public Builder addWinningStrategy(WinningStrategy winningStrategy) {
            this.winningStrategies.add(winningStrategy);
            return this;
        }

        // To add game winning strategy as a list into our winningStrategies list:
        public Builder addWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies.addAll(winningStrategies);
            return this;
        }

        // To get the dimension:
        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        // Validation and creation of Game object:
        public Game build() throws MultipleBotsException {
            // Validations:
            // Validation1: We can not have multiple bot players:
            if (!checkBotCount(players)) {
                throw new MultipleBotsException("A game can not have more than one bot");
            }

            /* We can have other validations like: No duplicate players, Player Count >= 2,
               dimensions>=3, and so on. */

            // Object Creation:
            Game game = new Game();
            game.players.addAll(this.players);
            game.winningStrategies.addAll(this.winningStrategies);
            game.board = new Board(this.dimension);
            return game;
        }

        private boolean checkBotCount(List<Player> players) {
            int count = 0;
            for (Player player: players) {
                if (player.getPlayerType().equals(PlayerType.BOT)) count++;
            }

            return count<=1;
        }
    }
}
