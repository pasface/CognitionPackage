/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author nikki
 */
public class PeekAction extends AbstractAction implements ActionListener {

    //fields
    private static final int PEEK = new ComponentSettings().getPEEKS(), PEEKDURATION = 2000;
    private ImageIcon icon;
    private JButton btn;
    public Timer timer = new Timer();

    //constructor
    public PeekAction(String shortDescription) {
        super();
        super.putValue(SHORT_DESCRIPTION, shortDescription);
    }

    //Action events
    @Override
    public void actionPerformed(ActionEvent e) {
        Game.incrementTotal(PEEK);
        Game.incrementCountPeek();
        resetLabels("peek", e);
        int dingus = Integer.parseInt(btn.getName()) -1;
        //if searchbtn clicked cancel timer
        
        //if (){

        //}
        peekTimer(e);
    }

    public void peekTimer(ActionEvent e) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                resetLabels("default", e);
            }
        }, PEEKDURATION);
    }

    public void resetLabels(String s, ActionEvent e) {
        btn = (JButton) e.getSource();
        String name = btn.getName();
        Room r = Game.getRoom(Integer.parseInt(name) - 1);
        icon = IconFinder.setIconFinder(s);
        r.setRoomFaceIcon(icon);
        r.setState(s);
        Target target = r.getTarget();
        JLabel roomface = r.getRoomFace();
        ArrayList<Indicator> indicator = r.getIndicator();
        r.orderComponents(target, roomface, indicator);
    }

}
