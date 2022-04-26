package lab6.client.memory;

import lab6.common.exceptions.RecursiveScriptExecuteException;

import java.util.ArrayList;

public class OverflowChecker {
    private static ArrayList<String> files = new ArrayList<String>();

    public static ArrayList<String> getFiles() {
        return files;
    }
    public static void checkRec(String path){
        if (files.contains(path)){
            throw new RecursiveScriptExecuteException();
        }
        files.add(path);
        System.out.println(files);
    }
}
