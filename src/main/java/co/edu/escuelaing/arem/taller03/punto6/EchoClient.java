/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arem.taller03.punto6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 *
 * @author Nicolás Osorio
 */
public class EchoClient {

    public void ejecutaServicio(String ipRmiregistry, int puertoRmiRegistry,
            String nombreServicio) {

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());

        }
        try {

            Registry registry = LocateRegistry.getRegistry(ipRmiregistry, puertoRmiRegistry);
            EchoServer echoServer = (EchoServer) registry.lookup(nombreServicio);
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                System.out.println(echoServer.echo(userInput));
                if (userInput.equals("")) {
                    break;
                }
            }
        } catch (Exception e) {

            System.err.println("Hay un problema:");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        EchoClient ec = new EchoClient();
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in)); 
        System.out.println("Escribe la dirección IP: ");            
        String ip=in.readLine(); 
        System.out.println("Escribe el puerto al que te quieres conectar:");
        String port=in.readLine(); 
        ec.ejecutaServicio("127.0.0.1", 23000, "echoServer");

    }
}
