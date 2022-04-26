package lab6.client.commands;

import lab6.common.dto.CommandRequestDto;
import lab6.common.dto.CommandResponseDto;
import lab6.common.dto.RemoveAllByEndDateCommandDto;
import lab6.common.exceptions.InvalidDateFormatException;
import lab6.common.exceptions.InvalidEndDateException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RemoveAllByEndDateCommand extends BaseCommand {
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
     *               delete elemets with input end date
     */

    @Override
    protected void Execute(List<String> params) throws InvalidDateFormatException, ParseException, InvalidEndDateException {
        ParamsChecker.checkParams(1, params);

        RemoveAllByEndDateCommandDto dto = new RemoveAllByEndDateCommandDto();
        CommandRequestDto<RemoveAllByEndDateCommandDto> crd = new CommandRequestDto<>(getName(), dto);
        String endDate = params.get(0);
        Date date = null;
        String regex = "\\d{2}\\.\\d{2}.\\d{4}";
        if (endDate.matches(regex)) {
            String[] items = endDate.split("\\.");
            int y = Integer.parseInt(items[0]);
            int y1 = Integer.parseInt(items[1]);
            if (y>31 | y1 > 12 ){
                throw new InvalidDateFormatException();
            }
            else {
                SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
                date = formatter.parse(endDate);
                dto.setEndDate(date);
            }
        } else {
            throw new InvalidDateFormatException();
        }

        byte[] buf = serverCaller.sendToServer(transformer.Serialize(crd));

        CommandResponseDto response = (CommandResponseDto) transformer.DeSerialize(buf);
        dto = (RemoveAllByEndDateCommandDto) response.getCommandArgs();
        long count = dto.getCount();


        System.out.println("Deleted " +count + " elements");

    }
}

