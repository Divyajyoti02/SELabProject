/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.nitrkl.sadesignerlite;

import javax.naming.directory.InvalidAttributesException;

/**
 *
 * @author hp
 */
public enum VarType {
    IntegerVar("Integer"), 
    FloatVar("Float"), 
    BooleanVar("Boolean"), 
    StringVar("String"), 
    StructVar("Struct");
    
    final String text;
    
    VarType(final String text) {this.text = text;}

    @Override
    public String toString() {return text;}
}