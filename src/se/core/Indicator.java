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

public class Indicator extends JLabel {
    
    public Indicator() {
        setName("");
    }

    public Indicator(int x, int y, String image) {
        setName(image);
        setSize(100,100);
        setLocation(x, y);
        setIcon(IconFinder.setIconFinder(image));
    }

    @Override
    public String toString() {
        return '{' + getName() + '}';
    }
    
}
