package se.core;

import java.security.SecureRandom;
import java.util.ArrayList;
import javax.swing.JFrame;

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
    private final ArrayList<Room> roomArray;
    private static final SecureRandom RAND = new SecureRandom();

    // constructor
    public Game(int numberOfRooms, int id, JFrame f) {
        // set Game id
        this.id = id;
        this.roomArray = roomArrayGenerator(numberOfRooms, f);
        // generate specified number of rooms in array list
        System.out.println(roomArray.toString());
    }

    // getters
    public ArrayList<Room> getRoomArray() {
        return roomArray;
    }

    public int getId() {
        return id;
    }

    // setters
    public void setId(int id) {
        this.id = id;
    }

    // methods
    // method to create and populate a room array
    private ArrayList<Room> roomArrayGenerator(int totalRooms, JFrame f){
        ArrayList<Room> r = new ArrayList();
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
            if ((randInt == 1 && b == false) || (currentRoom == totalRooms - 1 && b == false)) {
                Target t1 = new Target(30,30);
                r.add(new Room(modifiedIndicatorList(1), t1, (currentRoom + 1), f));
                //System.out.println("Placed target in room: " + (currentRoom+1));
                currentRoom++;
                b = true;
            } else {
                // enter empty target in current roomArray
                Target t0 = new Target();
                r.add(new Room(modifiedIndicatorList(0), t0, (currentRoom + 1), f));
                currentRoom++;
            }
        }
        return r;
    }

    // ArrayList that stores all possible Indicators
    public ArrayList<Indicator> indicatorList() {
        ArrayList<Indicator> indicators = new ArrayList();
        // create indicator objects (location x, location y, imagename)
        Indicator i0 = new Indicator(1, 1, "mug.png");
        Indicator i1 = new Indicator(2, 2, "pen.png");
        Indicator i2 = new Indicator(3, 3, "bird.png");
        Indicator i3 = new Indicator(4, 4, "tissue.png");
        Indicator i4 = new Indicator(5, 5, "bowl.png");
        
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

    @Override
    public String toString() {
        return "Game{ \n" + "id=" + id + ",\n " + roomArray.toString() +'}';
    }
    
}
