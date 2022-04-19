/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nitrkl.sadesignerlite;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.util.Arrays;

/**
 *
 * @author hp
 */
class ExternalOutput extends ShapeObj {
    public ExternalOutput(int x, int y, int width, int height) {
        type = Type.ExternalOutput;
        position = new Positions(x, y, x + width, y + height);
    }
    
    public ExternalOutput(Positions ps) {
        type = Type.ExternalOutput;
        position = ps;
    }
    
    public void draw(Graphics g){
        int x1 = position.topLeft.x , y1 = position.topLeft.y, x2 = position.bottomRight.x, y2 = position.bottomRight.y;
        if (x1 < x2 && y1 < y2) {
            int xs[] = {(3*x1 + x2)/4, x2, (x1+ 3*x2)/4, x1}, ys[] = {y1, y1, y2, y2};
            g.drawPolygon(xs, ys, 4);
        
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
}
