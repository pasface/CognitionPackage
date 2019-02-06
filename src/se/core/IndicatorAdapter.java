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

public class IndicatorAdapter extends XmlAdapter<AdaptedIndicator, Indicator> {

    @Override
    public Indicator unmarshal(AdaptedIndicator adaptedIndicator) throws Exception {
        Indicator i= new Indicator(adaptedIndicator.getIndicatorName());
        i.setIndicatorId(adaptedIndicator.getIndicatorId());
        i.setIcon(IconFinder.setIconFinder(adaptedIndicator.getIndicatorIcon()));
        System.out.println("AdaptedIndicator unmarshal");
        return i;
    }

    @Override
    public AdaptedIndicator marshal(Indicator indicator) throws Exception {
        AdaptedIndicator adaptedIndicator = new AdaptedIndicator();
        adaptedIndicator.setIndicatorName(indicator.getName());
        adaptedIndicator.setIndicatorId(indicator.getIndicatorId());
        adaptedIndicator.setIndicatorIcon(indicator.getName());
        System.out.println("AdaptedIndicator marshal");
        return adaptedIndicator;
    }

}
