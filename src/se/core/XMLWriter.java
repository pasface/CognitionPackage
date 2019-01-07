/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.core;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author nikki
 */
public class XMLWriter {
    public XMLWriter (String file) {
         try{    
           FileWriter fw = new FileWriter(file);    
           fw.write("Welcome to javaTpoint.");    
           fw.close();    
          } catch(IOException e){
              System.out.println("IOException." + e);
          }    
     } 
}
