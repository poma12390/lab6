package lab6.common.exceptions;
/**
 * thrown when unable to create file
 */
public class CannotCreateFileException extends FileException{
    public CannotCreateFileException(){
        super("cannot create file");
    }
}
