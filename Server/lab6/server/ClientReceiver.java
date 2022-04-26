package lab6.server;


import lab6.common.Transformer;
import lab6.common.dto.CommandRequestDto;
import lab6.server.commands.Commands;

import java.io.IOException;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Arrays;

public class ClientReceiver {

    byte arr[] = new byte[2048];
    int len = arr.length;
    DatagramChannel dc; ByteBuffer buf;
    InetAddress host; int port = 1290;
    SocketAddress addr;

    void run() {
        requestFromClient();
        // TODO: запустить цикл получения датаграммов с клиента
    }

    public void requestFromClient(){
        Transformer transformer = new Transformer();
        addr = new InetSocketAddress(port);
        try {
            dc = DatagramChannel.open();
            dc.bind(addr);
            buf = ByteBuffer.wrap(arr);
            addr = dc.receive(buf);
            System.out.println(addr);
            buf.flip();
            System.out.println(transformer.DeSerialize(buf.array()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }




        // TODO: десериализация requestContent -> commandDto
        // вместо этого пока создадим "в лоб"



        //Commands.runCommandFromString(Commands.getWorkersSet(), name, requestObject);
        //CommandRequestDto

    }
}
