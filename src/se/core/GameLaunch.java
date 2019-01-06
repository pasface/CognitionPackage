/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.core;

import java.awt.GridLayout;
import javax.swing.JFrame;
import pigldywigldy.MyFrame;
import se.core.Game;
/**
 *
 * @author nikki
 */
public class GameLaunch {
    private static final JFrame frame = new MyFrame();
    private static boolean b = true;

    public static void main(String[] args) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2,6));
        frame.setVisible(true);
        
        if (isB()==true){
            Game g = new Game(6,1, frame);
            System.out.println(g.toString());
            frame.validate();
        } else {
            IntroScreen is = new IntroScreen(frame);
            frame.validate();
        }
        
        
    }

    public void setB(boolean b) {
        GameLaunch.b = b;
    }

    public static boolean isB() {
        return b;
    }
    
}
