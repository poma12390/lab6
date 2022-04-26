package lab6.server.commands;

import lab6.common.Transformer;
import lab6.common.Worker;
import lab6.common.dto.CommandRequestDto;
import lab6.common.dto.CommandResponseDto;
import lab6.common.dto.ShowCommandDto;
import lab6.server.ClientCaller;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class ShowCommand extends BaseCommand {

    /**
     * show command
     * show all obj from in Collection
     */

    @Override
    protected void Execute(CommandRequestDto<? extends Serializable> params, LinkedHashSet<Worker> set, Transformer transformer, ClientCaller clientCaller) {
        ShowCommandDto showCommandDto = new ShowCommandDto();

        showCommandDto.setWorkers(set
                .stream()
                .sorted(Comparator.comparing(Worker::getName))
                .collect(Collectors.toList())
        );

        clientCaller.sendToClient(
                transformer.serialize(new CommandResponseDto(showCommandDto))
        );
    }
}

