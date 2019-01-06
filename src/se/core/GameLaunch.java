/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.



TO DO: Add panels to a panel rather than frame and use removeall to get rid of old stuff.


 */
package se.core;

import java.awt.GridLayout;
import javax.swing.JFrame;
import pigldywigldy.MyFrame;
/**
 *
 * @author nikki
 */
public class GameLaunch {
    private static final JFrame frame = new MyFrame();
    private static boolean b = false;
    private static IntroScreen introPanel;
    private static Game g;

    public static void main(String[] args) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2,6));
        introPanel = new IntroScreen(frame);
        frame.setVisible(true);
        
    }

    public static void launch(){
        
        if (isB()==true){
            //introPanel.setVisible(false);
            frame.remove(introPanel);
            System.out.println("REMOVE: " + introPanel.toString());
            g = new Game(6,1, frame);
            System.out.println(g.toString());
            frame.revalidate();
        } else {
            //introPanel.setVisible(true);
            frame.revalidate();
        }
    }
    
    public void setB(boolean b) {
        GameLaunch.b = b;
    }

    public static boolean isB() {
        return b;
    }
    
}
