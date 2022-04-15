/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nitrkl.sadesignerlite;

/**
 *
 * @author Leo R. Rodrigues
 */
public class Path {
    int path[];
    
    public Path (int x[]){
        this.path = x;
    }
    
    @Override
    public String toString(){
        int i;
        String res = "";
        int n = path.length;
        for (i = 0; i<n; i++){
            res+=Integer.toString(this.path[i]);
        }
        return res;
    }
}
