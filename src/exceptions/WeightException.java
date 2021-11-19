package exceptions;

public class WeightException extends IllegalAccessException{
    private static final String message="The weight cannot be negative or zero";

    public WeightException() {
        super(message);
    }

    public WeightException(String string) {
        super(string);
    }
}
