/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.


Reference: http://blog.bdoughan.com/2010/12/jaxb-and-immutable-objects.html

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
        ComponentSettings cs = new ComponentSettings();
        return new Game(cs.getNumOfGames(), GameId.getGameId(), new JPanel());
    }

    @Override
    public AdaptedGame marshal(Game game) throws Exception {
        AdaptedGame adaptedGame = new AdaptedGame();
        String name = ("Room " + game.getRoom(1).getRoomId());
        adaptedGame.setRoomName(name);
        adaptedGame.setTargetName(Game.getRoom(1).getTarget().getName());
        return adaptedGame;
    }

}
