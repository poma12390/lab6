package lab6.client;


import lab6.common.exceptions.ServerNotFoundException;

import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class ServerReceiver {

    private static byte[] requestContent;

    public void requestFromServer(byte[] requestContent){
        ServerReceiver.requestContent = requestContent;
    }

    public static byte[] receiveFromServer() {
        return requestContent;
    }

    //    public List<Worker> getCollection(){
//       // byte[] request = new byte[10];// Вызвать процедуру упаковки команды getWorkers
//        byte[] response = serverReciever.receive("getCollectionCommand".getBytes(StandardCharsets.UTF_8));
//        List<Worker> result = new ArrayList<>();// вызвать процедуру распаковки из response в result
//        return result;
//    }
//    public Worker getWorker(){
//        byte[] request = new byte[10];
//        serverRunner.call("getWorkerCommand".getBytes(StandardCharsets.UTF_8));
//
//        Worker bum = new Worker(); // response -> result
//        return null;
//    }
//    public void send (Object command){
//
//    }
    DatagramPacket dp;
    DatagramPacket dp1;
    DatagramChannel dc;
    ByteBuffer buf;
    ByteBuffer buf1;
    InetAddress host;
    SocketAddress addr;
    byte[] arr = new byte[2048];
    DatagramSocket ds;

     byte[] catcher(DatagramChannel dc, ByteBuffer buf) {
        int port = 12390;
         try {
             ds = new DatagramSocket();
             host = InetAddress.getLocalHost();
             dp = new DatagramPacket(arr,0);
             ds.receive(dp);
         } catch (UnknownHostException e) {
             throw new RuntimeException(e);
         } catch (SocketException e) {
             throw new RuntimeException(e);
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
         return arr;
     }

    public static void sleep(int mils){
        try {
            Thread.sleep(mils);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
