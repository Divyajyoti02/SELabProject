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
public class Path {
    PathType pType;
    ShapeObj onePath;
    TwoPath twoPath;

    Path(ShapeObj s) {
        pType = PathType.OnePath;
        onePath = s;
    }
    
    Path(TwoPath tp) {
        pType = PathType.TwoPath;
        twoPath = tp;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.pType);
        if (this.pType == PathType.OnePath)
            hash = 53 * hash + Objects.hashCode(this.onePath);
        else
            hash = 53 * hash + Objects.hashCode(this.twoPath);
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
        final Path other = (Path) obj;
        if (this.pType != other.pType) {
            return false;
        }
        if (this.pType == PathType.OnePath)
            return Objects.equals(this.onePath, other.onePath);
        else return Objects.equals(this.twoPath, other.twoPath);
    }
    
    
}
