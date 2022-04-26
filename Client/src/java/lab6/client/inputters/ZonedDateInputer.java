package lab6.client.inputters;

import lab6.common.exceptions.InvalidDateFormatException;

import java.io.BufferedReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class ZonedDateInputer extends AbstractInputer<ZonedDateTime> {

    public ZonedDateInputer(BufferedReader bufferedReader, boolean blockPrompt) {
        super(bufferedReader, blockPrompt);
    }

    @Override
    protected ZonedDateTime doInput(String line) throws InvalidDateFormatException, ParseException {
        String regex = "\\d{2}\\.\\d{2}.\\d{4}";
        if (line.matches(regex)) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            Date date = formatter.parse(line);
            ZoneId defaultZoneId = ZoneId.systemDefault();
            Instant instant = date.toInstant();
            return instant.atZone(defaultZoneId);
        } else {
            throw new InvalidDateFormatException();
        }
    }
}
