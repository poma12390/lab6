package lab6.client.commands;

import java.io.IOException;
import java.util.List;

public class SaveCommand extends BaseCommand {

    /**
     * save command
     * save collection in csv file
     */

    @Override
    protected void Execute(List<String> params) throws IOException {
        ParamsChecker.checkParams(0,params);
        System.out.println("Я не знаю, зачем ее оставил");

    }
}
