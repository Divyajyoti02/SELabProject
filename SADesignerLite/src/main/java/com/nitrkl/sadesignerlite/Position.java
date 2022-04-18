/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nitrkl.sadesignerlite;

import java.awt.Point;

/**
 *
 * @author hp
 */
public class Position {
    int x, y;
    
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Position(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    public Position() {}

    @Override
    public String toString() {
        return "(" + x + ", " + y + ')';
    }    
}
