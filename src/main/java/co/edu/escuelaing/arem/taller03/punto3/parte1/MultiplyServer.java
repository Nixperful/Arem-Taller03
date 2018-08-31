/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arem.taller03.punto3.parte1;

import java.net.*;
import java.io.*;
/**
 *
 * @author estudiante
 */
public class MultiplyServer {

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

        while ((inputLine = in.readLine()) != null) {
            System.out.println(
            "Número Introducido:  " + inputLine
            );
            
            DataProcessor dP = new DataProcessor();
            Float ans =  dP.square(Float.parseFloat(inputLine));
            outputLine = ans;
            out.println(outputLine);

            if (outputLine.equals("Respuestas: Bye.")) {
                break;
            }

        }
        out.close();

        in.close();
        clientSocket.close();

        serverSocket.close();
    }

}