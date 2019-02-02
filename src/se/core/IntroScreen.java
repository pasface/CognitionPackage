/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.core;

/**
 *
 * @author Pas
 */
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

class IntroScreen extends JPanel {
    private static final JLabel welcomeLabel = new JLabel();

    public IntroScreen(JPanel panel) {
        setName("Welcome!");
        setBorder(BorderFactory.createTitledBorder(getName()));
        welcomeLabel.setText("Welcome! This application will help to determine ...  When you're ready to start just click on File -> New");
        add(welcomeLabel);
        panel.add(this);
    }

    @Override
    public String toString() {
        return "IntroScreen{" + '}';
    }
    
    
}
