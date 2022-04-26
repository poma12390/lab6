package lab6.server.commands;

import lab6.common.Transformer;
import lab6.common.Worker;
import lab6.common.dto.CommandRequestDto;
import lab6.common.dto.CommandResponseDto;
import lab6.common.exceptions.EmptyCollectionException;
import lab6.server.ClientCaller;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedHashSet;


public class RemoveLowerCommand extends BaseCommand {
    @Override
    public String getName() {
        return "remove_lower";
    }

    /**
     * removeLower command
     * remove lower element from collection
     */

    @Override
    protected void Execute(CommandRequestDto<? extends Serializable> params, LinkedHashSet<Worker> set, Transformer transformer, ClientCaller clientCaller) {
        CommandResponseDto dto = new CommandResponseDto(params.getCommandArgs());
        if (set.size() == 0) {
            dto.setResponse("Collection is empty");
            clientCaller.sendToClient(transformer.serialize(dto));
            throw new EmptyCollectionException();
        }
        Worker min = Collections.min(set);
        set.remove(min);

        dto.setResponse("success");
        clientCaller.sendToClient(transformer.serialize(dto));
    }
}
