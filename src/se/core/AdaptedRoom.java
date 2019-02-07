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
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class AdaptedRoom {

    private String roomName;
    private String roomIcon;
    private int roomId;
    private String target;
    private ArrayList<String> indicatorList;

    @XmlElement
    public String getRoomName() {
        return roomName;
    }

    @XmlElement
    public String getRoomIcon() {
        return roomIcon;
    }

    @XmlAttribute
    public int getRoomId() {
        return roomId;
    }

    @XmlElement(name = "target")
    public String getTarget() {
        return target;
    }

    @XmlElementWrapper(name = "indicatorList")
    @XmlElement(name = "indicator")
    public ArrayList<String> getIndicatorList() {
        return indicatorList;
    }

    public void setRoomName(String name) {
        this.roomName = name;
    }

    public void setRoomIcon(String icon) {
        this.roomIcon = icon;
    }

    public void setRoomId(int id) {
        this.roomId = id;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public void setIndicatorList(ArrayList<String> indicatorList) {
        this.indicatorList = indicatorList;
    }

}
