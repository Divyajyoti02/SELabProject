/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nitrkl.sadesignerlite;

/**
 *
 * @author Leo R. Rodrigues
 */
public class DataType {
    String Name;
    Type type;

    public DataType(String Name, Type type) {
        this.Name = Name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "DataType{" + "Name=" + Name + ", type=" + type + '}';
    }
    
    
}
