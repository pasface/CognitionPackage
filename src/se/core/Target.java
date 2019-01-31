package se.core;

import javax.swing.JLabel;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nikki
 */

@XmlJavaTypeAdapter(TargetAdapter.class)
public final class Target extends JLabel {
    private int targetId;
    private String targetName;

    public Target() {
        this.targetId = 0;
        this.targetName = "t";
    }

    public Target(String name) {
        super.setIcon(IconFinder.setIconFinder(name));
        super.setName(name);
        this.targetId = 1;
        this.targetName = name;
    }

    public int getTargetId() {
        return targetId;
    }
    public String getTargetName(){
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
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
