package lab6.client.commands;

import lab6.client.ServerReceiver;
import lab6.common.Transformer;
import lab6.common.Worker;
import lab6.common.dto.AddCommandDto;
import lab6.common.dto.CommandRequestDto;
import lab6.common.dto.CommandResponseDto;
import lab6.common.dto.WorkerDto;
import lab6.common.exceptions.InvalidDateFormatException;
import lab6.common.exceptions.InvalidEndDateException;
import lab6.common.exceptions.InvalidSalaryException;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class AddCommand extends BaseCommand {
    @Override
    protected void Execute(List<String> params) throws IOException, InvalidSalaryException, InvalidDateFormatException, ParseException, InvalidEndDateException {
        ParamsChecker.checkParams(0, params);
        Worker bum = new Worker();
        Utils.updateAll(bum);

        AddCommandDto dto= new AddCommandDto();
        WorkerDto man = Transformer.WorkerToWorkerDto(bum);
        dto.setBum(man);
        CommandRequestDto<AddCommandDto> crd = new CommandRequestDto<>("add", dto);

        byte[] buf = serverCaller.sendToServer(transformer.Serialize(crd));

        CommandResponseDto response = (CommandResponseDto) transformer.DeSerialize(buf);
        System.out.println(response.getResponse());

    }
}
