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

public class Indicator {
    // fields
    private int num;
    private String name;

    // constructor
    public Indicator(int num, String name) {
        this.num = num;
        this.name = name;
    }
    
    // getters
    public int getNum() {
        return num;
    }    
    
    public String getName() {
        return name;
    }
    
    // setters
    public void setNum(int num) {
        this.num = num;
    }

    public void setName(String name) {
        this.name = name;
    }

    // toString
    @Override
    public String toString() {
        return "{" + "num=" + num + ", name=" + name + '}';
    }
    
}
