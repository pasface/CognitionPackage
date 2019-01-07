/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

TO DO:  Add panels to a panel rather than frame and use removeall to get rid of old stuff.
        Fix the layout: https://docs.oracle.com/javase/8/javafx/layout-tutorial/builtin_layouts.htm#JFXLY102
        Fix graphics.
        Rework organization.
        Figure out how I wanna handle configs.
        
 */
package se.core;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import pigldywigldy.MyFrame;
/**
 *
 * @author nikki
 */
public class GameLaunch {
    private static final JFrame frame = new MyFrame();
    private static final JPanel panel = new JPanel();
    private static JPanel panelb = new JPanel();
    private static boolean b = false;
    private static IntroScreen introPanel;
    private static Game g;

    public static void main(String[] args) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout());
        //frame.setLayout(new BorderLayout());
        introPanel = new IntroScreen(panel);
        frame.add(panel);
        frame.add(panelb);
        frame.setVisible(true);
        
    }

    public static void launch(){
        
        if (isB()==true){
            //remove intro screen
            panel.setVisible(false);
            frame.remove(panel);
            panelb.setVisible(false);
            panelb = new JPanel();
            panelb.setLayout(new GridLayout(2,3));
            panelb.setVisible(true);
            GameId.setGameId("src/files/file.xml");
            g = new Game(6,GameId.getGameId(), panelb);
            System.out.println(g.toString());
            frame.add(panelb);
            frame.validate();
            setB(false);
        } else {
            //introPanel.setVisible(true);
            frame.validate();
        }
    }
    
    public static void setB(boolean b) {
        GameLaunch.b = b;
    }

    public static boolean isB() {
        return b;
    }
    
}
