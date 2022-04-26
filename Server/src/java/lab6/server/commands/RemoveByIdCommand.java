package lab6.server.commands;

import lab6.common.Transformer;
import lab6.common.Worker;
import lab6.common.dto.CommandRequestDto;
import lab6.common.dto.CommandResponseDto;
import lab6.common.dto.RemoveByIdCommandDto;
import lab6.server.ClientCaller;

import java.io.Serializable;
import java.util.LinkedHashSet;

public class RemoveByIdCommand extends BaseCommand {
    @Override
    public String getName() {
        return "remove_by_id";
    }

    @Override
    protected int getCommandParamsCount() {
        return 1;
    }

    /**
     * removeById command
     * @param params id of worker to delete
     * delete worker from collections with id
     */

    @Override
    protected void Execute(CommandRequestDto<? extends Serializable> params, LinkedHashSet<Worker> set, Transformer transformer, ClientCaller clientCaller) {
            RemoveByIdCommandDto removeByIdCommandDto = (RemoveByIdCommandDto) params.getCommandArgs();
            int id = removeByIdCommandDto.getId();
            long count = (set.stream().filter((p) -> p.getId() == id).count());
            set.removeIf(worker -> worker.getId() == id);
            removeByIdCommandDto.setCount(count);
            CommandResponseDto dto = new CommandResponseDto(removeByIdCommandDto);
            clientCaller.sendToClient(transformer.serialize(dto));
        }
}


