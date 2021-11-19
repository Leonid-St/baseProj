package exceptions;

public class WrongFoodException extends IllegalStateException{

    private static final String message = "wrong food";

    public WrongFoodException() {

        super(message);
    }

    public WrongFoodException(String string) {
        super(string);
    }

}
