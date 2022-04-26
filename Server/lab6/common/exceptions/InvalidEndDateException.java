package lab6.common.exceptions;

public class InvalidEndDateException extends InvalidDataException{
    public InvalidEndDateException() {
        super("End Date should be > start date");
    }
}
