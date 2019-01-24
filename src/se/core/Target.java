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

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "target")
public final class Target extends JLabel{
    
    private int targetId;
    
    public Target() {
        super.setName("");
        this.targetId = 0;
    }

    public Target(int x, int y) { 
        String icon = "target";
        super.setName(icon);
        //super.setIcon(IconFinder.setIconFinder(icon));
        this.targetId = 1;
    }

    public int getTargetId() {
        return targetId;
    }

    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }

    @Override
    public String toString() {
        return '{' + getName() + '}';
    }
    
}