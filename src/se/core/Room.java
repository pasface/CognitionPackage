package se.core;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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
    private int id;
    private final JLabel roomFace;
    private final JPanel roomPanel = new JPanel();
    private ArrayList<Indicator> indicators;
    private Target target;
    
    // constructor
    public Room(ArrayList<Indicator> indicators, Target target, int id, JFrame f) {
        this.indicators = indicators;
        this.target = target;
        this.id = id;
        ImageIcon icon = new javax.swing.ImageIcon(Room.class.getResource("office.jpg"));
        this.roomFace = new JLabel();
        this.roomFace.setName("Room " + id);
        this.roomFace.setSize(100, 100);
        this.roomFace.setLocation(1, 1);
        this.roomFace.setIcon(icon);
        this.roomFace.setBorder(BorderFactory.createTitledBorder("purple"));
        roomPanel.add(roomFace);
        roomPanel.setBackground(Color.BLACK);
        f.add(roomPanel);
        //ImageIcon icon = new javax.swing.ImageIcon(Target.class.getResource("office.png"));
        //this.roomFace.setIcon(icon);
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
    
    //toString
    @Override
    public String toString() {
        return "Room{" + "id=" + id + ",  Target=" + target.toString() + ",  Indicators=" + indicators.toString() + "    \n";
    }


}