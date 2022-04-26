package lab6.server.commands;

import lab6.common.Transformer;
import lab6.common.Worker;
import lab6.common.dto.CommandRequestDto;
import lab6.common.dto.CommandResponseDto;
import lab6.common.dto.PrintFieldDescendingEndDateCommandDto;
import lab6.server.ClientCaller;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    protected void Execute(CommandRequestDto<? extends Serializable> params, LinkedHashSet<Worker> set, Transformer transformer, ClientCaller clientCaller) {

        List<Date> dates = Arrays.stream(set.stream().flatMap((p) -> Stream.of(p.getEndDate())).toArray(Date[]::new)).sorted().collect(Collectors.toList());
        // На часах 5:20 Жестко переписал с Stream Api
        PrintFieldDescendingEndDateCommandDto dts = new PrintFieldDescendingEndDateCommandDto();
        dts.setDates(dates);
        CommandResponseDto dto = new CommandResponseDto(dts);
        clientCaller.sendToClient(transformer.serialize(dto));
    }
}
