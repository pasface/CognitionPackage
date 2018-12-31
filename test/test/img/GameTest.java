/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.img;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import se.core.Game;
import se.core.Target;
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
        
        JPanel panelA = new JPanel();
        panelA.setSize(new Dimension(400,400));
        panelA.setLocation(200,200);
        panelA.setBorder(BorderFactory.createTitledBorder("Room: A"));
        panelA.setLayout(new BoxLayout(panelA, BoxLayout.PAGE_AXIS));
        panelA.setBackground(Color.lightGray);

        JPanel panelB = new JPanel();
        panelB.setSize(new Dimension(400,400));
        panelB.setLocation(300, 300);
        panelB.setBorder(BorderFactory.createTitledBorder("Room: B"));
        panelB.setLayout(new BoxLayout(panelB, BoxLayout.PAGE_AXIS));
        panelB.setBackground(Color.BLACK);
        
        frame.add(panelA);
        frame.add(panelB);
        
        Game g = new Game(2,1, panelA);
        //frame.pack();
        frame.show(); 
    }
}
