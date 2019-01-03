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
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author nikki
 */
public class PeekAction extends AbstractAction {
    //fields
    private static final int PEEK = 10, PEEKDURATION = 2000;
    private ImageIcon icon;
    private JButton btn;
    
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
        icon = IconFinder.setIconFinder("images/office2.jpg");
        btn = (JButton) e.getSource();
        String name = btn.getName();
        Game.getRoom(Integer.parseInt(name)-1).setRoomFaceIcon(icon);
        peekTimer(e);
        System.out.println("Peeked at this: " + e);
    }
    
    public void peekTimer(ActionEvent e){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
        @Override
        public void run() {
            icon = IconFinder.setIconFinder("images/office.jpg");
            btn = (JButton) e.getSource();
            String name = btn.getName();
            System.out.println(name);
            Game.getRoom(Integer.parseInt(name)-1).setRoomFaceIcon(icon);
        }
        }, PEEKDURATION);
    }
}
