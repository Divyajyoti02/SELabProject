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
    
    public void draw(Graphics2D g){
        System.out.println("DrawinfpaRAL");
        Path2D.Double parallelogram = new Path2D.Double();
        int x1 = position.topLeft.x , y1 = position.topLeft.y, x2 = position.bottomRight.x, y2 = position.bottomRight.x;
        if (x1 < x2 && y1 < y2) {
        parallelogram.moveTo(x1, y2);
        parallelogram.lineTo((3*x1 + x2)/4,y1);
        parallelogram.lineTo(x2, y1);
        parallelogram.lineTo((x1+ 3*x2)/4, y2);
        parallelogram.closePath();
        g.draw(parallelogram);
        
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
