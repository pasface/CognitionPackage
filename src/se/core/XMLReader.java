package se.core;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nikki
 */
public class XMLReader {
    private String xml2String;
    
    public XMLReader (String file) {
        File xmlFile = new File(file);
        Reader fileReader = null;
        try {
            fileReader = new FileReader(xmlFile);
        } catch (FileNotFoundException ex) {
            //if file doesn't exist create it
            XMLWriter y = new XMLWriter(file);
            System.out.println("FileNotFoundException" + ex);
        }
        StringBuilder sb = null;
        try (BufferedReader bufReader = new BufferedReader(fileReader)) {
            sb = new StringBuilder();
            String line = bufReader.readLine();
            while(line !=null){
                sb.append(line).append("\n");
                line=bufReader.readLine();
            }
        } catch (IOException ex) {
            System.out.print("IOException.");
        }
        xml2String = sb.toString();
    }

    @Override
    public String toString() {
        return xml2String;
    }
}
