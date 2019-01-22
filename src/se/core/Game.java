package se.core;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
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
    private static final JLabel DISPLAY_TOTAL = new JLabel();
    private static final JLabel DISPLAY_SEARCH_COUNT = new JLabel();
    private static final JLabel DISPLAY_PEEK_COUNT = new JLabel();
    private static final ArrayList<PeekButton> peek_buttons = new ArrayList();
    private static final ArrayList<SearchButton> search_buttons = new ArrayList();

    // constructor
    public Game(int numberOfRooms, int id, JPanel panel) {
        // set Game id
        this.id = id;
        // generate rooms
        roomArray = Room.roomArrayGenerator(numberOfRooms, panel);
        
        for (int btnNum = 0; btnNum < numberOfRooms; btnNum++) {
            this.peek_buttons.add(getRoom(Integer.parseInt("" + btnNum)).getPeekButton());
            this.search_buttons.add(getRoom(Integer.parseInt("" + btnNum)).getSearchButton());
        }
        
        JPanel feedback = new JPanel();
        setDisplayTotal();
        setDisplaySearchCount();
        setDisplayPeekCount();
        feedback.add(DISPLAY_TOTAL);
        feedback.add(DISPLAY_PEEK_COUNT);
        feedback.add(DISPLAY_SEARCH_COUNT);
        feedback.setLayout(new GridLayout());
        panel.add(feedback);
    }

    public static void setDisplayTotal() {
        DISPLAY_TOTAL.setText("Total: " + total);
    }

    public static void setDisplaySearchCount() {
        DISPLAY_SEARCH_COUNT.setText("Count Search: " + countSearch);
    }

    public static void setDisplayPeekCount() {
        DISPLAY_PEEK_COUNT.setText("Count Peek: " + countPeek);
    }

    // getters
    public static ArrayList<Room> getRoomArray() {
        return roomArray;
    }

    public int getId() {
        return id;
    }

    public static Room getRoom(int num) {
        return roomArray.get(num);
    }

    public static int getRoomId(int num) {
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

    public static ArrayList<PeekButton> getPeek_buttons() {
        return peek_buttons;
    }

    public static ArrayList<SearchButton> getSearch_buttons() {
        return search_buttons;
    }

    @Override
    public String toString() {
        return "Game{ \n" + "id=" + id + ",\n " + roomArray.toString() + '}';
    }

}
