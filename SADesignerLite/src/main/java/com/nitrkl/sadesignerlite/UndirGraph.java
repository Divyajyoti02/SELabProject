/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nitrkl.sadesignerlite;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author hp
 */
class UndirGraph {
    HashMap<ShapeObj, HashSet<ShapeObj>> g;

    public UndirGraph() {
        g = new HashMap<>();
    }
    
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
    
    boolean debugIsolated(javax.swing.JTextArea jta) {
        if (g.size() != 0) {
            HashMap<ShapeObj, Boolean> isVisited = new HashMap<>();
            for (ShapeObj s: g.keySet()) isVisited.put(s, Boolean.FALSE);
            ShapeObj s = (ShapeObj)(g.keySet().toArray())[0];
            //isVisited.put(s, Boolean.TRUE);
            Queue<ShapeObj> q = new LinkedList<>();
            q.add(s);
            while(!q.isEmpty()) {
                s = q.remove();
                isVisited.put(s, Boolean.TRUE);
                for (ShapeObj s2: g.get(s)) {
                    if (!isVisited.get(s2)) q.add(s2);
                }
            }
            if (isVisited.values().contains(Boolean.FALSE)) {
                jta.append("Isolated error detected!");
                return true;
            } else return false;
        } else return false;
    }
}
