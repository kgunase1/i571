
public class SyntaxError extends Exception {
    public SyntaxError(String errorMessage) {
        super(errorMessage);
        System.err.println("Error: " + errorMessage);
    }
}
