package lab6.client.inputters;

import java.io.BufferedReader;

public class FloatInputer extends AbstractInputer <Float>{

    public FloatInputer(BufferedReader bufferedReader, boolean blockPrompt) {
        super(bufferedReader, blockPrompt);
    }

    @Override
    protected Float doInput(String line) {
        return Float.parseFloat(line.replace("\r\n",""));
    }
}
