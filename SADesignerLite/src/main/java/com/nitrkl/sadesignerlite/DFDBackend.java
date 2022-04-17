/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nitrkl.sadesignerlite;

import java.util.ArrayList;

/**
 *
 * @author hp
 */
class DFDBackend {
    ArrayList<ShapeObj> arrShapes;
    UndirGraph g;
    
    DFDBackend() {
        arrShapes = new ArrayList<ShapeObj>();
        g = new UndirGraph();
    }
    
    int indexOfSmallest(int[] array) {
        if (array.length == 0)
            return -1;

        int index = 0, min = array[index];

        for (int i = 1; i < array.length; i++){
            if (array[i] <= min){
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

    void updateConnects(DataFlow df) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
