/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.img;

import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
/**
 *
 * @author nikki
 */
public class GameTest {
    private static final JFrame FRAME = new JFrame("My Dingus");
    private static final JPanel PANEL = new JPanel();
    //private static final JLayeredPane PANEL = new JLayeredPane();
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
        
        //PANEL.setPreferredSize(new Dimension(300,300));
        PANEL.setBorder(BorderFactory.createTitledBorder("Move the Mouse to Move Duke"));
        PANEL.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        //ROOMLABEL.setSize(340,170);
        //ROOMLABEL.setLocation(30, 30);
        ROOMLABEL.setIcon(icon(1));
        
        //INDICATORLABEL.setSize(340,170);
        //INDICATORLABEL.setLocation(30, 30);
        //INDICATORLABEL.setIcon(icon(2));
        
        PANEL.add(ROOMLABEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, -1, -1));
        //PANEL.add(INDICATORLABEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, -1, -1));
        //PANE.setLayer(ROOMLABEL, 0);
        //PANE.setLayer(INDICATORLABEL, 1);
        
        FRAME.add(PANEL);
        FRAME.add(ROOMLABEL);
        FRAME.add(INDICATORLABEL);
        FRAME.show();        
        
//        Game g = new Game(3,1);
//        Indicator i = new Indicator(1, "a");
//        Target t = new Target(1, "a");
//        ArrayList<Indicator> ai = new ArrayList();
//        ai.add(i);
//        Room r = new Room(ai, t, 1);

        
        
        
    }
}
