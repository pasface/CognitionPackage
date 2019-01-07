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
        String s = "Game string goes here.";
         try{    
             try (FileWriter fw = new FileWriter(file)) {
                 fw.write(s);
             }    
          } catch(IOException e){
              System.out.println("IOException." );
          }    
     } 
}
