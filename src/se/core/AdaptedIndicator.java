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

public class AdaptedIndicator {

    private String name;
    private String icon;
    private int id;

    @XmlElement
    public String getName() {
        return name;
    }

    @XmlElement
    public String getIcon() {
        return icon;
    }

    @XmlAttribute
    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    void setIcon(String icon) {
        this.icon = icon;
    }

    void setId(int id) {
        this.id = id;
    }

}
