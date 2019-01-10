/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.core;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author nikki
 */
public class SearchAction extends AbstractAction {

    //
    private static final int SEARCH = 100;
    private ImageIcon icon;
    private JButton btn;

    //
    public SearchAction(String shortDescription) {
        super();
        putValue(SHORT_DESCRIPTION, shortDescription);
    }

    //
    @Override
    public void actionPerformed(ActionEvent e) {
        Game.setTotal(SEARCH);
        Game.setCountSearch();
        icon = IconFinder.setIconFinder("search");
        btn = (JButton) e.getSource();
        String name = btn.getName();
        Game.getRoom(Integer.parseInt(name) - 1).setRoomFaceIcon(icon);
        //System.out.println("Searched at this: " + e);
        int i = Game.getRoom(Integer.parseInt(name) - 1).getTarget().getTargetId();
        if (i == 1) {
            Game.getRoom(Integer.parseInt(name) - 1).setRoomPaneLevel(1);
            System.out.println(Game.getRoom(Integer.parseInt(name) - 1).getRoomPaneLevel());
            //layeredPane.moveToFront(dukeLabel);
        }
    }
}
