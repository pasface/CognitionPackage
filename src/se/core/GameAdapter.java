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
        ComponentSettings cs = new ComponentSettings();
        return new Game(cs.getNumOfGames(), GameId.getGameId(), new JPanel());
    }

    @Override
    public AdaptedGame marshal(Game game) throws Exception {
        AdaptedGame adaptedGame = new AdaptedGame();
        Room r = Game.getRoom(Integer.parseInt(game.getClass().getName()) - 1);
        adaptedGame.setRoomName(game.getClass().getName());
        return adaptedGame;
    }

}
