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

class ShapeObj {
    String Name;
    Positions position;
    Type type;
    WorkArea decompose;
    ArrayList<ShapeObj> inDataFlow, outDataFlow;
}
