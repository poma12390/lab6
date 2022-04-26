package lab6.client.inputters;

import lab6.common.exceptions.InvalidDateFormatException;

import java.io.BufferedReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Datainputer extends AbstractInputer<Date> {

    public Datainputer(BufferedReader bufferedReader, boolean blockPrompt) {
        super(bufferedReader, blockPrompt);
    }

    @Override
    protected Date doInput(String line) throws InvalidDateFormatException, ParseException {
        String regex = "\\d{2}\\.\\d{2}.\\d{4}";
        if (line.matches(regex)) {
            String[] items = line.split("\\.");
            int y = Integer.parseInt(items[0]);
            int y1 = Integer.parseInt(items[1]);
            if (y>31 | y1 > 12){
                throw new InvalidDateFormatException();
            }
            else {
                SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
                Date date = formatter.parse(line);
                return date;
            }
        } else {
            throw new InvalidDateFormatException();
        }
    }
}
