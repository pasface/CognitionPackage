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
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class TargetAdapter extends XmlAdapter<AdaptedTarget, Target> {
    
    @Override
    public Target unmarshal(AdaptedTarget adaptedTarget) throws Exception {
        Target t= new Target(adaptedTarget.getTargetName());
        t.setTargetId(adaptedTarget.getTargetId());
        t.setIcon(IconFinder.setIconFinder(adaptedTarget.getTargetIcon()));
        System.out.println("AdaptedTarget unmarshal");
        return t;
    }
    
    @Override
    public AdaptedTarget marshal(Target target) throws Exception {
        AdaptedTarget adaptedTarget = new AdaptedTarget();
        adaptedTarget.setTargetName(target.getName());
        adaptedTarget.setTargetId(target.getTargetId());
        adaptedTarget.setTargetIcon(target.getName());
        System.out.println("AdaptedTarget marshal");
        return adaptedTarget;
    }
}
