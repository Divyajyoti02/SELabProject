/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nitrkl.sadesignerlite;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.Uedge);
        hash = 41 * hash + Objects.hashCode(this.Vedge);
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
        final TwoPath other = (TwoPath) obj;
        if (!Objects.equals(this.Uedge, other.Uedge)) {
            return false;
        }
        return Objects.equals(this.Vedge, other.Vedge);
    }
    
    
    
}
