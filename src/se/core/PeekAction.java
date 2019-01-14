/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.core;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author nikki
 */
public class PeekAction extends AbstractAction {

    //fields
    private static final int PEEK = 10, PEEKDURATION = 2000;
    private ImageIcon icon;
    private JButton btn;
    private final String stateName = "peek";

    //constructor
    public PeekAction(String shortDescription) {
        super();
        putValue(SHORT_DESCRIPTION, shortDescription);

    }

    //Action events
    @Override
    public void actionPerformed(ActionEvent e) {
        Game.setTotal(PEEK);
        Game.setCountPeek();
        icon = IconFinder.setIconFinder(stateName);
        btn = (JButton) e.getSource();
        String name = btn.getName();
        Room r = Game.getRoom(Integer.parseInt(name) - 1);
        r.setRoomFaceIcon(icon);

        peekTimer(e);

    }

    public void peekTimer(ActionEvent e) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                icon = IconFinder.setIconFinder(stateName);
                btn = (JButton) e.getSource();
                String name = btn.getName();
                //System.out.println(name);
                Room r = Game.getRoom(Integer.parseInt(name) - 1);
                r.setRoomFaceIcon(icon);
                r.setState(stateName);
                Target target = r.getTarget();
                JLabel roomface = r.getRoomFace();
                ArrayList<Indicator> indicator = r.getIndicator();
                r.setOrder(target, roomface, indicator);

            }
        }, PEEKDURATION);
    }
}
