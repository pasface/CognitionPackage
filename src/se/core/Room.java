package se.core;

import java.awt.GridBagConstraints;
import java.awt.Point;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nikki
 */
public class Room {

    // fields
    private static final SecureRandom RAND = new SecureRandom();
    private final EmptyRoom roomFace = new EmptyRoom();
    private final JButton peekButton = new JButton();
    private final JButton searchButton = new JButton();
    private ArrayList<Indicator> indicators;
    private static int indicatorId;
    private Target target;
    private int roomId;
    private int roomPaneLevel;
    private JLayeredPane roomPane = new JLayeredPane();

    // constructor
    public Room(ArrayList<Indicator> indicators, Target target, int id, JPanel panel) {
        roomFace.setName("" + id);

        //initialize fields
        this.indicators = indicators;
        this.target = target;
        this.roomId = id;

        //peek settings
        peekButton.setName("" + id);
        Action a = new PeekAction(peekButton.getName());
        peekButton.setAction(a);
        peekButton.setText("Peek");

        //search settings
        searchButton.setName("" + id);
        Action b = new SearchAction(searchButton.getName());
        searchButton.setAction(b);
        searchButton.setText("Search");

        //layered pane settingss
        roomPane.setBorder(BorderFactory.createTitledBorder("Room " + id));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        //label placement vars
        int originPoint = 10;
        Point origin = new Point(originPoint, originPoint * 2);
        int offset = 40;
        int roomFaceHeight = 268;
        int roomFaceWidth = 612;

        int buttonWidth = 80;
        int buttonHeight = 30;
        int buttonOffset = buttonWidth + 10;
        Point buttonOrigin = new Point(roomFaceWidth - (buttonWidth * 2), roomFaceHeight + originPoint);

        //set bounds of components
        peekButton.setBounds(buttonOrigin.x, (buttonOrigin.y + originPoint * 2), buttonWidth, buttonHeight);
        searchButton.setBounds((buttonOrigin.x + buttonOffset), (buttonOrigin.y + originPoint * 2), buttonWidth, buttonHeight);
        roomFace.setBounds(origin.x, origin.y, roomFaceWidth, roomFaceHeight);
        target.setBounds((origin.x + offset), (origin.y + offset), 140, 140);

        //set level on pane
        roomPane.setComponentZOrder(peekButton, 0);
        roomPane.setComponentZOrder(searchButton, 1);
        roomPane.setComponentZOrder(roomFace, 2);
        roomPane.setComponentZOrder(target, 3);
        int indiPaneLevel = 4;
        for (Indicator indicator : indicators) {
            int xy = 140;
            roomPane.add(indicator);
            roomPane.setComponentZOrder(indicator, indiPaneLevel);
            indiPaneLevel++;
            int indiOffset = xy * indicator.getInId();
            //System.out.println("Room: " + id + " Indi Name: " + indicator.getName() + " Indi Id: " + indicator.getInId());
            indicator.setBounds((origin.x + indiOffset), (origin.y + 60), xy, xy);
        }

            roomPane.moveToFront(target);
            roomPane.moveToBack(roomFace);

        //roomPane.setMinimumSize(new Dimension(1,1));
        panel.add(roomPane);
    }

    // getters
    public ArrayList<Indicator> getIndicator() {
        return indicators;
    }

    public Target getTarget() {
        return target;
    }

    public int getRoomId() {
        return roomId;
    }

    public JLabel getRoomFace() {
        return roomFace;
    }

    public static int getIndicatorId() {
        return indicatorId;
    }

    public int getRoomPaneLevel() {
        return roomPaneLevel;
    }

    // setters
    public void setIndicator(ArrayList<Indicator> indicators) {
        this.indicators = indicators;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public void setRoomId(int id) {
        roomId = id;
    }

    public void setRoomFaceIcon(ImageIcon icon) {
        roomFace.setIcon(icon);
    }

    public void setRoomPaneLevel(int roomPaneLevel) {
        this.roomPaneLevel = roomPaneLevel;
    }


    
    public static void setIndicatorId(int indicatorId) {
        Room.indicatorId = indicatorId;
    }

    // methods
    // method to create and populate a room array
    public static ArrayList<Room> roomArrayGenerator(int totalRooms, JPanel panel) {
        ArrayList<Room> r = new ArrayList();
        // create variable for roomArray number
        int currentRoom = 0;
        // create a bool to check if target exists
        boolean b = false;
        // while loop to randomize target location
        while (currentRoom < totalRooms) {
            int randInt = RAND.nextInt(3);
            ArrayList indicatorList;
            // randomly place a target into a roomArray 
            // (if no target built, 50% chancee to build a target in current roomArray
            //  OR if on last roomArray w/o target, build target in last roomArray)
            if ((randInt == 1 && b == false) || (currentRoom == totalRooms - 1 && b == false)) {
                Target t1 = new Target(30, 30);
                indicatorList = modifiedIndicatorList(1);
                r.add(new Room(indicatorList, t1, (currentRoom + 1), panel));
                currentRoom++;
                b = true;
            } else {
                // enter empty target in current roomArray
                Target t0 = new Target();
                indicatorList = modifiedIndicatorList(0);
                r.add(new Room(modifiedIndicatorList(0), t0, (currentRoom + 1), panel));
                currentRoom++;
            }
        }
        return r;
    }

    // ArrayList that stores all possible Indicators
    private static ArrayList<Indicator> indicatorList() {
        ArrayList<Indicator> indicators = new ArrayList();
        // create indicator objects (location x, location y, imagename)
        Indicator i0 = new Indicator(0, 0, "1");
        Indicator i1 = new Indicator(0, 0, "2");
        Indicator i2 = new Indicator(0, 0, "3");
        Indicator i3 = new Indicator(0, 0, "4");
        Indicator i4 = new Indicator(0, 0, "5");

        // add indicator objects to indicators list
        indicators.add(i0);
        indicators.add(i1);
        indicators.add(i2);
        indicators.add(i3);
        indicators.add(i4);
        // return indicator list
        return indicators;
    }

    // ArrayList that stores indicators for each room
    private static ArrayList<Indicator> modifiedIndicatorList(int i) {
        ArrayList<Indicator> modList = new ArrayList();
        int randInt;

        if (i == 0) {
            // used when target is not present
            boolean b = true;
            if (b == RAND.nextBoolean()) {
                // randomly add indicator to empty roomArray
                randInt = RAND.nextInt(indicatorList().size());
                modList.add(indicatorList().get(randInt));
                int currentPosition = 0;
                for (Indicator indi : modList) {
                    currentPosition++;
                    indi.setInId(currentPosition); 
                }
            }
            return modList;
        } else {
            // used when target is present
            // randomly add indicator from list of options
            randInt = RAND.nextInt(indicatorList().size());
            modList.add(indicatorList().get(randInt));
            // randomly add indicator from list of options
            randInt = RAND.nextInt(indicatorList().size());
            modList.add(indicatorList().get(randInt));
            int currentPosition = 0;
            for (Indicator indi : modList) {
                currentPosition++;
                indi.setInId(currentPosition);
            }
            return modList;
        }
    }

    //toString
    @Override
    public String toString() {
        return "Room{" + "Rm id=" + roomId + ",  Target=" + target.toString() + ",  Indicators=" + indicators.toString() + "    \n";
    }
}
