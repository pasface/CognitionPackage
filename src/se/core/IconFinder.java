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
    
    public static final ImageIcon setIconFinder(String image){
        try {
            return icon(image);
        } catch (NullPointerException e) {
            System.out.print(e);
        }
        return null;
    }
    
    public static ImageIcon icon(String image){
        String S;
        switch (image){
            case "default": S = "images/office.jpg";
            break;
            case "peek": S = "images/office2.jpg";
            break;
            case "search": S = "images/office3.jpg";
            break;
            case "indi1": S = "images/bird.png";
            break;
            case "indi2": S = "images/bowl.png";
            break;
            case "indi3": S = "images/mug.png";
            break;
            case "indi4": S = "images/pen.png";
            break;
            case "indi5": S = "images/tissue.png";
            break;
            case "target": S = "images/targetS.png";
            break;
            case "targetLarge": S = "images/target.png";
            break;
            default : S = "images/office.jpg";
        }
        return new javax.swing.ImageIcon(IconFinder.class.getResource(S));
    }
    
}
