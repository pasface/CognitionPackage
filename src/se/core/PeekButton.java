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
import javax.swing.JButton;

public class PeekButton extends JButton {
    
    private PeekAction a = new PeekAction(getName());

    public PeekButton(int id) {
        //peek settings
        super.setName("" + id);
        super.setAction(a);
        super.setText("Peek");
    }

    public PeekAction getA() {
        return a;
    }

    
}
