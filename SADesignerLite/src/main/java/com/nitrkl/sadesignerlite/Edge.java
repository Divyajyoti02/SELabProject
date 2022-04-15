/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nitrkl.sadesignerlite;

/**
 *
 * @author Leo R. Rodrigues
 */
public class Edge {
    Position u ,v; //u - first point, v - second point

    public Edge(Position u, Position v) {
        this.u = u;
        this.v = v;
    }
    
    @Override
    public String toString() {
        return "Position of points{" + "U=" + u + ", V=" + v + '}';
    }
    
    
}
