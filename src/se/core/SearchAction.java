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

    //constructor
    public SearchAction(String shortDescription) {
        super();
        super.putValue(SHORT_DESCRIPTION, shortDescription);
    }

    //button action
    @Override
    public void actionPerformed(ActionEvent e) {
        //set method vars
        JButton btn = (JButton) e.getSource();
        String name = btn.getName();
        Room r = Game.getStaticRoom(Integer.parseInt(name) - 1);
        JLabel roomface = r.getRoomFace();
        Target target = r.getTarget();
        ArrayList<Indicator> indicator = r.getIndicator();
        final String stateName = "search";
        
        //update total and search count
        final int SEARCH = new ComponentSettings().getSEARCH();
        Game.incrementTotal(SEARCH);
        Game.incrementCountSearch();
        
        //cancel peek timer 
        PeekAction p = r.getPeekButton().getA();
        p.timer.cancel();
        
        //set state
        r.setState(stateName);
        
        //set order of components
        r.orderComponents(target, roomface, indicator);
        
        //set to search icon
        ImageIcon icon = IconFinder.setIconFinder(stateName);  
        r.setRoomFaceIcon(icon);
        
        //hide room buttons after searching room
        r.getPeekButton().setVisible(false);
        r.getSearchButton().setVisible(false);
        
        //if target found, hide all buttons
        int i = r.getTarget().getTargetId();
        if (i == 1) {
            for (int x=0; x<Game.getPeek_buttons().size(); x++){
                //cancel all peek timers
                PeekAction peek = Game.getPeek_buttons().get(x).getA();
                peek.timer.cancel();
                //remove all buttons
                Game.getPeek_buttons().get(x).setVisible(false);
                Game.getSearch_buttons().get(x).setVisible(false);
            }
        }
    }
}
