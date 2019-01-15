package se.core;

import java.awt.Point;
import java.security.SecureRandom;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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
public final class Room {

    // fields
    private static final SecureRandom RAND = new SecureRandom();
    private final PeekButton peekButton;
    private final SearchButton searchButton;
    private final EmptyRoom roomFace = new EmptyRoom();
    private final JLayeredPane roomPane = new JLayeredPane();
    private final ArrayList<Indicator> indicators;
    private final Target target;
    private final int roomId;
    private static String state = "";

    // constructor
    public Room(ArrayList<Indicator> indicators, Target target, int id, JPanel panel) {
        roomFace.setName("" + id);

        //initialize fields
        this.indicators = indicators;
        this.target = target;
        this.roomId = id;

        //peek settings
        peekButton = new PeekButton(id);

        //search settings
        searchButton = new SearchButton(id);

        //layered pane settingss
        roomPane.setBorder(BorderFactory.createTitledBorder("Room " + id));

        //set level on pane
        this.setOrder(target, roomFace, indicators);
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

    public EmptyRoom getRoomFace() {
        return roomFace;
    }

    public PeekButton getPeekButton() {
        return peekButton;
    }

    // setters
    public void setRoomFaceIcon(ImageIcon icon) {
        roomFace.setIcon(icon);
    }

    public void setState(String state) {
        Room.state = state;
    }

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

    // ArrayList that builds and stores indicators for each room
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

    public ArrayList<JLabel> labelList(Target target, JLabel roomFace, ArrayList<Indicator> indicators) {
        ArrayList list = new ArrayList();
        list.add(roomFace);
        list.add(target);
        for (Indicator indicator : indicators) {
            list.add(indicator);
        }
        return list;
    }

    public void setOrder(Target target, JLabel roomFace, ArrayList<Indicator> indicators) {
        //function vars
        int order = 0;
        String s = "search";
        String p = "peek";

        //components placement vars
        int originPoint = 10;
        Point origin = new Point(originPoint, originPoint * 2);
        int offset = 40;
        int roomFaceHeight = 268;
        int roomFaceWidth = 612;
        int xy = 140;
        int buttonWidth = 80;
        int buttonHeight = 30;
        int buttonOffset = buttonWidth + 10;
        Point buttonOrigin = new Point(roomFaceWidth - (buttonWidth * 2), roomFaceHeight + originPoint);

        //set bounds of components
        peekButton.setBounds(buttonOrigin.x, (buttonOrigin.y + originPoint * 2), buttonWidth, buttonHeight);
        searchButton.setBounds((buttonOrigin.x + buttonOffset), (buttonOrigin.y + originPoint * 2), buttonWidth, buttonHeight);
        roomFace.setBounds(origin.x, origin.y, roomFaceWidth, roomFaceHeight);
        target.setBounds((origin.x + offset), (origin.y + offset), xy, xy);
        for (Indicator indicator : indicators) {
            
            int indiOffset = xy * indicator.getInId();
            indicator.setBounds((origin.x + indiOffset), (origin.y + 60), xy, xy);
        }

        //set component order
        roomPane.setComponentZOrder(peekButton, 0);
        roomPane.setComponentZOrder(searchButton, 1);
        ArrayList<JLabel> list = labelList(target, roomFace, indicators);
        for (JLabel item : list) {
            roomPane.setComponentZOrder(item, order);
            order++;
        }

        if (s.equals(Room.state)) { // search state
            roomPane.moveToFront(target);
            roomPane.moveToBack(roomFace);
            for (Indicator indicator : indicators) {
                roomPane.moveToBack(indicator);
            }
        } else if (p.equals(Room.state)) { // peek state
            for (Indicator indicator : indicators) {
                roomPane.moveToFront(indicator);
            }
            roomPane.moveToBack(roomFace);
            roomPane.moveToBack(target);
        } else {  // default state
            roomPane.moveToFront(roomFace);
        }
    }

    //toString
    @Override
    public String toString() {
        return "Room{" + "Rm id=" + roomId + ",  Target=" + target.toString() + ",  Indicators=" + indicators.toString() + "    \n";
    }
}
