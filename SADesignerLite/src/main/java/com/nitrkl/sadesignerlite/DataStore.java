/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nitrkl.sadesignerlite;

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
}
