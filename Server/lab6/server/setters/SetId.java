package lab6.server.setters;

import lab6.common.Worker;
import lab6.common.exceptions.DublicateIdException;
import lab6.common.exceptions.EmptyStringException;

import static lab6.server.commands.Commands.getIds;

public class SetId {
    public static void setId(String id, Worker bum) throws EmptyStringException, DublicateIdException {
        if (id.isEmpty()) {
            throw new EmptyStringException();
        } else {
            int f = Integer.parseInt(id);
            if (f < 0) {
                throw new EmptyStringException();
            } else {
                if (getIds().contains(f)){
                    throw new DublicateIdException();
                }
                else{
                    bum.setId(f);
                    getIds().add(f);
                }

            }
        }
    }
}
