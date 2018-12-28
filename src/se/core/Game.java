package se.core;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFrame;
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

public class Game {
    // fields
    private int id;
    private Room[] roomArray;
    private static final SecureRandom RAND = new SecureRandom();
    private JFrame f = new JFrame();
    private JPanel p = new JPanel();

    // constructor
    public Game(int numberOfRooms, int id) {
        // set Game id
        this.id = id;
        // generate specified number of roomArray
        roomArrayGenerator(numberOfRooms);
        // for testing purposes ******************
        String roomArrayString = Arrays.toString(roomArray);
        System.out.println("Game " + id + ":\n " + roomArrayString);
    }

    // getters
    public Room[] getRoomArray() {
        return roomArray;
    }

    public int getId() {
        return id;
    }

    // setters
    public void setRoomArray(int totalRooms) {
        this.roomArray = new Room[totalRooms];
    }

    public void setId(int id) {
        this.id = id;
    }

    // methods
    // method to create and populate a room array
    private Room[] roomArrayGenerator(int totalRooms) throws NullPointerException{
        // create a roomArray array
        setRoomArray(totalRooms);
        // create variable for roomArray number
        int currentRoom = 0;
        // create a bool to check if target exists
        boolean b = false;
        // while loop to randomize target location
        while (currentRoom < totalRooms) {
            int randInt = RAND.nextInt(3);
            // randomly place a target into a roomArray 
            // (if no target built, 50% chancee to build a target in current roomArray
            //  OR if on last roomArray w/o target, build target in last roomArray)
            if ((b == false && randInt == 1) || (currentRoom == totalRooms - 1 && b == false)) {
                Target target = new Target(30,30);
                roomArray[currentRoom] = new Room(modifiedIndicatorList(1), target, currentRoom + 1);
                currentRoom++;
                b = true;
            } else {
                // enter empty target in current roomArray
                roomArray[currentRoom] = new Room(modifiedIndicatorList(0), new Target(), currentRoom + 1);
                currentRoom++;
            }
        }
        return roomArray;
    }

    // ArrayList that stores all possible Indicators
    public ArrayList<Indicator> indicatorList() {
        ArrayList<Indicator> indicators = new ArrayList();
        // create indicator objects
        Indicator i0 = new Indicator(0, "I:0");
        Indicator i1 = new Indicator(101, "I:Green");
        Indicator i2 = new Indicator(102, "I:Purple");
        Indicator i3 = new Indicator(103, "I:Red");
        Indicator i4 = new Indicator(104, "I:Orange");
        Indicator i5 = new Indicator(105, "I:Blue");
        Indicator i6 = new Indicator(106, "I:Magenta");
        // add indicator objects to indicators list
        indicators.add(i0);
        indicators.add(i1);
        indicators.add(i2);
        indicators.add(i3);
        indicators.add(i4);
        indicators.add(i5);
        indicators.add(i6);
        // return indicator list
        return indicators;
    }

    // ArrayList that stores indicators for each room
    public ArrayList<Indicator> modifiedIndicatorList(int i) {
        ArrayList<Indicator> modList = new ArrayList();
        int randInt;
        if (i == 0) {
            // used when target is not present
            boolean b = true;
            if (b == RAND.nextBoolean()) {
                // randomly add indicator to empty roomArray
                randInt = RAND.nextInt(indicatorList().size());
                modList.add(indicatorList().get(randInt));
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
            return modList;
        }
    }
}
