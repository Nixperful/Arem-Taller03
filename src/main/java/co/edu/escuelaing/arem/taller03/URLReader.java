/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arem.taller03;

import java.io.*;
import java.net.*;


/**
 *
 * @author nicolas
 */
public class URLReader {
    
    public static void main(String[] args) throws Exception {

        String indexPath = "index.html";
        
        URL google = new URL("http://www.google.com/");

        try (BufferedReader reader
                = new BufferedReader(new InputStreamReader(google.openStream()))) {
            
            File archivo = new File(indexPath);
            BufferedWriter bw;
            String dataText= "";
            bw = new BufferedWriter(new FileWriter(archivo));
            
            if (archivo.exists()) {
                               
            } else {
                
                String inputLine = null;
                while ((inputLine = reader.readLine()) != null) {
                    dataText= dataText + inputLine+"\n"; 
                    System.out.println(inputLine);
                }
                
                bw.write(dataText);

            }
            bw.close();

            
            

        } catch (IOException x) {
            System.err.println(x);

        }
        
        
        
        
        
    }

}




