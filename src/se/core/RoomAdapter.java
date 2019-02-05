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
        ArrayList<Indicator> indiList = null;
        for (int count = 0; count < adaptedRoom.getIndicatorList().size(); count++){
            indiList.add(r.getIndicatorList().get(count));
            System.out.println("indiList: "+indiList);
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
