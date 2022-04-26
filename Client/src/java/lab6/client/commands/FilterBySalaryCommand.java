package lab6.client.commands;

import lab6.client.ServerReceiver;
import lab6.common.Worker;
import lab6.common.dto.CommandRequestDto;
import lab6.common.dto.CommandResponseDto;
import lab6.common.dto.FilterBySalaryCommandDto;
import lab6.common.exceptions.InvalidSalaryException;

import java.util.List;
import java.util.MissingFormatArgumentException;

public class FilterBySalaryCommand extends BaseCommand {
    @Override
    public String getName() {
        return "filter_by_salary";
    }

    @Override
    protected int getCommandParamsCount() {
        return 1;
    }

    /**
     * FilterBySalary command
     * show elements sorted by salary
     */

    @Override
    protected void Execute(List<String> params) throws InvalidSalaryException {
        ParamsChecker.checkParams(1, params);

        FilterBySalaryCommandDto dto= new FilterBySalaryCommandDto();

        try {
            float salary = Float.parseFloat(params.get(0));
            dto.setSalary(salary);
        } catch (Exception e) {
            throw  new MissingFormatArgumentException("param should be float");
        }
        CommandRequestDto<FilterBySalaryCommandDto> crd = new CommandRequestDto<>(getName(), dto);

        byte[] buf = serverCaller.sendToServer(transformer.Serialize(crd));

        CommandResponseDto response = (CommandResponseDto) transformer.DeSerialize(buf);
        dto = (FilterBySalaryCommandDto) response.getCommandArgs();
        List<Worker> workers = dto.getWorkers();
        if (workers.size() == 0){
            System.out.println("No workers found");
        }
        for (Worker i : workers){
            System.out.println(i);
        }

    }
}
