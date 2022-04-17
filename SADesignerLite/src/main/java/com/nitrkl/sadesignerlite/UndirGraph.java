/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nitrkl.sadesignerlite;

import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author hp
 */
class UndirGraph {
    HashMap<ShapeObj, HashSet<ShapeObj>> g;
    
    int numNodes() {return g.size();}
    
    void addNode(ShapeObj s) {
        if (!containsNode(s)) g.put(s, new HashSet<>());
    }
    
    void addEdge(TwoPath tp) {
        if (!containsNode(tp.Uedge)) {addNode(tp.Uedge);}
        if (!containsNode(tp.Vedge)) {addNode(tp.Vedge);}
        g.get(tp.Uedge).add(tp.Vedge);
        g.get(tp.Vedge).add(tp.Uedge);
    }

    boolean containsNode(ShapeObj s) {return g.containsKey(s);}
}
