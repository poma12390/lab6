package lab6.server.commands;

import lab6.common.Transformer;
import lab6.common.Worker;
import lab6.common.dto.CommandRequestDto;
import lab6.common.dto.CommandResponseDto;
import lab6.common.dto.RemoveAllByEndDateCommandDto;
import lab6.common.exceptions.InvalidDateFormatException;
import lab6.common.exceptions.InvalidEndDateException;
import lab6.server.ClientCaller;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.LinkedHashSet;

public class    RemoveAllByEndDateCommand extends BaseCommand {
    @Override
    public String getName() {
        return "remove_all_by_end_date";
    }

    @Override
    protected int getCommandParamsCount() {
        return 1;
    }

    /**
     * removeByEndDate command
     *
     * @param params end date to delete elements with
     *   delete elemets with input end date
     */

    @Override
    protected void Execute(CommandRequestDto<? extends Serializable> params, LinkedHashSet<Worker> set, Transformer transformer, ClientCaller clientCaller) throws InvalidDateFormatException, ParseException, InvalidEndDateException {
        RemoveAllByEndDateCommandDto removeAllByEndDateCommandDto = (RemoveAllByEndDateCommandDto) params.getCommandArgs();
        Date endDate = removeAllByEndDateCommandDto.getEndDate();
        long count = (set.stream().filter((p) -> p.getEndDate().equals(endDate)).count());
       // Optional<Worker> workers = set.stream().filter((p)-> p.getEndDate().equals(endDate)).findAny();
        //Commands.getIds().removeIf(p -> p.equals(work.getId()));
        set.removeIf(worker -> worker.getEndDate().equals(endDate));
        removeAllByEndDateCommandDto.setCount(count);
        CommandResponseDto dto = new CommandResponseDto(removeAllByEndDateCommandDto);
        clientCaller.sendToClient(transformer.serialize(dto));

    }
}
