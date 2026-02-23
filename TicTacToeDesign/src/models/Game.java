package models;

import exceptions.EmptyMovesUndoOperationException;
import exceptions.InvalidMoveException;
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

    public GameState getGameState() {
        return gameState;
    }
    public Board getBoard() {
        return board;
    }

    public Player getWinner() {
        return winner;
    }

    private Game() {
        this.players = new ArrayList<>();
        this.winningStrategies = new ArrayList<>();
        this.indexOfLastPlayerWhoMoved = -1;
        this.gameState = GameState.RUNNING;
        this.moves = new ArrayList<>();
    }


    // Making the move in game:
    public void makeMove() {
        if (!this.gameState.equals(GameState.DRAW)) {
            int totalPossibleMoves = board.getCells().size() * board.getCells().size();

            // Whenever this method is called, indexOfLastPlayerWhoMoved will be updated and the
            // player will make move:
            indexOfLastPlayerWhoMoved = (indexOfLastPlayerWhoMoved + 1) % (this.players.size());

            Player currentPlayer = this.players.get(this.indexOfLastPlayerWhoMoved);
            Move move = null;
            try {
                move = currentPlayer.makeMove(this.board, currentPlayer);
            } catch (InvalidMoveException e) {
                throw new RuntimeException(e);
            }

            move.getCell().setSymbol(currentPlayer.getSymbol());  //  setting the cell on board

            /* After every move, we will do two things:
               1. We will store the move in List<Move> to support undo
               2. We will check if there is a winner by any game winning strategy
            */

            this.moves.add(move);
            for (WinningStrategy winningStrategy : this.winningStrategies) {
                if (winningStrategy.checkIfWon(this.board, currentPlayer)) {
                    this.gameState = GameState.WON;
                    this.winner = currentPlayer;
                    return;
                }
            }

            if (this.moves.size() == (this.board.getCells().size()) * (this.board.getCells().size())) {
                this.gameState = GameState.DRAW;
            }
        }
    }

    public boolean undo() throws EmptyMovesUndoOperationException {
        if (this.moves.isEmpty()) {
            throw new EmptyMovesUndoOperationException("There is no move to perform undo");
        }
        Move lastMove = this.moves.remove(this.moves.size()-1);
        lastMove.getCell().setSymbol(null);

        // Also, we will need to reduce the indexOfLastPlayerWhoMoved to move to previous player (We should not go to -ve index):
        indexOfLastPlayerWhoMoved = ((indexOfLastPlayerWhoMoved-1) + this.players.size())%this.players.size();
        return true;
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

        public Builder() {
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