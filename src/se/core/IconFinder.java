/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.core;

/**
 *
 * @author nikki
 */
import javax.swing.ImageIcon;

public class IconFinder extends ImageIcon {
    private static String S = "";
    
    public static final ImageIcon setIconFinder(String image){
        try {
            return icon(image);
        } catch (NullPointerException e) {
            System.out.println(" null_icon ");
        }
        return null;
    }
    
    public static ImageIcon icon(String image){
        switch (image){
            case "default": S = "images/office.jpg";
            break;
            case "peek": S = "images/office2.jpg";
            break;
            case "search": S = "images/office3.jpg";
            break;
            case "1": S = "images/bird.png";
            break;
            case "2": S = "images/bowl.png";
            break;
            case "3": S = "images/mug.png";
            break;
            case "4": S = "images/pen.png";
            break;
            case "5": S = "images/tissue.png";
            break;
            case "target": S = "images/targetS.png";
            break;
            case "targetLarge": S = "images/target.png";
            break;
            default : S = "images/office.jpg";
        }
        return new javax.swing.ImageIcon(IconFinder.class.getResource(S));
    }

    public static String getS() {
        return S;
    }

    public static void setS(String S) {
        IconFinder.S = S;
    }
    
}
