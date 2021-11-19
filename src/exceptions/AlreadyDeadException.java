package exceptions;

public class AlreadyDeadException extends IllegalStateException {
    private static final String message="already dead";

    public AlreadyDeadException(){
        super(message);
    }
    public AlreadyDeadException(String string){
        super(string);
    }
}
