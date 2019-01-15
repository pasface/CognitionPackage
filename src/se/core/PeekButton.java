/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.core;

import javax.swing.JButton;

/**
 *
 * @author nikki
 */
public class PeekButton extends JButton {

    public PeekButton(int id) {
        //peek settings
        super.setName("" + id);
        PeekAction a = new PeekAction(super.getName());
        super.setAction(a);
        super.setText("Peek");
    }
    
}
