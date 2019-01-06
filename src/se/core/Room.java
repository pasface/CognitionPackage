package se.core;

import java.util.ArrayList;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
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

public class Room {
    // fields
    private JLabel roomFace;
    private final JPanel roomPanel = new JPanel();
    private final JButton peekButton = new JButton();
    private final JButton searchButton = new JButton();
    private ArrayList<Indicator> indicators;
    private Target target;
    private int id;

    public Room() {
        this.roomFace = new JLabel();
    }

    // constructor
    public Room(ArrayList<Indicator> indicators, Target target, int id, JFrame f) {
        //initialize fields
        this.indicators = indicators;
        this.target = target;
        this.id = id;
        //room settings
        this.roomFace = new JLabel();
        this.roomFace.setName("" + id);
        this.roomFace.setIcon(IconFinder.setIconFinder("default"));
        this.roomFace.setBorder(BorderFactory.createTitledBorder(roomFace.getName()));
        this.roomPanel.add(target.getTarget());
        for(Indicator indicator : indicators){
            this.roomPanel.add(indicator.getIndicator());
        }
        this.roomPanel.add(roomFace);
        //peek settings
        this.peekButton.setName(""+id);
        Action a = new PeekAction(peekButton.getName());
        this.peekButton.setAction(a);
        this.peekButton.setText("Peek");
        roomPanel.add(peekButton);
        //search settings
        this.searchButton.setName("" + id);
        Action b = new SearchAction(searchButton.getName());
        this.searchButton.setAction(b);
        this.searchButton.setText("Search");
        roomPanel.add(searchButton);
        //add room to frame
        f.add(roomPanel);
    }
    
    // getters
    public ArrayList<Indicator> getIndicator() {
        return indicators;
    }
    
    public Target getTarget() {
        return target;
    }
    
    public int getId(){
        return id;
    }

    public JLabel getRoomFace() {
        return roomFace;
    }
    
    // setters
    public void setIndicator(ArrayList<Indicator> indicators) {
        this.indicators = indicators;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRoomFaceIcon(ImageIcon icon) {
        this.roomFace.setIcon(icon);
    }

    //toString
    @Override
    public String toString() {
        return "Room{" + "Rm id=" + id + ",  Target=" + target.toString() + ",  Indicators=" + indicators.toString() + "    \n";
    }
}