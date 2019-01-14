/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.core;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author nikki
 */
public class SearchAction extends AbstractAction {

    //
    private static final int SEARCH = 100;
    private ImageIcon icon;
    private JButton btn;
    private final String stateName = "search";

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
        icon = IconFinder.setIconFinder(stateName);
        btn = (JButton) e.getSource();
        String name = btn.getName();
        Room r = Game.getRoom(Integer.parseInt(name) - 1);
        r.setRoomFaceIcon(icon);
        //System.out.println("Searched at this: " + e);
        int i = r.getTarget().getTargetId();
        if (i == 1) {
            r.setState(stateName);
            Target target = r.getTarget();
            JLabel roomface = r.getRoomFace();
            ArrayList<Indicator> indicator = r.getIndicator();
            r.setOrder(target, roomface, indicator);
        }
    }
}
