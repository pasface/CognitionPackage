/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.core;

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
        Game g = new Game(adaptedGame.getRoomList().size(), adaptedGame.getGameId(), panel);
        g.setGameId(adaptedGame.getGameId());
        g.setRoomList(adaptedGame.getRoomList());
        System.out.println("AdaptedGame unmarshal");
        return g;
    }

    @Override
    public AdaptedGame marshal(Game game) throws Exception {
        AdaptedGame adaptedGame = new AdaptedGame();
        adaptedGame.setGameId(game.getGameId());
        adaptedGame.setRoomList(game.getRoomList());
        System.out.println("AdaptedGame marshal");
        return adaptedGame;
    }
}
