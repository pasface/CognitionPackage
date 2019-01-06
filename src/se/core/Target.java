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

    public Target() {
        setName("");
    }

    public Target(int x, int y) { 
        String icon = "target";
        setName(icon);
        setLocation(x, y);
        setIcon(IconFinder.setIconFinder(icon));
    }

    @Override
    public String toString() {
        return '{' + getName() + '}';
    }
    
}