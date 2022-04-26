package lab6.client.commands;

import lab6.client.ServerReceiver;
import lab6.common.Worker;
import lab6.common.dto.CommandRequestDto;
import lab6.common.dto.CommandResponseDto;
import lab6.common.dto.ShowCommandDto;

import java.util.List;

public class ShowCommand extends BaseCommand {

    /**
     * show command
     * show all obj from in Collection
     */

    @Override
    protected void Execute(List<String> params) {
        ParamsChecker.checkParams(0, params);

        ShowCommandDto dto = new ShowCommandDto();
        CommandRequestDto<ShowCommandDto> crd = new CommandRequestDto<>("show", dto);
        byte[] buf = serverCaller.sendToServer(transformer.Serialize(crd));

        //byte[] buf = ServerReceiver.receiveFromServer();
        Object obj = transformer.DeSerialize(buf);
        CommandResponseDto response = (CommandResponseDto) transformer.DeSerialize(buf);
        dto = (ShowCommandDto) response.getCommandArgs();


        List<Worker> workers = (List<Worker>) dto.getWorkers();
         if (workers.size() == 0) {
            System.out.println("Collection is empty");
        } else {
            for (Worker i : workers) {
                System.out.print(i);
            }
        }


    }
}
