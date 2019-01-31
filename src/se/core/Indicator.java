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
    private int indicatorId;
    private String name;

    public Indicator(String name) {
        super.setName(name);
        super.setSize(100, 100);
        super.setIcon(IconFinder.setIconFinder(name));
    }

    public int getIndicatorId() {
        return indicatorId;
    }

    public void setIndicatorId(int id) {
        indicatorId = id;
    }

    @Override
    public String toString() {
        return '{' + getName() + '}';
    }

}
