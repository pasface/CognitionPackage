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
import static se.core.Room.setIcon;

/**
 *
 * @author nikki
 */
public class PeekAction extends AbstractAction {
    private static final int PEEK = 10, PEEKDURATION = 4000;
    private static final IconFinder i = new IconFinder();
    
    public PeekAction(String shortDescription) {
        super();
        putValue(SHORT_DESCRIPTION, shortDescription);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Game.setTotal(PEEK);
        Game.setCountPeek();
        //change path
        //i.setIcon();
        peekTimer();
        
        System.out.println("Peeked at this: " + e);
    }
    
    public void peekTimer(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
        @Override
        public void run() {
            //change path
        }
        }, PEEKDURATION);
    }
}
