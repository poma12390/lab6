package lab6.common.exceptions;

public class EmptyPathException extends FileException{
    public EmptyPathException(){
        super("path is empty");
    }
}
