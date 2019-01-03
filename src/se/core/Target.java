package se.core;

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

public class Target extends JLabel{
    // fields
    private final JLabel target;

    public Target() {
        this.target = new JLabel();
        this.target.setName("");
    }

    public Target(int x, int y) {
        String iconPath = "images/targetS.png";
        this.target = new JLabel();
        this.target.setName(iconPath);
        this.target.setLocation(x, y);
        this.target.setIcon(IconFinder.setIconFinder(iconPath));
    }

    public JLabel getTarget() {
        return target;
    }

    @Override
    public String toString() {
        return '{' + getTarget().getName() + '}';
    }
    
}