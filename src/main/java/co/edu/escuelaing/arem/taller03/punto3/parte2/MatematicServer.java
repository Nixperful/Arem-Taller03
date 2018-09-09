/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arem.taller03.punto3.parte2;
import java.net.*;
import java.io.*;

/**
 *
 * @author estudiante
 */


public class MatematicServer {

    public static void main(String[] args) throws IOException {
        
        SocketConnection sC = new SocketConnection();
        
        ServerSocket serverSocket = sC.getServerSocket();
        Socket clientSocket = sC.getClientSocket();


        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));
        String inputLine;
        Float outputLine;
        boolean isFinished=true;    
        while(isFinished){
            try{
                DataProcessor dP = new DataProcessor();
                while ((inputLine = in.readLine()) != null) {
                    System.out.println(
                    "Número Introducido:  " + inputLine
                    );

                    
                    if (inputLine.equals("bye")) {
                        isFinished=false;
                        break;
                    }
                    
                    dP.calculateOperation(inputLine);
                    outputLine =dP.getLastAns();
                    out.println(outputLine+"   Operación: "+dP.getActualOperation());

                    
                }
            }catch(Exception e){
                   //isFinished=false;
            }

        }
        out.close();

        in.close();
        clientSocket.close();

        serverSocket.close();
    }

}