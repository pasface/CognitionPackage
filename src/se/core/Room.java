package se.core;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

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
    private final JLabel ROOM;
    private ArrayList<Indicator> indicators;
    private Target target;
    
    // constructor
    public Room(ArrayList<Indicator> indicators, Target target, int id) {
        this.indicators = indicators;
        this.target = target;
        this.id = id;
        this.ROOM = new JLabel();
        this.ROOM.setName("Room " + id);
        this.ROOM.setSize(100,100);
        this.ROOM.setLocation(1, 1);
        //ImageIcon icon = new javax.swing.ImageIcon(Target.class.getResource("office.png"));
        //this.ROOM.setIcon(icon);
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