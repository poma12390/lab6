package lab6.server.commands;

import lab6.common.Transformer;
import lab6.common.Worker;
import lab6.common.dto.ClearCommandDto;
import lab6.common.dto.CommandRequestDto;
import lab6.common.dto.CommandResponseDto;
import lab6.server.ClientCaller;

import java.io.Serializable;
import java.util.LinkedHashSet;

public class ClearCommand extends BaseCommand {
    /**
     * clear command
     * clear collection
     */

    @Override
    protected void Execute(CommandRequestDto<? extends Serializable> params, LinkedHashSet<Worker> set, Transformer transformer, ClientCaller clientCaller) {

        set.clear();
        CommandResponseDto dto = new CommandResponseDto(new ClearCommandDto());
        dto.setResponse("success");
        clientCaller.sendToClient(transformer.serialize(dto));
    }
}
