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
import javax.swing.JPanel;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class RoomAdapter extends XmlAdapter<AdaptedRoom, Room> {

    @Override
    public Room unmarshal(AdaptedRoom adaptedRoom) throws Exception {
        JPanel panel = new JPanel();
        ComponentSettings cs = new ComponentSettings();
        ArrayList<Indicator> indiList = new ArrayList<>();
        Target targ = new Target(adaptedRoom.getTarget());
        for (int count = 0; count < adaptedRoom.getIndicatorList().size(); count++) {
            indiList.add(new Indicator(adaptedRoom.getIndicatorList().get(count)));
        }
        Room r = new Room(indiList, targ, cs.getNumOfRooms(), panel);
        r.setRoomId(adaptedRoom.getRoomId());
        r.setIcon(IconFinder.setIconFinder(""));
        r.setIndicators(indiList);
        //System.out.println("\nAdaptedRoom unmarshal");
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
        //System.out.println("\nAdaptedRoom marshal");
        return adaptedRoom;
    }
}
