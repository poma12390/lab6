package lab6.client.commands;

import lab6.client.ServerCaller;
import lab6.client.ServerReceiver;
import lab6.client.memory.HistoryWork;
import lab6.common.Transformer;
import lab6.common.exceptions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public abstract class BaseCommand {

    private static final String SUFFIX = "Command";

    ServerCaller serverCaller = new ServerCaller();
    ServerReceiver serverReceiver = new ServerReceiver();
    Transformer transformer = new Transformer();
    private final String name;

    public BaseCommand() {
        String simpleName = this.getClass().getSimpleName();

        assert simpleName.endsWith(SUFFIX);

        this.name = simpleName.substring(0, simpleName.length() - SUFFIX.length());
    }

    /**
     * Определить количество параметрво, необходимых для данной команды.
     * Переопределяется в командах-наследниках, у которых количество параметров отличается от дефолтного
     * @return по умолчанию возвращает 0 (команда без параметров)
     */
    protected int getCommandParamsCount() {
        return 0;
    }

    protected abstract void Execute(List<String> params) throws IOException, InvalidSalaryException, InvalidDateFormatException, ParseException, InvalidEndDateException;

    public String getName() {
        return name;
    }

    public void ExecuteCommand(List<String> params) {
        //ParamsChecker.checkParams(getCommandParamsCount(), params);
        try {
            Execute(params);
            HistoryWork.historyAdd(name);
        } catch (ServerNotFoundException|  InvalidEndDateException | FileNotFoundException | MissedCommandArgumentException | EmptyCollectionException | InvalidSalaryException | InvalidDateFormatException | RecursiveScriptExecuteException e){
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            System.out.println("ошибка парсера");
        }
    }
}
