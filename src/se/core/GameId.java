/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.core;

/**
 *
 * @author nikki
 */
public class GameId {
    public static void main(String[] args) {
        String file = "src/se/core/indi.xml";
        XMLReader x = new XMLReader(file);
        System.out.println("Printing out value of file: "+x);
    }
}
