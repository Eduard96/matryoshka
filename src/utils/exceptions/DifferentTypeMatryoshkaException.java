package utils.exceptions;

public class DifferentTypeMatryoshkaException extends IncompatibleMatryoshkaException{
    public DifferentTypeMatryoshkaException(String errorMessage) {
        super(errorMessage);
    }
}
