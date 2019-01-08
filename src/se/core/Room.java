package se.core;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
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
    private final EmptyRoom roomFace = new EmptyRoom();
    private final JButton peekButton = new JButton();
    private final JButton searchButton = new JButton();
    private ArrayList<Indicator> indicators;
    private Target target;
    private int roomId;
    //needs JLayeredPane
    private JLayeredPane dinglehopper = new JLayeredPane();
    private final JPanel roomPanel = new JPanel();

    // constructor
    public Room(ArrayList<Indicator> indicators, Target target, int id, JPanel panel) {
        roomFace.setName("" + id);
        
        //initialize fields
        this.indicators = indicators;
        this.target = target;
        this.roomId = id;
        
        //room settings
        roomPanel.add(target);
        for(Indicator indicator : indicators){
            roomPanel.add(indicator);
        }
        roomPanel.add(roomFace);
        
        //peek settings
        peekButton.setName(""+id);
        Action a = new PeekAction(peekButton.getName());
        peekButton.setAction(a);
        peekButton.setText("Peek");
        roomPanel.add(peekButton);
        //search settings
        searchButton.setName("" + id);
        Action b = new SearchAction(searchButton.getName());
        searchButton.setAction(b);
        searchButton.setText("Search");
        roomPanel.add(searchButton);
        roomPanel.setBorder(BorderFactory.createLineBorder(Color.PINK));
        roomPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        //roomPanel.setSize(new Dimension(700,500));
        //add room to frame
        panel.add(roomPanel);
    }
    
    // getters
    public ArrayList<Indicator> getIndicator() {
        return indicators;
    }
    
    public Target getTarget() {
        return target;
    }
    
    public int getRoomId(){
        return roomId;
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

    public void setRoomId(int id) {
        roomId = id;
    }

    public void setRoomFaceIcon(ImageIcon icon) {
        roomFace.setIcon(icon);
    }

    //toString
    @Override
    public String toString() {
        return "Room{" + "Rm id=" + roomId + ",  Target=" + target.toString() + ",  Indicators=" + indicators.toString() + "    \n";
    }
}