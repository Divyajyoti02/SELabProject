/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nitrkl.sadesignerlite;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author hp
 */
class DataProcess extends ShapeObj {
    public DataProcess(int x, int y, int width, int height) {
        type = Type.DataProcess;
        position = new Positions(x, y, width + x, height + y);
    }
    
    public DataProcess(Positions ps) {
        type = Type.DataProcess;
        position = ps;
    }
    
    public void draw(Graphics g){
        g.drawOval(position.topLeft.x, position.topLeft.y, position.bottomRight.x - position.topLeft.x, position.bottomRight.y - position.topLeft.y);
        
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
