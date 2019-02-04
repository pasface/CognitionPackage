package se.core;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nikki
 */
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Game {

    // fields
    @XmlAttribute()
    private int gameIdIntended = 3;
    @XmlElementWrapper(name = "roomList")
    @XmlElement(name = "room")
    private ArrayList<Room> roomList;
    private static ArrayList<Room> roomListStatic;
    private static int countSearch = 0, countPeek = 0, total = 0;
    private static final JLabel DISPLAY_TOTAL = new JLabel();
    private static final JLabel DISPLAY_SEARCH_COUNT = new JLabel();
    private static final JLabel DISPLAY_PEEK_COUNT = new JLabel();
    private static final ArrayList<PeekButton> PEEK_BUTTONS = new ArrayList<>();
    private static final ArrayList<SearchButton> SEARCH_BUTTONS = new ArrayList<>();

    // constructors
    public Game() {
    }

    public Game(int numberOfRooms, int id, JPanel panel) {
        // generate rooms
        roomList = Room.roomArrayGenerator(numberOfRooms, panel);
        roomListStatic = roomList;
        //add peek/search buttons
        for (int btnNum = 0; btnNum < numberOfRooms; btnNum++) {
            Game.PEEK_BUTTONS.add(getRoom(Integer.parseInt("" + btnNum)).getPeekButton());
            Game.SEARCH_BUTTONS.add(getRoom(Integer.parseInt("" + btnNum)).getSearchButton());
        }

        //feedback settings
        JPanel feedback = new JPanel();
        displayTotal();
        displaySearchCount();
        displayPeekCount();
        feedback.add(DISPLAY_TOTAL);
        feedback.add(DISPLAY_PEEK_COUNT);
        feedback.add(DISPLAY_SEARCH_COUNT);
        feedback.setLayout(new GridLayout());
        panel.add(feedback);
    }

    // getters
    public int getGameId() {
        return gameIdIntended;
    }

    public static Room getRoom(int num) {
        return roomListStatic.get(num);
    }

    public static ArrayList<PeekButton> getPeek_buttons() {
        return PEEK_BUTTONS;
    }

    public static ArrayList<SearchButton> getSearch_buttons() {
        return SEARCH_BUTTONS;
    }

    // setters
    public static void setCountSearch(int countSearch) {
        Game.countSearch = countSearch;
    }

    public static void setCountPeek(int countPeek) {
        Game.countPeek = countPeek;
    }

    public static void setTotal(int total) {
        Game.total = total;
    }

    public void setGameId(int gameId) {
        this.gameIdIntended = gameId;
    }

    //class methods
    public static void resetCounts() {
        Game.total = 0;
        Game.countPeek = 0;
        Game.countSearch = 0;
        Game.displayTotal();
        Game.displaySearchCount();
        Game.displayPeekCount();
    }

    public static void displayTotal() {
        DISPLAY_TOTAL.setText("Total: " + total);
    }

    public static void displaySearchCount() {
        DISPLAY_SEARCH_COUNT.setText("Count Search: " + countSearch);
    }

    public static void displayPeekCount() {
        DISPLAY_PEEK_COUNT.setText("Count Peek: " + countPeek);
    }

    public static void incrementCountPeek() {
        Game.countPeek += 1;
        displayPeekCount();
    }

    public static void incrementCountSearch() {
        Game.countSearch += 1;
        displaySearchCount();
    }

    public static void incrementTotal(int total) {
        Game.total += total;
        displayTotal();
    }

    @Override
    public String toString() {
        return "{Game id=" + this.gameIdIntended + ",\n " + roomList.toString() + '}';
    }

}
