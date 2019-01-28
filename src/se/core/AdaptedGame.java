/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.core;

import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 * @author nikki
 */
class AdaptedGame {
    
    private String roomName;
    private String targetName;
    
    @XmlAttribute
    public String getName() {
        return roomName;
    }

    public void setName(String name) {
        this.roomName = name;
    }

    public String getTargetName() {
        return targetName;
    }

}
