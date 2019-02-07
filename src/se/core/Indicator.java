package se.core;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nikki
 */
import javax.swing.JLabel;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlJavaTypeAdapter(IndicatorAdapter.class)
public final class Indicator extends JLabel {
    private int indicatorId;

    public Indicator(String name) {
        super.setName(name);
        super.setSize(100, 100);
        super.setIcon(IconFinder.setIconFinder(name));
    }

    public int getIndicatorId() {
        return indicatorId;
    }

    public void setIndicatorId(int id) {
        indicatorId = id;
    }

    @Override
    public String toString() {
        return '{' + getName() + '}';
    }

}
