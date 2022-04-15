/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nitrkl.sadesignerlite;

/**
 *
 * @author Leo R. Rodrigues
 */
public class Window {
    DDBackend Ddbackend;
    DFDBackend Dfdbackend;
    String Dir, Title;
    boolean isChanged;
   // InteractiveImage Workspace;
    //jPane log;
    //parent missing
    
    public Window() {
        this.Title = "Untitled";
    }
    
    public Window(DDBackend Ddbackend, DFDBackend Dfdbackend, String Dir, String Title, boolean isChanged) {
        this.Ddbackend = Ddbackend;
        this.Dfdbackend = Dfdbackend;
        this.Dir = Dir;
        this.Title = Title;
        this.isChanged = isChanged;
    }

    @Override
    public String toString() {
        return "Window{" + "Ddbackend=" + Ddbackend + ", Dfdbackend=" + Dfdbackend + ", Dir=" + Dir + ", Title=" + Title + ", isChanged=" + isChanged + '}';
    }
    
    
    
    
    
    
}
