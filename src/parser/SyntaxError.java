package parser;

public class SyntaxError extends Exception {
    public SyntaxError(String errorMessage) {
        super(errorMessage);
    }
}
