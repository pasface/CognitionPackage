/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.core;

import java.util.ArrayList;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author nikki
 */
public class RoomAdapter extends XmlAdapter<AdaptedRoom, Room> {

    @Override
    public Room unmarshal(AdaptedRoom adaptedRoom) throws Exception {
        Room r = new Room(adaptedRoom.getRoomName());
        r.setRoomId(adaptedRoom.getRoomId());
        r.setIcon(IconFinder.setIconFinder(adaptedRoom.getRoomIcon()));
        r.setTarget(new Target(adaptedRoom.getTarget()));
        //indiList = adaptedRoom.getIndicator();
        //r.setIndicators(indiList);
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
        for (int count = 0; count < room.getIndicator().size(); count++) {
            indi.add(room.getIndicator().get(count).getName());
        }
        adaptedRoom.setIndicatorList(indi);
        return adaptedRoom;
    }
}
