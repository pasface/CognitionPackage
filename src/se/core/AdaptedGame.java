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

public class AdaptedGame {

    private int gameId;
    private ArrayList<String> roomList;

    public int getGameId() {
        return gameId;
    }

    @XmlAttribute
    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    @XmlElementWrapper(name = "roomList")
    @XmlElement(name = "room")
    public ArrayList<String> getRoomList() {
        return roomList;
    }

    public void setRoomList(ArrayList<String> roomList) {
        this.roomList = roomList;
    }

}
