package lab6.client.inputters;

import lab6.common.Position;

import java.time.ZonedDateTime;
import java.util.Date;

import static lab6.client.commands.Utils.*;


public class InputUtils {
    public static Date inputData(String name) {
        Datainputer inputer = new Datainputer(currentBufferedReader, blockPrompts);
        return inputer.inputValue(name);
    }

    public static long inputLong(String name) {
        LongInputer inputer = new LongInputer(currentBufferedReader, blockPrompts);
        return inputer.inputValue(name);
    }

    public static ZonedDateTime inputZonedDate(String name) {
        ZonedDateInputer inputer = new ZonedDateInputer(currentBufferedReader, blockPrompts);
        return inputer.inputValue(name);
    }

    public static int inputInt(String name) {
        IntInputer inputer = new IntInputer(currentBufferedReader, blockPrompts);
        return inputer.inputValue(name);
    }

    public static Float inputFloat(String name) {
        FloatInputer inputer = new FloatInputer(currentBufferedReader, blockPrompts);
        return inputer.inputValue(name);
    }
    public static String inputString(String name) {
        StringInputer inputer = new StringInputer(currentBufferedReader, blockPrompts);
        return inputer.inputValue(name);
    }

    public static Position inputPosition(String name) {
        PositionInputer inputer = new PositionInputer(currentBufferedReader, blockPrompts);
        return inputer.inputValue(name);
    }


}
