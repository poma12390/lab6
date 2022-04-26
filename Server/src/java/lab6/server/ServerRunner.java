package lab6.server;


import lab6.common.Coordinates;
import lab6.common.Person;
import lab6.common.Transformer;
import lab6.common.Worker;
import lab6.common.dto.ClearCommandDto;
import lab6.common.dto.CommandRequestDto;
import lab6.server.commands.Commands;
import lab6.server.commands.SaveCommand;
import lab6.server.setters.DiagnosticSignalHandler;
import sun.misc.Signal;


import sun.misc.Signal;
import sun.misc.SignalHandler;


import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.ByteBuffer;

public class ServerRunner implements SignalHandler{

    public static void main(String[] args) {

        Commands.temporaryStart("C:\\Users\\pomat\\IdeaProjects\\lab6\\Server\\save.csv");
        //String env = System.getenv("Javahome");
        //System.out.println(env + " env");
        //Commands.temporaryStart(env);


        new Thread(() -> {
            ClientReceiver receiver = new ClientReceiver();
                receiver.run();


            // выполнение в отдельном потоке

        }).start();
        System.out.println("Save для закрылия");

        // TODO: после Ctrl+C вызвать сохранение коллекции



        new Thread(() -> {
            InputStream inputStream = System.in;
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String input ="";
            while (true) {
                try {
                    input = bufferedReader.readLine();
                    if (input.equals("save")){
                        Commands.runCommandFromString(Commands.getWorkersSet(), "save",new CommandRequestDto<>("save", new ClearCommandDto()));
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);

                }catch (NullPointerException ignored){
                }
            }

            // выполнение в отдельном потоке

        }).start();

        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                try {
                    Thread.sleep(200);
                    System.out.println("Shutting down ...");
                    //some cleaning up code...

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }
        });

        SignalHandler signalHandler = new SignalHandler() {

            @Override
            public void handle(Signal signal) {
                System.out.println("saving collection");
                Commands.runCommandFromString(Commands.getWorkersSet(), "save",new CommandRequestDto<>("save", new ClearCommandDto()));
            }
        };
        DiagnosticSignalHandler.install("TERM", signalHandler);
        DiagnosticSignalHandler.install("INT", signalHandler);
        DiagnosticSignalHandler.install("ABRT", signalHandler);


    }

    @Override
    public void handle(Signal signal) {

    }
}
