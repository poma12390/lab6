package lab6.client.memory;

import java.util.ArrayList;

public class HistoryWork {
        private static ArrayList<String> history = new ArrayList<String>();


    public static void historyAdd(String command){
            if (history.size()>4){
                history.remove(0);
            }
            history.add(command);
        }

    public static ArrayList<String> getHistory(){
        return history;
    }
}
