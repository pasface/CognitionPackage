package pigldywigldy;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;

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
    
    public XMLReader (String file) throws Exception {
        File xmlFile = new File(file);
        Reader fileReader = new FileReader(xmlFile);
        BufferedReader bufReader = new BufferedReader(fileReader);
        
        StringBuilder sb = new StringBuilder();
        String line = bufReader.readLine();
        while(line !=null){
            sb.append(line).append("\n");
            line=bufReader.readLine();
        }
        xml2String = sb.toString();
        bufReader.close();
    }

    @Override
    public String toString() {
        return xml2String;
    }
}
