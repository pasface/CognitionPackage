/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.core;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author nikki
 */
public class SearchAction extends AbstractAction{
    private static final int SEARCH = 100;
    
    public SearchAction(String shortDescription) {
        super();
        putValue(SHORT_DESCRIPTION, shortDescription);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Game.setTotal(SEARCH);
        Game.setCountSearch();
        
        System.out.println("Searched at this: " + e);
    }
}
