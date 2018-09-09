/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arem.taller03.punto6;

/**
 *
 * @author Nicolás
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EchoServerImpl implements EchoServer {
    public boolean nMessage = false;
    public String last = "Conversation begin";
    public EchoServerImpl(String ipRMIregistry, int puertoRMIregistry, String nombreDePublicacion) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        
        try {
            EchoServer echoServer= (EchoServer) UnicastRemoteObject.exportObject(this, 0);
            Registry registry = LocateRegistry.getRegistry(ipRMIregistry, puertoRMIregistry);

            registry.rebind(nombreDePublicacion, echoServer);
            System.out.println("Echo server ready...");

        } catch (Exception e) {
            System.err.println("Echo server exception:");

            e.printStackTrace();
        }

    }
    @Override
    public String echo(String text) throws RemoteException {        
        String nMessage="";
        try {
            nMessage = (new BufferedReader(new InputStreamReader(System.in))).readLine();
        } catch (IOException ex) {
            Logger.getLogger(EchoServerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nMessage;
}

    public static void main(String[] args) {
        EchoServerImpl ec = new EchoServerImpl("127.0.0.1", 23000, "echoServer");

    }

}
