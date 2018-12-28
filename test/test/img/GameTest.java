/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.img;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import se.core.Game;
/**
 *
 * @author nikki
 */
public class GameTest {
    private static final JFrame FRAME = new JFrame("My Dingus");
    private static final JPanel PANEL = new JPanel();
    private static final JLabel ROOMLABEL = new JLabel();
    private static final JLabel INDICATORLABEL = new JLabel();
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
        FRAME.setSize(1920,1100);
        
        PANEL.setSize(new Dimension(400,400));
        PANEL.setBorder(BorderFactory.createTitledBorder("name of panel"));
        PANEL.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        PANEL.setBackground(Color.darkGray);
        
        ROOMLABEL.setSize(340,170);
        ROOMLABEL.setLocation(30, 30);
        ROOMLABEL.setIcon(icon(1));
        
        INDICATORLABEL.setSize(200,100);
        INDICATORLABEL.setLocation(35, 35);
        INDICATORLABEL.setIcon(icon(2));
        
        //Target target = new Target(10,10);
        //FRAME.add(target.getTARGET());
        FRAME.add(INDICATORLABEL);
        FRAME.add(ROOMLABEL);
        
        FRAME.add(PANEL);
        
        FRAME.show();        
        
        Game g = new Game(3,1);
        g.toString();
    }
}
