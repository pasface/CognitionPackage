/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 TO DO:  Fix graphics.
 Rework organization.
 Continue xml stuff.
 Document everything.
        
 */
package se.core;

import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.awt.GridLayout;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.xml.bind.Unmarshaller;

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

    public static void main(String[] args) throws JAXBException {
        FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FRAME.setLayout(new GridLayout());
        introPanel = new IntroScreen(new JPanel());
        FRAME.add(introPanel);
        FRAME.add(gamePanel);
        FRAME.setVisible(true);
    }

    public static void open() throws JAXBException {
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
            unmarshallFile();
            //GameId.setGameId("src/files/file.xml");
            //Game g = new Game(cs.getNumOfGames(), GameId.getGameId(), gamePanel);
            Game.resetCounts();
            //System.out.println(g.toString());
            FRAME.add(gamePanel);
            FRAME.validate();
            setBool(false);
        } else {
            FRAME.validate();
        }
    }

    public static void unmarshallFile() throws JAXBException {
        //getting the xml file to read
        File file = new File(ROOM_XML);
        //creating the JAXB context
        JAXBContext jContext = JAXBContext.newInstance(Game.class);
        //creating the unmarshall object
        Unmarshaller unmarshallerObj = jContext.createUnmarshaller();
        //calling the unmarshall method
        Game g = (Game) unmarshallerObj.unmarshal(file);
        System.out.print(g.toString());
    }

    public static void marshallClasses(Game g) throws JAXBException {
        // create JAXB context and instantiate marshaller
        JAXBContext context = JAXBContext.newInstance(Game.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // Write to System.out
        m.marshal(g, System.out);

        // Write to File
        m.marshal(g, new File(ROOM_XML));
    }

    public static void launch() throws JAXBException, IOException, Exception {
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
            marshallClasses(g);
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
