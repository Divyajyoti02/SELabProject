/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nitrkl.sadesignerlite;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Rectangle2D;

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
        type = Type.DataFlow;
        position = new Positions(p1.x, p1.y, p2.x, p2.y);
    }
    
    public void draw(Graphics g){
        g.drawLine(position.topLeft.x, position.topLeft.y, position.bottomRight.x, position.bottomRight.y);
        g.drawRect(position.bottomRight.x, position.bottomRight.y, 15, 15);
        
        //name
        if (Name != null) {
            FontMetrics fm = g.getFontMetrics();
            Rectangle2D strb = fm.getStringBounds(Name, g);
            g.drawString (Name,
                ((position.topLeft.x + position.bottomRight.x)/2 - fm.stringWidth(Name)/2),
                (int) ((position.topLeft.y + position.bottomRight.y)/2 + strb.getHeight()));
        }
    }
}
