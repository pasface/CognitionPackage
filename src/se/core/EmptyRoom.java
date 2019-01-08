/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.core;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

/**
 *
 * @author nikki
 */
public class EmptyRoom extends JLabel {

    public EmptyRoom() {
        super();
        this.setIcon(IconFinder.setIconFinder("default"));
        this.setBorder(BorderFactory.createTitledBorder(this.getName()));
        
    }

}
