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
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlJavaTypeAdapter(TargetAdapter.class)
public final class Target extends JLabel {
    private int targetId;

    public Target() {
        super(IconFinder.setIconFinder(""));
        super.setName("");
        this.targetId = 0;
    }

    public Target(String name) {
        super.setIcon(IconFinder.setIconFinder(name));
        super.setName(name);
        this.targetId = 1;
    }

    public int getTargetId() {
        return targetId;
    }

    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }

    @Override
    public void setIcon(Icon icon) {
        super.setIcon(icon);
    }
    
    @Override
    public String toString() {
        return '{' + getName() + '}';
    }

}
