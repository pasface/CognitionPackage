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

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author nikki
 */
public class GameLaunch {

    private static final JFrame FRAME = new MyFrame();
    private static JPanel gamePanel = new JPanel();
    private static boolean b = false;
    private static IntroScreen introPanel;
    private static final String ROOM_XML = "./room-jaxb.xml";

    public static void main(String[] args) {
        FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FRAME.setLayout(new GridLayout());
        introPanel = new IntroScreen(new JPanel());
        FRAME.add(introPanel);
        FRAME.add(gamePanel);
        FRAME.setVisible(true);

    }

    public static void launch() throws JAXBException, IOException {
        gamePanel.setVisible(false);
        FRAME.remove(gamePanel);
        if (isBool() == true) {
            ComponentSettings cs = new ComponentSettings();
            //remove intro screen
            FRAME.remove(introPanel);
            gamePanel = new JPanel();
            GridLayout roomLayout = new GridLayout(cs.getRows(), cs.getCols());
            roomLayout.setHgap(cs.getGap());
            roomLayout.setVgap(cs.getGap());
            gamePanel.setLayout(roomLayout);
            gamePanel.setVisible(true);
            GameId.setGameId("src/files/file.xml");
            Game g = new Game(cs.getNumOfGames(), GameId.getGameId(), gamePanel);
            Game.resetCounts();
            System.out.println(g.toString());
            FRAME.add(gamePanel);
            FRAME.validate();
            setBool(false);

            // create JAXB context and instantiate marshaller
            JAXBContext context = JAXBContext.newInstance(Game.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Write to System.out
            m.marshal(g, System.out);

            // Write to File
            //m.marshal(g, new File(ROOM_XML));

        } else {
            FRAME.validate();
        }
    }

    public static void setBool(boolean b) {
        GameLaunch.b = b;
    }

    public static boolean isBool() {
        return b;
    }

}
