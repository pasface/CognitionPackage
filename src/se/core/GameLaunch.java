/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

TO DO:  Fix graphics.
        Set order of visibility.
        Rework organization.
        Continue xml stuff.
        Document everything.
        
 */
package se.core;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author nikki
 */
public class GameLaunch {
    
    private static final JFrame frame = new MyFrame();
    private static JPanel gamePanel = new JPanel();
    private static boolean b = false;
    private static IntroScreen introPanel;

    public static void main(String[] args) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout());
        introPanel = new IntroScreen(new JPanel());
        frame.add(introPanel);
        frame.add(gamePanel);
        frame.setVisible(true);
    }

    public static void launch(){
        gamePanel.setVisible(false);
        frame.remove(gamePanel);
        if (isB()==true){
            ComponentSettings cs = new ComponentSettings();
            //remove intro screen
            introPanel.setVisible(false);
            frame.remove(introPanel);
            gamePanel = new JPanel();
            GridLayout roomLayout = new GridLayout(cs.getRows(), cs.getCols());
            roomLayout.setHgap(cs.getGap());
            roomLayout.setVgap(cs.getGap());
            gamePanel.setLayout(roomLayout);
            gamePanel.setVisible(true);
            GameId.setGameId("src/files/file.xml");
            Game g = new Game(cs.getNumOfGames(), GameId.getGameId(), gamePanel);
            System.out.println(g.toString());
            frame.add(gamePanel);
            frame.validate();
            setB(false);
        } else {
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
