/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arem.taller03.punto3.parte2;

import co.edu.escuelaing.arem.taller03.punto3.parte1.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author estudiante
 */
class SocketConnection {
    ServerSocket serverSocket;
    
    public SocketConnection() {
        serverSocket = null;
    }
    
    public ServerSocket getServerSocket(){
        
        serverSocket = null;
        
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {

            System.err.println("Could not listen on port: 35000.");
            System.exit(1);

        }
        return serverSocket;
    }
        
    public Socket getClientSocket(){
        Socket clientSocket = null;
        
        try {

            clientSocket = serverSocket.accept();
        } catch (IOException e) {

            System.err.println("Accept failed.");
            System.exit(1);

        }
        
        return clientSocket;
    }  
    
}
