package lab6.server.commands;

import lab6.common.Transformer;
import lab6.common.Worker;
import lab6.common.dto.CommandRequestDto;
import lab6.common.dto.CommandResponseDto;
import lab6.common.dto.InfoCommandDto;
import lab6.server.ClientCaller;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class InfoCommand extends BaseCommand {
    /**
     * info command
     * command to show info aд
     */

    @Override
    protected void Execute(CommandRequestDto<? extends Serializable> params, LinkedHashSet<Worker> set, Transformer transformer, ClientCaller clientCaller) {
        String response = "";
        int size = (int) set.stream().count(); //help me
        if (size == 0){
            response = response + "empty collection";
        }
        else{
            Iterator<Worker> it = set.iterator();
            Worker p1 = it.next();
            response = response + "Collection size " + size + "\r\n";
            response = response + "Type - Worker \r\n";
            response = response + "Created date - " + p1.getCreationDate();

        }
        CommandResponseDto dto = new CommandResponseDto(new InfoCommandDto());
        dto.setResponse(response);
        clientCaller.sendToClient(transformer.serialize(dto));
    }
}
