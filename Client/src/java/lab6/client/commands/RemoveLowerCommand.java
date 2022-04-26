package lab6.client.commands;

import lab6.client.ServerReceiver;
import lab6.common.dto.CommandRequestDto;
import lab6.common.dto.CommandResponseDto;
import lab6.common.dto.RemoveLowerCommandDto;

import java.util.List;

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
    protected void Execute(List<String> params) {
        ParamsChecker.checkParams(0, params);
        RemoveLowerCommandDto dto = new RemoveLowerCommandDto();
        CommandRequestDto<RemoveLowerCommandDto> crd = new CommandRequestDto<>(getName(), dto);
        byte[] buf = serverCaller.sendToServer(transformer.Serialize(crd));

        //byte[] buf = ServerReceiver.receiveFromServer();

        CommandResponseDto response = (CommandResponseDto) transformer.DeSerialize(buf);

        System.out.println(response.getResponse());

    }
}
