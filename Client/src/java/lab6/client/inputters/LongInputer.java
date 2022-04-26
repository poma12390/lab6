package lab6.client.inputters;

import java.io.BufferedReader;

public class LongInputer extends AbstractInputer<Long> {

    public LongInputer(BufferedReader bufferedReader, boolean blockPrompt) {
        super(bufferedReader, blockPrompt);
    }

    @Override
    protected Long doInput(String line) {
        return Long.parseLong(line);
    }

}
