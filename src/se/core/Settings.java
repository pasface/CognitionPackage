/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.core;

import java.awt.Point;

/**
 *
 * @author nikki
 */
public class Settings extends Point {

    //room dimensions
    private final int roomFaceHeight = 268;
    private final int roomFaceWidth = 612;
    
    //item dimensions
    private final int itemXY = 140;
    
    //button dimensions
    private final int buttonWidth = 80;
    private final int buttonHeight = 30;
    
    //origins
    private final int origin = 10;
    
    //points
    private final Point originPoint = new Point(origin, origin * 2);
    private final Point buttonOrigin = new Point(roomFaceWidth - (buttonWidth * 2), roomFaceHeight + origin);
    
    //offsets
    private final int offset = 40;
    private final int buttonOffset = buttonWidth + 10;
    
    
    
    private int peekY = (buttonOrigin.y + origin * 2);
    

//    peekButton.setBounds(buttonOrigin.x, (buttonOrigin.y + originPoint * 2), buttonWidth, buttonHeight);
//    searchButton.setBounds((buttonOrigin.x + buttonOffset), (buttonOrigin.y + originPoint * 2), buttonWidth, buttonHeight);
//    roomFace.setBounds(origin.x, origin.y, roomFaceWidth, roomFaceHeight);
//    target.setBounds((origin.x + offset), (origin.y + offset), xy, xy);

}
