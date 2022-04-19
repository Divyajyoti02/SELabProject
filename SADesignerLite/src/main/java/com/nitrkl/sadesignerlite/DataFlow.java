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
class DataFlow extends ShapeObj {
    ShapeAnchor start, end;
    
    public DataFlow() {
        type = Type.DataFlow;
    }
    
    public DataFlow(Point p1, Point p2) {
        type = Type.ExternalEntity;
        position = new Positions(p1.x, p1.y, p2.x, p2.y);
    }
}
