package lab6.client.commands;

import lab6.client.ServerReceiver;
import lab6.common.Transformer;
import lab6.common.Worker;
import lab6.common.dto.CommandRequestDto;
import lab6.common.dto.CommandResponseDto;
import lab6.common.dto.UpdateIdCommandDto;

import java.io.IOException;
import java.util.List;
import java.util.MissingFormatArgumentException;

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
    protected void Execute(List<String> params) throws IOException {
        ParamsChecker.checkParams(1, params);
        UpdateIdCommandDto dto = new UpdateIdCommandDto();
        try {
            int id = Integer.parseInt(params.get(0));
            dto.setWorkerId(id);
        } catch (Exception e) {
            throw  new MissingFormatArgumentException("param should be int");
        }

        CommandRequestDto<UpdateIdCommandDto> crd = new CommandRequestDto<>("updateid", dto);

        byte[] buf = serverCaller.sendToServer(transformer.Serialize(crd));

        CommandResponseDto responseObj = (CommandResponseDto) transformer.DeSerialize(buf);
        String response = responseObj.getResponse();
        System.out.println(response);
        if (response.equals("Correct id")) {
            Worker bum = new Worker();
            Utils.updateAll(bum);
            dto.setWorkerDto(Transformer.WorkerToWorkerDto(bum));

            buf = serverCaller.sendToServer(transformer.Serialize(crd));

            responseObj = (CommandResponseDto) transformer.DeSerialize(buf);
            response = responseObj.getResponse();
            System.out.println(response);
        }


    }
}
