/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nitrkl.sadesignerlite;

/**
 *
 * @author Divyajyoti Panda, Leo Raphael Rodrigues
 */
public class Positions {
    private Position topLeft, bottomRight;

    public Positions(int x1, int y1, int x2, int y2) {
        this.topLeft = new Position(x1, y1);
        this.bottomRight = new Position(x2, y2);
    }

    public Position getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(int x1, int y1) {
        this.topLeft = new Position(x1, y1);
    }

    public Position getBottomRight() {
        return bottomRight;
    }

    public void setBottomRight(int x2, int y2) {
        this.bottomRight = new Position(x2, y2);
    }

    @Override
    public String toString() {
        return "Positions{" + "topLeft=" + topLeft + ", bottomRight=" + bottomRight + '}';
    }
    
    
}
