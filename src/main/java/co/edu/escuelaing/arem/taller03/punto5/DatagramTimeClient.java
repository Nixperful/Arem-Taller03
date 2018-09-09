/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arem.taller03.punto5;

/**
 *
 * @author Nicolás
 */
import java.io.IOException;
import java.net.DatagramPacket;

import java.net.DatagramSocket;
import java.net.InetAddress;

import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DatagramTimeClient {

    public static void main(String[] args) {

        String dataInput = null;
        boolean isNotFinished = true;

        try {

            while (isNotFinished) {
                DatagramSocket datagramSocket = new DatagramSocket();
                byte[] buf = new byte[256];

                InetAddress address = InetAddress.getByName("127.0.0.1");

                DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4445);
                datagramSocket.send(packet);

                packet = new DatagramPacket(buf, buf.length);
                datagramSocket.setSoTimeout(5000);

                try {

                    datagramSocket.receive(packet);
                    dataInput = new String(packet.getData(), 0, packet.getLength());
                    System.out.println("Date: " + dataInput);

                } catch (SocketTimeoutException e) {
                    System.out.println("Date: " + dataInput);
                    datagramSocket.close();
                }
                try{
                    Thread.sleep(5000);
                }catch (InterruptedException ex) {
                    Logger.getLogger(DatagramTimeClient.class.getName()).log(Level.SEVERE, null, ex);
}
            }

        } catch (SocketException ex) {

            Logger.getLogger(DatagramTimeClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {

            Logger.getLogger(DatagramTimeClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {

            Logger.getLogger(DatagramTimeClient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
