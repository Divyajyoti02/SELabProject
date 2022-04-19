/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nitrkl.sadesignerlite;

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
}
