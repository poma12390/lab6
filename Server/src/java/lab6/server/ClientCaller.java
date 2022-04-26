package lab6.server;

import lab6.common.Transformer;
import lab6.common.dto.CommandRequestDto;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientCaller {
    InetAddress host;
    int port;
    byte arr[];
    int len;
    public void sendToClient(byte[] test) {
        DatagramSocket ds = ClientReceiver.ds;
        DatagramPacket dp = ClientReceiver.dp;
        port = dp.getPort();
        host = dp.getAddress();
        arr = test;
        len = arr.length;
        Transformer transformer = new Transformer();
        CommandRequestDto man = (CommandRequestDto) transformer.DeSerialize((dp.getData()));

        dp = new DatagramPacket(arr,len,host,port);
        try {
            System.out.println("send " + len + " bytes to" + host + " " + port);

            ds.send(dp);
        } catch (IOException ignored) {}


    }
}
