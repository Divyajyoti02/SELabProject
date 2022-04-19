/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nitrkl.sadesignerlite;

/**
 *
 * @author hp
 */
class ExternalEntity extends ShapeObj {
    public ExternalEntity(int x, int y, int width, int height) {
        type = Type.ExternalEntity;
        position = new Positions(x, y, x + width, y + height);
    }
    
    public ExternalEntity(Positions ps) {
        type = Type.ExternalEntity;
        position = ps;
    }
}
