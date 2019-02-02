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

    private String indicatorName;
    private String indicatorIcon;
    private int indicatorId;

    @XmlElement
    public String getIndicatorName() {
        return indicatorName;
    }

    @XmlElement
    public String getIndicatorIcon() {
        return indicatorIcon;
    }

    @XmlAttribute
    public int getIndicatorId() {
        return indicatorId;
    }

    public void setIndicatorName(String name) {
        this.indicatorName = name;
    }

    void setIndicatorIcon(String icon) {
        this.indicatorIcon = icon;
    }

    void setIndicatorId(int id) {
        this.indicatorId = id;
    }

}
