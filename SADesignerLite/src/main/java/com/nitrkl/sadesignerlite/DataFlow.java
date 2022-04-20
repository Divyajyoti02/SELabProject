/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nitrkl.sadesignerlite;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
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
        double dy = position.bottomRight.y - position.topLeft.y;
        double dx = position.bottomRight.x - position.topLeft.x;
        double theta = Math.atan2(dy, dx), phi = Math.toRadians(40);
        double rho = theta + phi;
        int x, y;
        for(int j = 0; j < 2; j++) {
            x = (int) (position.bottomRight.x - 15 * Math.cos(rho));
            y = (int) (position.bottomRight.y - 15 * Math.sin(rho));
            g.drawLine(position.bottomRight.x, position.bottomRight.y, x, y);
            rho = theta - phi;
        }
        
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
