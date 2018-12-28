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

public class Target{
    // fields
    private final JLabel TARGET;

    public Target() {
        this.TARGET = new JLabel();
    }

    public Target(int x, int y) {
        this.TARGET = new JLabel();
        this.TARGET.setSize(100,100);
        this.TARGET.setLocation(x, y);
        ImageIcon icon = new javax.swing.ImageIcon(Target.class.getResource("targetS.png"));
        this.TARGET.setIcon(icon);
    }

    public JLabel getTARGET() {
        return TARGET;
    }

    @Override
    public String toString() {
        return "Target{" + getTARGET() + '}';
    }
    
}