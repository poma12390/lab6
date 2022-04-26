package lab6.server.commands;

import lab6.common.Transformer;
import lab6.common.Worker;
import lab6.common.dto.AddCommandDto;
import lab6.common.dto.CommandRequestDto;
import lab6.common.dto.CommandResponseDto;
import lab6.common.dto.WorkerDto;
import lab6.server.ClientCaller;

import java.io.Serializable;
import java.util.LinkedHashSet;

public class AddCommand extends BaseCommand {
    /**
     * add command
     * add new Worker and set stats
     * */

    @Override
    protected void Execute(CommandRequestDto<? extends Serializable> params, LinkedHashSet<Worker> set, Transformer transformer, ClientCaller clientCaller) {
        AddCommandDto addCommandDto = (AddCommandDto) params.getCommandArgs();
        WorkerDto workerDto = addCommandDto.getBum();
        Worker bum = Transformer.WorkerDtoToWorker(workerDto);
        lab6.server.commands.Commands.makeId(bum);
        set.add(bum);
        CommandResponseDto dto = new CommandResponseDto(addCommandDto);
        dto.setResponse("success");
        clientCaller.sendToClient(transformer.serialize(dto));
    }
}
