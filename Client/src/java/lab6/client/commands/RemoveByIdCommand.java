package lab6.client.commands;

import lab6.client.ServerReceiver;
import lab6.common.dto.CommandRequestDto;
import lab6.common.dto.CommandResponseDto;
import lab6.common.dto.RemoveByIdCommandDto;

import java.util.List;
import java.util.MissingFormatArgumentException;

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
    protected void Execute(List<String> params) {
        ParamsChecker.checkParams(1, params);
        RemoveByIdCommandDto dto = new RemoveByIdCommandDto();
        CommandRequestDto<RemoveByIdCommandDto> crd = new CommandRequestDto<>(getName(), dto);

        try {
            int id = Integer.parseInt(params.get(0));
            dto.setId(id);
        } catch (Exception e) {
            throw  new MissingFormatArgumentException("param should be int");
        }

        byte[] buf = serverCaller.sendToServer(transformer.Serialize(crd));

        CommandResponseDto response = (CommandResponseDto) transformer.DeSerialize(buf);

        dto = (RemoveByIdCommandDto) response.getCommandArgs();
        long count = dto.getCount();
        System.out.println("Deleted " +count + " elements");

    }
}
