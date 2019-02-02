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
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class SearchAction extends AbstractAction {

    //fields
    private static final int SEARCH = new ComponentSettings().getSEARCH();
    private ImageIcon icon;
    private JButton btn;
    private final String stateName = "search";

    //constructor
    public SearchAction(String shortDescription) {
        super();
        super.putValue(SHORT_DESCRIPTION, shortDescription);
    }

    //button action
    @Override
    public void actionPerformed(ActionEvent e) {
        Game.incrementTotal(SEARCH);
        Game.incrementCountSearch();
        icon = IconFinder.setIconFinder(stateName);
        btn = (JButton) e.getSource();
        String name = btn.getName();
        Room r = Game.getRoom(Integer.parseInt(name) - 1);
        
        //cancel peek timer
        PeekAction p = r.getPeekButton().getA();
        p.timer.cancel();
        r.setState(stateName);
        Target target = r.getTarget();
        JLabel roomface = r.getRoomFace();
        ArrayList<Indicator> indicator = r.getIndicator();
        r.orderComponents(target, roomface, indicator);
        r.setRoomFaceIcon(icon);
        int i = r.getTarget().getTargetId();
        r.getPeekButton().setVisible(false);
        r.getSearchButton().setVisible(false);
        if (i == 1) {
            for (int x=0; x<Game.getPeek_buttons().size(); x++){
                Game.getPeek_buttons().get(x).setVisible(false);
                Game.getSearch_buttons().get(x).setVisible(false);
            }

            System.out.println("target found.");
        }
    }
}
