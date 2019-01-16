/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.core;

import java.awt.Point;

/**
 *
 * @author nikki
 */
public class Settings extends Point {

    //component placement vars
    int rfH = 268;
    int rfW = 580;
    int itemHW = 140;
    int btnW = 85;
    int btnH = 30;
    int origin = 10;
    int offset = 40;

    public int getRfH() {
        return rfH;
    }

    public void setRfH(int rfH) {
        this.rfH = rfH;
    }

    public int getRfW() {
        return rfW;
    }

    public void setRfW(int rfW) {
        this.rfW = rfW;
    }

    public int getItemHW() {
        return itemHW;
    }

    public void setItemHW(int itemHW) {
        this.itemHW = itemHW;
    }

    public int getBtnW() {
        return btnW;
    }

    public void setBtnW(int btnW) {
        this.btnW = btnW;
    }

    public int getBtnH() {
        return btnH;
    }

    public void setBtnH(int btnH) {
        this.btnH = btnH;
    }

    public int getOrigin() {
        return origin;
    }

    public void setOrigin(int origin) {
        this.origin = origin;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

}
