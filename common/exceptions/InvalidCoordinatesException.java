package lab6.common.exceptions;

/**
 * thrown when unable to create file
 */
public class InvalidCoordinatesException extends InvalidDataException{
    public InvalidCoordinatesException(){
        super("bad x or y");
    }
}
