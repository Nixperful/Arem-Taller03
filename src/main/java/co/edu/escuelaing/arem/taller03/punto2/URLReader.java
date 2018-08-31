/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arem.taller03.punto2;

import java.io.*;
import java.net.*;


/**
 *
 * @author nicolas
 */
public class URLReader {
    
    public static void main(String[] args) throws Exception {

        String indexPath = "resultado.html";
        URLMaker urlMkr = new URLMaker();
        URL myURL = urlMkr.ReadURL();
        urlMkr.WriteURL(myURL,indexPath);
        
        
        
        
        
        
        
    }

}




