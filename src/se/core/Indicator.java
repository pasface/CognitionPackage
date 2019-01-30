package se.core;

import javax.swing.JLabel;
import javax.xml.bind.annotation.XmlAttribute;
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
@XmlType(name = "indicator")
public final class Indicator extends JLabel {
    @XmlAttribute(name = "indicatorId")
    private int inid;

    public Indicator(String name) {
        super.setName(name);
        super.setSize(100, 100);
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
