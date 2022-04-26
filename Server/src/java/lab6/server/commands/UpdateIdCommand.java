package lab6.server.commands;

import lab6.common.Transformer;
import lab6.common.Worker;
import lab6.common.dto.CommandRequestDto;
import lab6.common.dto.CommandResponseDto;
import lab6.common.dto.UpdateIdCommandDto;
import lab6.server.ClientCaller;

import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedHashSet;

public class UpdateIdCommand extends BaseCommand {
    @Override
    protected int getCommandParamsCount() {
        return 1;
    }

    /**
     * update command
     *
     * @param params id Worker to update
     *               update all stats
     */
    @Override
    protected void Execute(CommandRequestDto<? extends Serializable> params, LinkedHashSet<Worker> set, Transformer transformer, ClientCaller clientCaller) throws IOException {
        UpdateIdCommandDto updateIdCommandDto = (UpdateIdCommandDto) params.getCommandArgs();
        CommandResponseDto dto = new CommandResponseDto(updateIdCommandDto);
        if (updateIdCommandDto.getWorkerDto() != null) {
            Worker newbum = Transformer.WorkerDtoToWorker(updateIdCommandDto.getWorkerDto());
            Worker bum = Commands.getWorkerById(updateIdCommandDto.getWorkerId());
            Transformer.WorkerToWorker(bum, newbum);
            dto.setResponse("Success");
            clientCaller.sendToClient(transformer.serialize(dto));
        } else {
            if (Commands.getIds().contains(updateIdCommandDto.getWorkerId())) {
                dto.setResponse("Correct id");
                clientCaller.sendToClient(transformer.serialize(dto));
            } else {dto.setResponse("UnCorrect Id");
                clientCaller.sendToClient(transformer.serialize(dto));}

        }
    }
}
