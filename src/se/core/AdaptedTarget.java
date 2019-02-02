/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.core;

/**
 *
 * @author nikki
 */
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class AdaptedTarget {

    private String targetName;
    private String targetIcon;
    private int targetId;

    @XmlElement
    public String getTargetName() {
        return targetName;
    }

    @XmlElement
    public String getTargetIcon() {
        return targetIcon;
    }

    @XmlAttribute
    public int getTargetId() {
        return targetId;
    }

    public void setTargetName(String name) {
        this.targetName = name;
    }

    void setTargetIcon(String icon) {
        this.targetIcon = icon;
    }

    void setTargetId(int id) {
        this.targetId = id;
    }

}
