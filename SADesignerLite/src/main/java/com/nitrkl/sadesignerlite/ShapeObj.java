/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nitrkl.sadesignerlite;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author hp
 */

class ShapeObj {
    String Name;
    Positions position;
    Type type;
    WorkArea decompose;
    ArrayList<ShapeObj> inDataFlow, outDataFlow;
    VarType varType;
    
    ShapeObj() {
        inDataFlow = new ArrayList<>();
        outDataFlow = new ArrayList<>();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.Name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ShapeObj other = (ShapeObj) obj;
        return Objects.equals(this.Name, other.Name);
    }

    void rename() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void deleteObj() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Rectangle2D getBounds2D() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    boolean isdrawn() {
        return (position.bottomRight.x - position.topLeft.x > 10 && position.bottomRight.y - position.topLeft.y > 10);
    }

    void resize(Point p) {
        position.bottomRight = new Position(p);
    }

    void move(int x1, int y1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    boolean contains(Point p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public ShapeObj containsName(String name) {
        for (ShapeObj s: inDataFlow) if (s.Name.equals(name)) return s;
        for (ShapeObj s: outDataFlow) if (s.Name.equals(name)) return s;
        return null;
    }

    public void draw(Graphics g){
        g.drawOval(position.topLeft.x, position.topLeft.y, position.bottomRight.x - position.topLeft.x, position.bottomRight.y - position.topLeft.y);
    }
}
