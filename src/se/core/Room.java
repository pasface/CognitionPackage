package se.core;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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
    private final JLayeredPane roomPane = new JLayeredPane();

    // constructor
    public Room(ArrayList<Indicator> indicators, Target target, int id, JPanel panel) {
        roomFace.setName("" + id);

        //initialize fields
        this.indicators = indicators;
        this.target = target;
        this.roomId = id;

        //peek settings
        peekButton.setName("" + id);
        Action a = new PeekAction(peekButton.getName());
        peekButton.setAction(a);
        peekButton.setText("Peek");
        
        //search settings
        searchButton.setName("" + id);
        Action b = new SearchAction(searchButton.getName());
        searchButton.setAction(b);
        searchButton.setText("Search");
        
        //layered pane settingss
        roomPane.setBorder(BorderFactory.createTitledBorder("Room " + id));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        //label placement vars
        int originPoint = 5;
        Point origin = new Point(originPoint, originPoint);
        int offset = 40;
        int roomFaceHeight = 278;
        int roomFaceWidth = 622;
        
        int buttonOffset = 90;
        int buttonWidth = 80;
        int buttonHeight = 30;
        Point buttonOrigin = new Point(roomFaceWidth-(buttonWidth*2)-originPoint, roomFaceHeight+10);
        
        //set bounds of components
        peekButton.setBounds(buttonOrigin.x, buttonOrigin.y, buttonWidth, buttonHeight);
        searchButton.setBounds((buttonOrigin.x + buttonOffset), buttonOrigin.y, buttonWidth, buttonHeight);
        roomFace.setBounds(origin.x, (origin.y), roomFaceWidth, roomFaceHeight);
        target.setBounds((origin.x + offset), (origin.y + offset), 140,140);
        
        // add to pane
        roomPane.add(roomFace);
        roomPane.add(peekButton);
        roomPane.add(searchButton);
        roomPane.add(target);

        //set level on pane
        roomPane.setComponentZOrder(peekButton, 0);
        roomPane.setComponentZOrder(searchButton, 1);
        roomPane.setComponentZOrder(roomFace, 2);
        roomPane.setComponentZOrder(target, 3);
        int paneLevel=4;
        
        for(Indicator indicator : indicators){
            roomPane.add(indicator);
            roomPane.setComponentZOrder(indicator, paneLevel);
            indicator.setBounds(origin.x, origin.y, 140,140);
            paneLevel++;
        }        
        
        panel.add(roomPane);
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