package se.core;

import javax.swing.JLabel;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nikki
 */
//@XmlType(name = "Target")
public final class Target extends JLabel {

    private int targetId;

    public Target() {
        super.setName("");
        this.targetId = 0;
    }

    public Target(String name) {
        super.setName(name);
        this.targetId = 1;
    }

    public int getTargetId() {
        return targetId;
    }

    //@XmlElement(name = "Target_ID")
    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }

    @Override
    public String toString() {
        return '{' + getName() + '}';
    }

}
