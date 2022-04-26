package lab6.server;


import lab6.common.Transformer;
import lab6.common.Worker;
import lab6.common.dto.CommandRequestDto;
import lab6.server.commands.Commands;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Arrays;

public class ClientReceiver {

    public static byte arr[] = new byte[65536];
    public static int len = arr.length;
    public static DatagramSocket ds;
    public static DatagramPacket dp;
    int port = 12390;
    ByteBuffer buf;

    void run() {
//        try {
//
//            addr = new InetSocketAddress(port);
//            dc = DatagramChannel.open();
//            dc.bind(addr);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        try {
            ds = new DatagramSocket(port);
            dp = new DatagramPacket(arr, len);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }

        requestFromClient();
        // TODO: запустить цикл получения датаграммов с клиента
    }

    //        // TODO: десериализация requestContent -> commandDto
//        // вместо этого пока создадим "в лоб"
//
//        //Commands.runCommandFromString(Commands.getWorkersSet(), name, requestObject);
//        //CommandRequestDto
//
//    }
    public void requestFromClient() {
        Transformer transformer = new Transformer();
        try {
            boolean c = true;
            while (c) {
                String command = "";
                ds.receive(dp);
                if (arr[0]==0){
                    continue;
                }
                CommandRequestDto dto = (CommandRequestDto) transformer.DeSerialize(arr);
                command = dto.getCommandName();
                System.out.println(command);
                Commands.runCommandFromString(Commands.getWorkersSet(), command,dto);




            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


//    public void requestFromClient1(){
//
//        Transformer transformer = new Transformer();
//        try {
//            buf = ByteBuffer.wrap(arr);
//            while (true){
//
//                addr = dc.receive(buf);
//                //System.out.println(Arrays.toString(buf.array()));
//                Thread.sleep(100);
//                CommandRequestDto dto = (CommandRequestDto) transformer.DeSerialize(arr);
//                System.out.println(dto.getCommandName());
//                buf.clear();
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
    }
}
