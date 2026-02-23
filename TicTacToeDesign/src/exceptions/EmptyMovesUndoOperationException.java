package exceptions;

public class EmptyMovesUndoOperationException extends Exception {
    public EmptyMovesUndoOperationException(String error) {
        super(error);
    }
}
