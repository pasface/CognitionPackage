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
public class SearchButton extends JButton {

    public SearchButton(int id) {
        super.setName("" + id);
        Action b = new SearchAction(super.getName());
        super.setAction(b);
        super.setText("Search");
    }

}
