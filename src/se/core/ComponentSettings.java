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

    // cost vars
    private static final int SEARCH = 100;
    private static final int PEEKS = 10;
    
    //getters
    public int getRfH() {
        return rfH;
    }

    public int getRfW() {
        return rfW;
    }

    public int getItemHW() {
        return itemHW;
    }

    public int getBtnW() {
        return btnW;
    }

    public int getBtnH() {
        return btnH;
    }

    public int getOrigin() {
        return origin;
    }

    public int getOffset() {
        return offset;
    }

    public int getNumOfGames() {
        return numOfGames;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int getGap() {
        return gap;
    }

    public static int getSEARCH() {
        return SEARCH;
    }

    public static int getPEEKS() {
        return PEEKS;
    }

    //setters
    public void setRfH(int rfH) {
        this.rfH = rfH;
    }

    public void setRfW(int rfW) {
        this.rfW = rfW;
    }

    public void setItemHW(int itemHW) {
        this.itemHW = itemHW;
    }

    public void setBtnW(int btnW) {
        this.btnW = btnW;
    }

    public void setBtnH(int btnH) {
        this.btnH = btnH;
    }

    public void setOrigin(int origin) {
        this.origin = origin;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public void setNumOfGames(int numOfGames) {
        this.numOfGames = numOfGames;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public void setGap(int gap) {
        this.gap = gap;
    }

    //add resize code here
    public void resize(int x, int y) {

    }

}
