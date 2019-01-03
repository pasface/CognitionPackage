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
    private static ImageIcon iconFinder;

    public IconFinder(ImageIcon icon) {
        IconFinder.iconFinder = icon;
    }
    
    public static final ImageIcon setIconFinder(String iconPath){
        try {
            iconFinder = new javax.swing.ImageIcon(Room.class.getResource(iconPath));
            return iconFinder;
        } catch (NullPointerException e) {
            System.out.print(e);
        }
        return null;
    }

    public static ImageIcon getIconFinder() {
        return iconFinder;
    }
    
    
}
