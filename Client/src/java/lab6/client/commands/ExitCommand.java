package lab6.client.commands;

import java.util.List;

public class ExitCommand extends BaseCommand

        /**
         * exit command
         * command for exit
         */
{
    @Override
    protected void Execute(List<String> params) {
        ParamsChecker.checkParams(0, params);
        System.out.println("bye");
        System.exit(0);
    }
}
