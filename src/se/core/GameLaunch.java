/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

TO DO:  Fix graphics.
        Set order of visibility.
        Change layout of rooms.
        Rework organization.
        Continue xml stuff.
        Document everything.
        
 */
package se.core;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
        introPanel = new IntroScreen(panel);
        frame.add(panel);
        frame.add(panelb);
        frame.setVisible(true);
        frame.setBackground(Color.yellow);
        
    }

    public static void launch(){
        panelb.setVisible(false);
        frame.remove(panelb);
        if (isB()==true){
            //remove intro screen
            panel.setVisible(false);
            frame.remove(panel);
            
            panelb = new JPanel();
            panelb.setBackground(Color.darkGray);
            GridLayout roomLayout = new GridLayout(3,2);
            roomLayout.setHgap(10);
            roomLayout.setVgap(10);
            panelb.setLayout(roomLayout);
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
