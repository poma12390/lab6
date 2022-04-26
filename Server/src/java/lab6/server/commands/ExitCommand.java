package lab6.server.commands;

import lab6.common.Transformer;
import lab6.common.Worker;
import lab6.common.dto.CommandRequestDto;
import lab6.server.ClientCaller;

import java.io.Serializable;
import java.util.LinkedHashSet;

public class ExitCommand extends BaseCommand

        /**
         * exit command
         * command for exit
         */
{
    @Override
    protected void Execute(CommandRequestDto<? extends Serializable> params, LinkedHashSet<Worker> set, Transformer transformer, ClientCaller clientCaller) {
    }
}
