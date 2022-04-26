package lab6.client.commands;

import lab6.client.ServerReceiver;
import lab6.common.dto.CommandRequestDto;
import lab6.common.dto.CommandResponseDto;
import lab6.common.dto.PrintFieldDescendingEndDateCommandDto;

import java.util.*;

public class PrintFieldDescendingEndDateCommand extends BaseCommand {
    @Override
    public String getName() {
        return "print_field_descending_end_date";
    }

    /**
     * printFieldDescendingDate command
     * show sorted endDate
     */

    @Override
    protected void Execute(List<String> params) {
        ParamsChecker.checkParams(0, params);
        PrintFieldDescendingEndDateCommandDto dto = new PrintFieldDescendingEndDateCommandDto();
        CommandRequestDto<PrintFieldDescendingEndDateCommandDto> crd = new CommandRequestDto<>(getName(), dto);

        byte[] buf = serverCaller.sendToServer(transformer.Serialize(crd));

        CommandResponseDto response = (CommandResponseDto) transformer.DeSerialize(buf);
        dto = (PrintFieldDescendingEndDateCommandDto) response.getCommandArgs();
        List<Date> responselist = dto.getDates();
        for (Date i : responselist){
            System.out.print(i + "; ");
        }
        System.out.println();
    }
}
