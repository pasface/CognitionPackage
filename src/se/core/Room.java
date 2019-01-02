package se.core;

import java.awt.Color;
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
        this.roomFace = new JLabel();
        this.roomFace.setName("Room " + id);
        this.roomFace.setIcon(setIcon("office.jpg"));
        this.roomFace.setBackground(Color.red);
        this.roomFace.setBorder(BorderFactory.createTitledBorder(roomFace.getName()));
        this.roomPanel.add(target.getTarget());
        for(Indicator indicator : indicators){
            this.roomPanel.add(indicator.getIndicator());
        }       
        this.roomPanel.add(roomFace);
        this.peekButton.setName("peek" + id);
        this.seekButton.setName("seek" + id);
        this.peekButton.setText("Peek");
        this.seekButton.setText("Search");
        Action a = new PeekAction("Peekin");
        this.peekButton.setAction(a);
        
        roomPanel.add(peekButton);
        roomPanel.add(seekButton);
        f.add(roomPanel);
    }
    
    public static final ImageIcon setIcon(String iconPath){
        try {
            ImageIcon icon = new javax.swing.ImageIcon(Room.class.getResource(iconPath));
            return icon;
        } catch (NullPointerException e) {
            System.out.print(e);
        }
        return null;
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

    private void print(Indicator n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}