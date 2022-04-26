package lab6.server.setters;

import lab6.common.Worker;
import lab6.common.exceptions.EmptyStringException;

public class SetName {
    public static void setname(String name, Worker bum) throws EmptyStringException {
        if (name.isEmpty()) {
            throw new EmptyStringException();
        } else {
            bum.setName(name);
        }
    }
}
