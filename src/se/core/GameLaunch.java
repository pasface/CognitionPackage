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

/**
 *
 * @author nikki
 */
import java.awt.Color;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.awt.GridLayout;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.xml.bind.Unmarshaller;

public class GameLaunch {

    private static final JFrame FRAME = new MyFrame();
    private static JPanel gamePanel = new JPanel();
    private static IntroScreen introPanel;
    private static final String ROOM_XML = "./room-jaxb.xml";
    private static int incrementId;

    public static void main(String[] args) throws JAXBException {
        FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FRAME.setLayout(new GridLayout());
        introPanel = new IntroScreen(new JPanel());
        FRAME.add(introPanel);
        //FRAME.add(gamePanel);
        FRAME.setVisible(true);
        FRAME.setBackground(Color.yellow);
        introPanel.setBackground(Color.red);
        gamePanel.setBackground(Color.MAGENTA);
        unmarshallFile(ROOM_XML);
        gamePanel.removeAll();
    }

    public static void open() throws JAXBException, IOException {
        //ensure gamepanel is off so we don't create new games on top of old ones
        FRAME.remove(introPanel);
        gamePanel.removeAll();

        //reset game counters
        Game.resetCounts();

        //set layout and gap spaces
        ComponentSettings cs = new ComponentSettings();
        
        //set layout and gap spaces
        GridLayout roomLayout = new GridLayout(cs.getRows(), cs.getCols());
        roomLayout.setHgap(cs.getGap());
        roomLayout.setVgap(cs.getGap());
        gamePanel = new JPanel();
        gamePanel.setLayout(roomLayout);
        gamePanel.setVisible(true);

        //Create a file chooser
        final JFileChooser fc = new JFileChooser();
        int a = fc.showOpenDialog(null);
        if (a == JFileChooser.APPROVE_OPTION) {

            //getting the xml file to read
            File fileToOpen = fc.getSelectedFile();
            //creating the JAXB context
            JAXBContext jContext = JAXBContext.newInstance(Game.class);
            //creating the unmarshall object
            Unmarshaller unmarshallerObj = jContext.createUnmarshaller();

            //calling the unmarshall method
            Game g = (Game) unmarshallerObj.unmarshal(fileToOpen);
            gamePanel = Game.getPanel();
            System.out.println();
            System.out.println("Open: " + g.toString());
        }
        //remove intro screen and add gamePanel
        FRAME.add(gamePanel);
        FRAME.validate();
    }

    public static void unmarshallFile(String fileName) throws JAXBException {
        //getting the xml file to read
        File file = new File(fileName);
        //creating the JAXB context
        JAXBContext jContext = JAXBContext.newInstance(Game.class);
        //creating the unmarshall object
        Unmarshaller unmarshallerObj = jContext.createUnmarshaller(); 

        //calling the unmarshall method
        Game g = (Game) unmarshallerObj.unmarshal(file);
        //set incrementor for the gameId
        incrementId = g.getGameId();
        System.out.print("UnmarshallFile: " + g.toString());
    }

    public static void marshallClasses(Game g) {
        try {
            // create JAXB context and instantiate marshaller
            JAXBContext context = JAXBContext.newInstance(Game.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Write to System.out
            //m.marshal(g, System.out);
            
            // Write to File
            m.marshal(g, new File(ROOM_XML));
        } catch (JAXBException ex) {
            Logger.getLogger(GameLaunch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void launch() throws JAXBException, IOException, Exception {
        //remove former rooms
        FRAME.remove(introPanel);
        gamePanel.removeAll();
        //reset game counters
        Game.resetCounts();

        //ensure gamepanel is off so we don't create new games on top of old ones
        ComponentSettings cs = new ComponentSettings();

        //set layout and gap spaces
        GridLayout roomLayout = new GridLayout(cs.getRows(), cs.getCols());
        roomLayout.setHgap(cs.getGap());
        roomLayout.setVgap(cs.getGap());
        gamePanel = Game.getPanel();
        gamePanel.setLayout(roomLayout);
        gamePanel.setVisible(true);
        
        incrementId+=1;
        
        //create new game
        Game g = new Game(cs.getNumOfRooms(), incrementId);

        //marshal game
        marshallClasses(g);

        //remove intro screen and add gamePanel
        FRAME.add(gamePanel);
        FRAME.validate();
        System.out.println("launched game: " + g.toString());
    }

}
