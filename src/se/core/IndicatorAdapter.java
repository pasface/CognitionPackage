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
public class IndicatorAdapter extends XmlAdapter<AdaptedIndicator, Indicator> {

    @Override
    public Indicator unmarshal(AdaptedIndicator adaptedIndicator) throws Exception {
        return new Indicator(adaptedIndicator.getName());
    }

    @Override
    public AdaptedIndicator marshal(Indicator indicator) throws Exception {
        AdaptedIndicator adaptedIndicator = new AdaptedIndicator();
        adaptedIndicator.setName(indicator.getName());
        return adaptedIndicator;
    }

}
