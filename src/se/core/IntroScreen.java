/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.core;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import se.core.IconFinder;

/**
 *
 * @author Pas
 */
class IntroScreen {
    private static final JPanel introPanel = new JPanel();
    private static final JLabel welcomeLabel = new JLabel();

    public IntroScreen(JFrame frame) {
        introPanel.setName("Welcome!");
        introPanel.setBorder(BorderFactory.createTitledBorder(introPanel.getName()));
        introPanel.setBackground(Color.DARK_GRAY);
        welcomeLabel.setText("Welcome! This application will help to determine ...  When you're ready to start just click on File -> New");
        welcomeLabel.setIcon(IconFinder.setIconFinder("images/office3.jpg"));
        introPanel.add(welcomeLabel);
        frame.add(introPanel);
        
    }
    
    
}
