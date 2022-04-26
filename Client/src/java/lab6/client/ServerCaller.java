package lab6.client;


import lab6.common.Transformer;
import lab6.common.exceptions.ServerNotFoundException;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class ServerCaller {
    DatagramChannel dc;
    ByteBuffer buf;
    InetAddress host;
    int port = 12390;
    SocketAddress addr;
    SocketAddress addr1;

    int len;

    public byte[] sendToServer(byte[] arr) {

        try {
            Transformer transformer = new Transformer();
            byte[] ret = new byte[65536];
            byte[] recive = new byte[4096];
            try {
                dc = DatagramChannel.open();
                buf = ByteBuffer.wrap(arr);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {

                host = InetAddress.getLocalHost();
                System.out.println(host + " host");
            } catch (UnknownHostException e) {
                System.out.println("NO HOST");
                throw new RuntimeException(e);
            }
            addr = new InetSocketAddress(host, port);
            addr1 = new InetSocketAddress(host, port);
            for (int i = 0; i < 5; i++) {
                try {
                    buf = ByteBuffer.wrap(arr);
                    dc.configureBlocking(false);
                    System.out.println(buf.array().length + " send " + host + " " + dc.getLocalAddress());
                    dc.send(buf, addr1);
                    buf = ByteBuffer.wrap(ret);
                    ServerReceiver.sleep(1000);

                    addr = dc.receive(buf);

                    //recive = serverReceiver.catcher(dc,buf);
                   // addr = dc.receive(buf);
                    //ret = serverReceiver.catcher(dc, buf);
                    if (ret[0]!=0) {
                        return buf.array();
                    }
                    if (i < 4) {
                        System.out.println("Trying to connect to server");
                    } else throw new ServerNotFoundException();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }

            return recive;
        } finally {
            try {
                dc.close();
            } catch (IOException ignored) {
            }
        }

    }

}