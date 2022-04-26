package lab6.client.inputters;

import java.io.BufferedReader;

public class IntInputer extends AbstractInputer<Integer> {

    public IntInputer(BufferedReader bufferedReader, boolean blockPrompt) {
        super(bufferedReader, blockPrompt);
    }

    @Override
    protected Integer doInput(String line) {

        return Integer.parseInt(line);
    }

}
