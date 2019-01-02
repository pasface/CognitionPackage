/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.core;

import javax.swing.ImageIcon;

/**
 *
 * @author nikki
 */
public class IconFinder extends ImageIcon {
    
    public static final ImageIcon setIcon(String iconPath){
        try {
            ImageIcon icon = new javax.swing.ImageIcon(Room.class.getResource(iconPath));
            return icon;
        } catch (NullPointerException e) {
            System.out.print(e);
        }
        return null;
    }
}
