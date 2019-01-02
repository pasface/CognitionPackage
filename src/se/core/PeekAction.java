/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.core;

import java.awt.event.ActionEvent;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.AbstractAction;
import se.controls.Controller;

/**
 *
 * @author nikki
 */
public class PeekAction extends AbstractAction {
    private static final int PEEK = 10, PEEKDURATION = 4000;
    Controller c = new Controller();
    
    public PeekAction(String shortDescription) {
        super();
        putValue(SHORT_DESCRIPTION, shortDescription);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        c.setTotal(PEEK);
        c.setCountPeek(1);
        System.out.println("Peeked at this: " + e);
        //gui.getLblTotal().setText(total+"");
        //gui.getLblPeek().setText(countPeek+"");
        //gui.getJlblIcon().setIcon(new javax.swing.ImageIcon(getClass().getResource("office2.jpg")));
        peekTimer();
    }
    
    public void peekTimer(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
        @Override
        public void run() {

        }
        }, PEEKDURATION);
    }
}
