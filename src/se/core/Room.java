package se.core;

import java.awt.Color;
import java.util.ArrayList;
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
    private int id;
    private final JLabel roomFace;
    private final JPanel roomPanel = new JPanel();
    private ArrayList<Indicator> indicators;
    private Target target;
    private final JButton peekButton = new JButton();
    private final JButton seekButton = new JButton();
    
    // constructor
    public Room(ArrayList<Indicator> indicators, Target target, int id, JFrame f) {
        this.indicators = indicators;
        this.target = target;
        this.id = id;
        ImageIcon icon = new javax.swing.ImageIcon(Room.class.getResource("office.jpg"));
        this.roomFace = new JLabel();
        this.roomFace.setName("Room " + id);
        this.roomFace.setIcon(icon);
        this.roomFace.setBackground(Color.red);
        this.roomFace.setBorder(BorderFactory.createTitledBorder(roomFace.getName()));
        this.roomFace.setBounds(0, 0, 100, 100);
        this.roomPanel.add(this.target);
        this.roomPanel.add(roomFace);
        this.peekButton.setName("peek" + id);
        this.seekButton.setName("seek" + id);
        this.peekButton.setText("Peek");
        this.seekButton.setText("Search");
        roomPanel.add(peekButton);
        roomPanel.add(seekButton);
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