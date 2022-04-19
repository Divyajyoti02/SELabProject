/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nitrkl.sadesignerlite;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author hp
 */
class DFDBackend {
    ArrayList<ShapeObj> arrShapes;
    UndirGraph g;
    HashMap<TwoPath, Paths> connects;
    
    DFDBackend() {
        arrShapes = new ArrayList<ShapeObj>();
        g = new UndirGraph();
        connects = new HashMap<>();
    }
    
    int indexOfSmallest(int[] array) {
        if (array.length == 0)
            return -1;

        int index = 0, min = array[0];

        for (int i = 1; i < array.length; i++){
            if (array[i] < min){
                min = array[i];
                index = i;
               }
            }
        return index;
    }

    ShapeAnchor findShapeAnchor(Position P) {
        ArrayList<ShapeAnchor> listShapes = new ArrayList<ShapeAnchor>();
        for (ShapeObj s : arrShapes) {
            if (s.type != Type.DataFlow && s.type != Type.Label) {
                Positions sP = s.position;
                if (
                    P.x >= sP.topLeft.x && 
                    P.x <= sP.bottomRight.x && 
                    P.y >= sP.topLeft.y && 
                    P.y <= sP.bottomRight.y
                ) {
                    int[] ancArr = {
                        P.x - sP.topLeft.x, 
                        P.x - sP.bottomRight.x, 
                        P.y - sP.topLeft.y, 
                        P.y - sP.bottomRight.y
                    };
                    switch(indexOfSmallest(ancArr)) {
                        case 0:
                            listShapes.add(new ShapeAnchor(s, AnchorType.Left));
                            break;
                        case 1:
                            listShapes.add(new ShapeAnchor(s, AnchorType.Right));
                            break;
                        case 2:
                            listShapes.add(new ShapeAnchor(s, AnchorType.Up));
                            break;
                        case 3:
                            listShapes.add(new ShapeAnchor(s, AnchorType.Down));
                    }
                }
            }
        }
        switch (listShapes.size()) {
            case 0: return new ShapeAnchor(null, AnchorType.Left);
            case 1: return listShapes.get(0);
            default: return chooseList(listShapes);
        }
    }
    
    ShapeAnchor findShapeAnchor(Point p) {
        Position P = new Position(p.x, p.y);
        ArrayList<ShapeAnchor> listShapes = new ArrayList<ShapeAnchor>();
        for (ShapeObj s : arrShapes) {
            if (s.type != Type.DataFlow && s.type != Type.Label) {
                Positions sP = s.position;
                if (
                    P.x >= sP.topLeft.x && 
                    P.x <= sP.bottomRight.x && 
                    P.y >= sP.topLeft.y && 
                    P.y <= sP.bottomRight.y
                ) {
                    int[] ancArr = {
                        P.x - sP.topLeft.x, 
                        sP.bottomRight.x - P.x, 
                        P.y - sP.topLeft.y, 
                        sP.bottomRight.y - P.y
                    };
                    System.out.println(Arrays.toString(ancArr));
                    switch(indexOfSmallest(ancArr)) {
                        case 0:
                            listShapes.add(new ShapeAnchor(s, AnchorType.Left));
                            break;
                        case 1:
                            listShapes.add(new ShapeAnchor(s, AnchorType.Right));
                            break;
                        case 2:
                            listShapes.add(new ShapeAnchor(s, AnchorType.Up));
                            break;
                        case 3:
                            listShapes.add(new ShapeAnchor(s, AnchorType.Down));
                    }
                    System.out.println(listShapes.get(0));
                }
            }
        }
        switch (listShapes.size()) {
            case 0: return new ShapeAnchor(null, AnchorType.Left);
            case 1: return listShapes.get(0);
            default: return chooseList(listShapes);
        }
    }

    void updateConnects(DataFlow df) {
        ShapeObj s1 = df.start.shape, s2 = df.end.shape;
        if (s1.type == Type.DataProcess) {
            if (s2.type == Type.DataProcess) {
                TwoPath tp1 = new TwoPath(s1, s2), tp2 = new TwoPath(s2, s1);
                if (!connects.containsKey(tp1)) connects.put(tp1, new Paths());
                connects.get(tp1).paths.add(new Path(df));
                if (!connects.containsKey(tp2)) connects.put(tp2, new Paths());
                connects.get(tp2).paths.add(new Path(df));
            } else {
                TwoPath tp1 = new TwoPath(s1, s2);
                if (!connects.containsKey(tp1)) connects.put(tp1, new Paths());
                connects.get(tp1).paths.add(new Path(df));
                for (TwoPath key: connects.keySet()) {
                    if (
                        key.Uedge.equals(s2) && 
                        !connects.get(key).paths.isEmpty()
                    ) {
                        Paths ps = new Paths();
                        ps.paths.add(new Path(new TwoPath(s1, key.Vedge)));
                        for (Path p: connects.get(key).paths) {
                            if (p.pType == PathType.OnePath) {
                                connects.get(
                                    new TwoPath(s1, key.Vedge)
                                ).paths.add(
                                    new Path(new TwoPath(df, p.onePath))
                                );
                            }
                        }
                    }
                }
            }
        } else {
            TwoPath tp1 = new TwoPath(s2, s1);
            if (!connects.containsKey(tp1)) connects.put(tp1, new Paths());
            connects.get(tp1).paths.add(new Path(df));
            for (TwoPath key: connects.keySet()) {
                if (
                    key.Vedge.equals(s1) && 
                    !connects.get(key).paths.isEmpty()
                ) {
                    Paths ps = new Paths();
                    ps.paths.add(new Path(new TwoPath(key.Vedge,s2)));
                    for (Path p: connects.get(key).paths) {
                        if (p.pType == PathType.OnePath) {
                            connects.get(
                                new TwoPath(key.Uedge, s2)
                            ).paths.add(new Path(new TwoPath(p.onePath, df)));
                        }
                    }
                }
            }
        }
    }

    ShapeAnchor chooseList(ArrayList<ShapeAnchor> listShapes) {
        ArrayList<String> sList = new ArrayList<>();
        for (ShapeAnchor sa : listShapes) sList.add(sa.shape.Name);
        String name = javax.swing.JOptionPane.showInputDialog(
            null, "Choose shape", sList
        );
        for (ShapeAnchor sa : listShapes) {
            if (sa.shape.Name.equals(name)) return sa;
        }
        return null;
    }
    
}
