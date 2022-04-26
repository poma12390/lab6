package lab6.server.commands;

import lab6.common.Transformer;
import lab6.common.Worker;
import lab6.common.dto.AddIfMinCommandDto;
import lab6.common.dto.CommandRequestDto;
import lab6.common.dto.CommandResponseDto;
import lab6.common.dto.WorkerDto;
import lab6.server.ClientCaller;

import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedHashSet;

import static lab6.server.commands.Commands.makeId;

public class AddIfMinCommand extends BaseCommand {
    @Override
    public String getName() {
        return "add_If_min";
    }

    /**
     * addIfMin command
     * add new Worker if it's min in coll
     */

    @Override
    protected void Execute(CommandRequestDto<? extends Serializable> params, LinkedHashSet<Worker> set, Transformer transformer, ClientCaller clientCaller) throws IOException {
        AddIfMinCommandDto addIfMinCommandDto = (AddIfMinCommandDto) params.getCommandArgs();
        WorkerDto workerDto = addIfMinCommandDto.getBum();
        Worker bum = Transformer.WorkerDtoToWorker(workerDto);
        CommandResponseDto dto = new CommandResponseDto(addIfMinCommandDto);
        if (set.size() == 0) {
            bum = makeId(bum);
            set.add(bum);
        } else {
            Worker min = set.stream().min(Worker::compareTo).get(); //stream Api
            if (bum.compareTo(min) < 0) {
                bum = makeId(bum);
                set.add(bum);
                dto.setResponse("success");

            } else {
                dto.setResponse("not min element");
            }
        } clientCaller.sendToClient(transformer.serialize(dto));

    }
}
