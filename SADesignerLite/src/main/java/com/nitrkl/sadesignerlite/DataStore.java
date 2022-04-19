/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nitrkl.sadesignerlite;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author hp
 */
class DataStore extends ShapeObj {
    public DataStore(int x, int y, int width, int height) {
        type = Type.DataStore;
        position = new Positions(x, y, x + width, y + height);
    }
    
    public DataStore(Positions ps) {
        type = Type.DataStore;
        position = ps;
    }
    
    public void draw(Graphics g){
        g.drawLine(position.topLeft.x, position.topLeft.y, position.bottomRight.x, position.topLeft.y);
        g.drawLine(position.topLeft.x, position.bottomRight.y, position.bottomRight.x, position.bottomRight.y);
        
        //name
        if (Name != null) {
            FontMetrics fm = g.getFontMetrics();
            Rectangle2D strb = fm.getStringBounds(Name, g);
            g.drawString (Name,
                ((position.topLeft.x + position.bottomRight.x)/2 - fm.stringWidth(Name)/2),
                (int) ((position.topLeft.y + position.bottomRight.y)/2 - strb.getHeight()));
        }
    }
}
