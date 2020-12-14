package utils.exceptions;

public class MatryoshkaNotEmptyException extends RuntimeException{
    public MatryoshkaNotEmptyException(String errorMessage) {
        super(errorMessage);
    }
}
