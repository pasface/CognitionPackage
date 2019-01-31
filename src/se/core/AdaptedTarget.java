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

public class AdaptedTarget {

    private String name;
    private String icon;

    @XmlAttribute
    public String getName() {
        return name;
    }
    @XmlAttribute
    public String getIcon() {
        return icon;
    }

    public void setName(String name) {
        this.name = name;
    }

    void setIcon(String icon) {
        this.icon = icon;
    }

}
