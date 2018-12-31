/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.img;

import java.awt.GridLayout;
import javax.swing.Icon;
import javax.swing.JFrame;
import se.core.Game;
/**
 *
 * @author nikki
 */
public class GameTest {
    private static final JFrame frame = new JFrame("Cognition Package");

    private static String S;
    
    public static Icon icon(int i){
        switch (i){
            case 1: S = "office.jpg";
            break;
            case 2: S = "office2.jpg";
            break;
            case 3: S = "office3.jpg";
            break;
        }
        return new javax.swing.ImageIcon(GameTest.class.getResource(S));
    }
    
    public static void main(String[] args) {
        frame.setSize(1920,1100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2,6));
        
        Game g = new Game(6,1, frame);
        frame.show(); 
    }
}
