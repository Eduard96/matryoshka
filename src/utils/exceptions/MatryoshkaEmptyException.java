package utils.exceptions;

public class MatryoshkaEmptyException extends RuntimeException{
    public MatryoshkaEmptyException(String errorMessage) {
        super(errorMessage);
    }
}
