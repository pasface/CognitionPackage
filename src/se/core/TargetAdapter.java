/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.core;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author nikki
 */
public class TargetAdapter extends XmlAdapter<AdaptedTarget, Target> {
    
    @Override
    public Target unmarshal(AdaptedTarget adaptedTarget) throws Exception {
        Target t= new Target(adaptedTarget.getName());
        t.setTargetId(adaptedTarget.getId());
        t.setIcon(IconFinder.setIconFinder(adaptedTarget.getIcon()));
        return t;
    }
    
    @Override
    public AdaptedTarget marshal(Target target) throws Exception {
        AdaptedTarget adaptedTarget = new AdaptedTarget();
        adaptedTarget.setName(target.getName());
        adaptedTarget.setId(target.getTargetId());
        adaptedTarget.setIcon(target.getName());
        return adaptedTarget;
    }
}
