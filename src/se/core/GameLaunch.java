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
import java.awt.Desktop;
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
import javax.swing.filechooser.FileSystemView;
import javax.xml.bind.Unmarshaller;

public class GameLaunch {

    private static final JFrame FRAME = new MyFrame();
    private static JPanel gamePanel = new JPanel();
    private static boolean b = false;
    private static IntroScreen introPanel;
    private static final String ROOM_XML = "./room-jaxb.xml";
    private static int incrementId;

    public static void main(String[] args) throws JAXBException {
        FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FRAME.setLayout(new GridLayout());
        introPanel = new IntroScreen(new JPanel());
        FRAME.add(introPanel);
        FRAME.add(gamePanel);
        FRAME.setVisible(true);
        unmarshallFile(ROOM_XML);
        
    }

    public static void open() throws JAXBException, IOException {
        //ensure gamepanel is off so we don't create new games on top of old ones
        gamePanel.setVisible(false);
        FRAME.remove(gamePanel);

        //reset game counters
        Game.resetCounts();

        //set layout and gap spaces
        ComponentSettings cs = new ComponentSettings();
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
            File fileToOpen = fc.getSelectedFile();
            Desktop.getDesktop().open(fileToOpen);
            //create new game
            //creating the JAXB context
            JAXBContext jContext = JAXBContext.newInstance(Game.class);
            //creating the unmarshall object
            Unmarshaller unmarshallerObj = jContext.createUnmarshaller();
            //calling the unmarshall method
            Game g = (Game) unmarshallerObj.unmarshal(fileToOpen);
            gamePanel.add(g.getRoom(0).getRoomFace());
            System.out.println(g.getRoom(0).toString() );
        }
        //remove intro screen and add gamePanel
        FRAME.remove(introPanel);
        FRAME.add(gamePanel);
        FRAME.validate();
        setBool(false);
    }

    public static void unmarshallFile(String fileName) throws JAXBException {
//        Game g = new Game();
//        try {
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
            System.out.print(g.toString());
//        } catch (JAXBException ex) {
//            Logger.getLogger(GameLaunch.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return g;
    }

    public static void marshallClasses(Game g)  {
        try {
            // create JAXB context and instantiate marshaller
            JAXBContext context = JAXBContext.newInstance(Game.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            
            // Write to System.out
            m.marshal(g, System.out);
            
            // Write to File
            m.marshal(g, new File(ROOM_XML));
        } catch (JAXBException ex) {
            Logger.getLogger(GameLaunch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void launch() throws JAXBException, IOException, Exception {
        //ensure gamepanel is off so we don't create new games on top of old ones
        gamePanel.setVisible(false);
        FRAME.remove(gamePanel);
        //if launch is ready, start game
        if (isBool() == true) {
            //reset game counters
            Game.resetCounts();

            //set layout and gap spaces
            ComponentSettings cs = new ComponentSettings();
            GridLayout roomLayout = new GridLayout(cs.getRows(), cs.getCols());
            roomLayout.setHgap(cs.getGap());
            roomLayout.setVgap(cs.getGap());
            gamePanel = new JPanel();
            gamePanel.setLayout(roomLayout);
            gamePanel.setVisible(true);

            //create new game
            Game g = new Game(cs.getNumOfGames(), incrementId + 1, gamePanel);

            //marshal game
            marshallClasses(g);

            //remove intro screen and add gamePanel
            FRAME.remove(introPanel);
            FRAME.add(gamePanel);
            FRAME.validate();
            setBool(false);
            System.out.println("launched game: "+g.toString());
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
