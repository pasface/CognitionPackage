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

public final class Indicator extends JLabel {
    private int inid;
    
    public Indicator() {
        super.setName("");
    }

    public Indicator(int x, int y, String name) {
        inid = this.getInId();
        super.setName(""+name);
        super.setSize(100,100);
        super.setLocation(x, y);
        super.setIcon(IconFinder.setIconFinder(name));
    }

    public int getInId() {
        return inid;
    }

    public void setInId(int id) {
        inid = id;
    }

    @Override
    public String toString() {
        return '{' + getName() + '}';
    }
    
}
