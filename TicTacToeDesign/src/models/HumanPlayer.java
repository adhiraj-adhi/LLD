package models;

import exceptions.InvalidMoveException;

import java.util.Scanner;

public class HumanPlayer extends Player {
    public HumanPlayer(Symbol symbol) {
        super(PlayerType.HUMAN, symbol);
    }

    @Override
    public Move makeMove(Board board, Player player) throws InvalidMoveException {
        System.out.println("Enter the row number starting from 1 where you want to make move");
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        System.out.println("Enter the column number starting from 1 where you want to make move");
        int col = scanner.nextInt();

        if (board.getCells(row-1, col-1).getSymbol()==null) { // Do not allow to override move
            Move move = new Move();
            move.setCell(board.getCells(row - 1, col - 1));
            move.setPlayer(player);
            return move;
        } else {
            throw new InvalidMoveException("Invalid Move");
        }
    }
}
