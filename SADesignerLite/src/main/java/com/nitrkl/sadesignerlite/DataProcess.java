/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nitrkl.sadesignerlite;

/**
 *
 * @author hp
 */
class DataProcess extends ShapeObj {
    public DataProcess(int x, int y, int width, int height) {
        type = Type.DataProcess;
        position = new Positions(x, y, x + width, y + height);
    }
    
    public DataProcess(Positions ps) {
        type = Type.DataProcess;
        position = ps;
    }
}
