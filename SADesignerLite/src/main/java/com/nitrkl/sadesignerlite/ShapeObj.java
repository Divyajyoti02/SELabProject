/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nitrkl.sadesignerlite;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author hp
 */

class ShapeObj {
    String Name;
    Positions position;
    Type type;
    WorkArea decompose;
    ArrayList<ShapeObj> inDataFlow, outDataFlow;
    VarType varType;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.Name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ShapeObj other = (ShapeObj) obj;
        return Objects.equals(this.Name, other.Name);
    }
    
    public ShapeObj containsName(String name) {
        for (ShapeObj s: inDataFlow) if (s.Name.equals(name)) return s;
        for (ShapeObj s: outDataFlow) if (s.Name.equals(name)) return s;
        return null;
    }
}
