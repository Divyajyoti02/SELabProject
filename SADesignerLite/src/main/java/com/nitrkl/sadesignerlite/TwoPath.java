/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nitrkl.sadesignerlite;

/**
 *
 * @author Leo R. Rodrigues
 */
public class TwoPath {
    ShapeObj Uedge, Vedge;

    public TwoPath(ShapeObj Uedge, ShapeObj Vedge) {
        this.Uedge = Uedge;
        this.Vedge = Vedge;
    }

    @Override
    public String toString() {
        return "TwoPath{" + "Uedge=" + Uedge + ", Vedge=" + Vedge + '}';
    }
    
    
    
}
