package se.core;

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

public class Indicator {
    // fields
    private final JLabel INDICATOR;
    
    public Indicator() {
        this.INDICATOR = new JLabel();
    }

    public Indicator(int x, int y, String image) {
        this.INDICATOR = new JLabel();
        this.INDICATOR.setSize(100,100);
        this.INDICATOR.setLocation(x, y);
        ImageIcon icon = new javax.swing.ImageIcon(Target.class.getResource(image));
        this.INDICATOR.setIcon(icon);
    }

    public JLabel getIndicator() {
        return INDICATOR;
    }

    @Override
    public String toString() {
        return "Indicator{" + getIndicator() + '}';
    }
    
}
