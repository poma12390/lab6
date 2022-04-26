package lab6.common.exceptions;

public class ServerNotFoundException extends RuntimeException{
    public ServerNotFoundException(){
        super("Server not found");
    }
}
