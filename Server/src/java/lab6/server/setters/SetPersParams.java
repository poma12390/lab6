package lab6.server.setters;

import lab6.common.Person;
import lab6.common.Worker;
import lab6.common.exceptions.EmptyStringException;
import lab6.common.exceptions.InvalidDateFormatException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class SetPersParams {
    public static void setHeight(String height, Person pers) throws EmptyStringException, NumberFormatException {
        if (height.isEmpty()){
            throw new EmptyStringException();
        }
        else {
            float f = Float.parseFloat(height);
            if (f == 0 | f < 0) {
                throw new EmptyStringException();
            } else {
                pers.setHeight(f);
            }
        }
    }

    public static void setWeight(String weight, Person pers) throws EmptyStringException, NumberFormatException{
        if (weight.isEmpty()){
            throw new EmptyStringException();
        }
        else {
            float f = Float.parseFloat(weight);
            if (f == 0 | f < 0) {
                throw new EmptyStringException();
            } else {
                pers.setWeight(f);
            }
        }
    }
    public static void setBirthday(String birthday, Person pers) throws ParseException, InvalidDateFormatException {
        String regex = "\\d{2}\\.\\d{2}.\\d{4}";
        if (birthday.matches(regex)) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            Date date = formatter.parse(birthday);
            ZoneId defaultZoneId = ZoneId.systemDefault();
            Instant instant = date.toInstant();
            ZonedDateTime zonedDateTime = instant.atZone(defaultZoneId);
            pers.setBirthday(zonedDateTime);
        } else {
            throw new InvalidDateFormatException();
        }
    }

    public static void setPersToWork(Person pers, Worker bum){
        bum.setPerson(pers);
    }
}
