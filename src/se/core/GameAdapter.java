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
public class GameAdapter extends XmlAdapter<AdaptedGame, Game> {

    @Override
    public Game unmarshal(AdaptedGame adaptedGame) throws Exception {
        JPanel panel = new JPanel();
        ComponentSettings cs = new ComponentSettings();
        ArrayList<Room> roomList = null;
        Game g = new Game(cs.getNumOfRooms(), 1, panel);
        g.setGameId(adaptedGame.getGameId());
        for (int count = 0; count < adaptedGame.getRoomList().size(); count++) {
            roomList.add(new Room());
        }
        g.setRoomList(roomList);
        return g;
    }

        @Override
        public AdaptedGame marshal(Game game) throws Exception {
        AdaptedGame adaptedGame = new AdaptedGame();
        adaptedGame.setGameId(game.getGameId());
        ArrayList roomList = new ArrayList<>();
        for (int count = 0; count < game.getRoomList().size(); count++){
            roomList.add(game.getRoomList().get(count).getName());
        }
        adaptedGame.setRoomList(roomList);
        return adaptedGame;
    }
}
