package qa.com;

public class MovementException extends Exception{
    public MovementException(String exceptionMessage) {
        super(exceptionMessage);
    }
    public MovementException() {
        super();
    }
}
