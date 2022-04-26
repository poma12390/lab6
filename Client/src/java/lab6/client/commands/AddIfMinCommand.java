package lab6.client.commands;

import lab6.client.ServerReceiver;
import lab6.common.Transformer;
import lab6.common.Worker;
import lab6.common.dto.AddIfMinCommandDto;
import lab6.common.dto.CommandRequestDto;
import lab6.common.dto.CommandResponseDto;
import lab6.common.dto.WorkerDto;

import java.io.IOException;
import java.util.List;

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
    protected void Execute(List<String> params) throws IOException {
        ParamsChecker.checkParams(0, params);
        Worker bum = new Worker();
        Utils.updateAll(bum);

        AddIfMinCommandDto dto= new AddIfMinCommandDto();
        WorkerDto man = Transformer.WorkerToWorkerDto(bum);
        dto.setBum(man);
        CommandRequestDto<AddIfMinCommandDto> crd = new CommandRequestDto<>("add_if_min", dto);

        byte[] buf = serverCaller.sendToServer(transformer.Serialize(crd));

        CommandResponseDto response = (CommandResponseDto) transformer.DeSerialize(buf);
        System.out.println(response.getResponse());

    }
}
