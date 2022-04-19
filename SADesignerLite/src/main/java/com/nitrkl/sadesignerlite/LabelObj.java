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
class LabelObj extends ShapeObj {
    int labelCount;
    String text;
    int x, y;
    LabelObj(Point t){
        Name = "Hello WOrkld";
        type = Type.Label;
        x = t.x;
        y = t.y;
        position = new Positions(x, y, x, y);
    }
    
     public void draw(Graphics g){        
        //name
        if (Name != null) {
            FontMetrics fm = g.getFontMetrics();
            Rectangle2D strb = fm.getStringBounds(Name, g);
            System.out.println(Name);
            position.topLeft.x = (int) (x - strb.getWidth()/2); 
            position.topLeft.y = (int) (y + strb.getHeight()/2);
            position.bottomRight.x = (int) (x + strb.getWidth()/2);
            position.bottomRight.y = (int) (y - strb.getHeight()/2);
            g.drawString (Name,
                ((position.topLeft.x + position.bottomRight.x)/2 - fm.stringWidth(Name)/2),
                (int) ((position.topLeft.y + position.bottomRight.y)/2 + strb.getHeight()));
        }
        
    }
    
}
