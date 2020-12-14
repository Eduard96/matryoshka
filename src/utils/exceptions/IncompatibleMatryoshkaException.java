package utils.exceptions;

public class IncompatibleMatryoshkaException extends RuntimeException{
    public IncompatibleMatryoshkaException(String errorMessage) {
        super(errorMessage);
    }
}
