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

    public XMLReader(String file) {
        File xmlFile = new File(file);
        //if file doesn't exist create it
        if (!xmlFile.exists()) {
            XMLWriter y = new XMLWriter(file);
            System.out.println("Created new file.");
        }
        Reader fileReader = null;
        try {
            fileReader = new FileReader(xmlFile);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(XMLReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        StringBuilder sb = null;
        BufferedReader reader = new BufferedReader(fileReader);
        sb = new StringBuilder();
        String line = null;

        try {
            reader.readLine();
        } catch (IOException ex) {
            Logger.getLogger(XMLReader.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
                try {
                    line = reader.readLine();
                } catch (IOException ex) {
                    System.out.println("choked on line 52");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(XMLReader.class.getName()).log(Level.SEVERE, null, ex);
        }

        xml2String = sb.toString();
    }

    @Override
    public String toString() {
        return xml2String;
    }
}
