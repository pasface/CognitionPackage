/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.core;

import javax.swing.Action;
import javax.swing.JButton;

/**
 *
 * @author nikki
 */
public class PeekButton extends JButton {
    
    public PeekAction a = new PeekAction(getName());

    public PeekButton(int id) {
        PeekAction a = new PeekAction(getName());
        //peek settings
        super.setName("" + id);
        super.setAction(a);
        super.setText("Peek");
    }

}
