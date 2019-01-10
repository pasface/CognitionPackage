package se.core;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JLabel;
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
    private static ArrayList<Room> roomArray;
    private static int countSearch = 0, countPeek = 0, total = 0;
    private static final JLabel displayTotal = new JLabel();
    private static final JLabel displaySearchCount = new JLabel();
    private static final JLabel displayPeekCount = new JLabel();
    
    // constructor
    public Game(int numberOfRooms, int id, JPanel panel) {
        // set Game id
        this.id = id;
        // generate rooms (total number of rooms, swing frame)
        roomArray = Room.roomArrayGenerator(numberOfRooms, panel);
        JPanel feedback = new JPanel();
        setDisplayTotal();
        setDisplaySearchCount();
        setDisplayPeekCount();
        feedback.add(displayTotal);
        feedback.add(displayPeekCount);
        feedback.add(displaySearchCount);
        feedback.setLayout(new GridLayout());
        panel.add(feedback);
        //append xml file with new game info
    }
    
    public static void setDisplayTotal(){
        displayTotal.setText("Total: " + total);
    }    
    
    public static void setDisplaySearchCount(){
        displaySearchCount.setText("Count Search: " + countSearch);
    }
    
    public static void setDisplayPeekCount(){
        displayPeekCount.setText("Count Peek: "  + countPeek);
    }
    
    // getters
    public static ArrayList<Room> getRoomArray() {
        return roomArray;
    }

    public int getId() {
        return id;
    }
    
    public static Room getRoom(int num){
        return roomArray.get(num);
    }
    
    public static int getRoomId(int num){
        return roomArray.get(num).getRoomId();
    }
    // setters
    public void setId(int id) {
        this.id = id;
    }

    public int getCountSearch() {
        return countSearch;
    }

    public static void setCountSearch() {
        Game.countSearch += 1;
        setDisplaySearchCount();
    }

    public int getCountPeek() {
        return countPeek;
    }

    public static void setCountPeek() {
        Game.countPeek += 1;
        setDisplayPeekCount();
    }

    public int getTotal() {
        return total;
    }

    public static void setTotal(int total) {
        Game.total += total;
        setDisplayTotal();
    }
    

    
    @Override
    public String toString() {
        return "Game{ \n" + "id=" + id + ",\n " + roomArray.toString() +'}';
    }
    
}
