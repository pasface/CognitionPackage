/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.core;

import java.util.ArrayList;
import javax.swing.JPanel;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author nikki
 */
public class RoomAdapter extends XmlAdapter<AdaptedRoom, Room> {

    @Override
    public Room unmarshal(AdaptedRoom adaptedRoom) throws Exception {
        //indicators, target, id, panel
        JPanel panel = new JPanel();
        ComponentSettings cs = new ComponentSettings();
        ArrayList<Indicator> indiList = null;
        Target targ = new Target(adaptedRoom.getTarget());
        Room r = new Room(indiList, targ, cs.getNumOfGames(), panel);
        r.setRoomId(adaptedRoom.getRoomId());
        r.setIcon(IconFinder.setIconFinder(adaptedRoom.getRoomIcon()));
        for (int count = 0; count < adaptedRoom.getIndicatorList().size(); count++) {
            indiList.add(new Indicator(adaptedRoom.getIndicatorList().get(count)));
        }
        r.setIndicators(indiList);
        return r;
    }

    @Override
    public AdaptedRoom marshal(Room room) throws Exception {
        AdaptedRoom adaptedRoom = new AdaptedRoom();
        adaptedRoom.setRoomName(room.getName());
        adaptedRoom.setRoomId(room.getRoomId());
        adaptedRoom.setRoomIcon(room.getName());
        adaptedRoom.setTarget(room.getTarget().getName());
        ArrayList<String> indi = new ArrayList<>();
        for (int count = 0; count < room.getIndicatorList().size(); count++) {
            indi.add(room.getIndicatorList().get(count).getName());
        }
        adaptedRoom.setIndicatorList(indi);
        return adaptedRoom;
    }
}
