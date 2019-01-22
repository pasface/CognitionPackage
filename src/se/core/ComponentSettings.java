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
public class ComponentSettings {

    //component placement vars
    private int rfH = 268; //roomface height
    private int rfW = 580; //roomface width
    private int itemHW = 140; //item (targets and indicators) height/width
    private int btnW = 85; //button width
    private int btnH = 30; //button height
    private int origin = 10; //origin point
    private int offset = 40; //offset

    // game vars
    private int numOfGames = 6; //number of games
    private int rows = 3; //number of room rows
    private int cols = 3; //number of room columns
    private int gap = 7; //gap between rooms

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

    //add resize code here
    public void resize(int x, int y) {

    }

    public int getNumOfGames() {
        return numOfGames;
    }

    public void setNumOfGames(int numOfGames) {
        this.numOfGames = numOfGames;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public int getGap() {
        return gap;
    }

    public void setGap(int gap) {
        this.gap = gap;
    }

}
