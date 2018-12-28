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
    private static JLabel TARGET = new JLabel();

    public Target() {
        TARGET.setSize(1,1);
    }

    public Target(int x, int y) {
        TARGET.setSize(100,100);
        TARGET.setLocation(x, y);
        ImageIcon icon = new javax.swing.ImageIcon(Target.class.getResource("targetS.png"));
        TARGET.setIcon(icon);
    }

    public JLabel getTARGET() {
        return TARGET;
    }

    @Override
    public String toString() {
        return "Target{" + getTARGET() + '}';
    }
    
}