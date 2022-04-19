/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nitrkl.sadesignerlite;

import java.util.HashMap;

/**
 *
 * @author hp
 */
class DDBackend {
    HashMap<String, Type> Names;
    HashMap<String, DDEntry> dd;
    HashMap<String, StructEntry> structs;

    public DDBackend() {
        this.Names = new HashMap<>();
        this.dd = new HashMap<>();
        this.structs = new HashMap<>();
    }
    
    
}
