/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nitrkl.sadesignerlite;

import java.io.Serializable;

/**
 *
 * @author hp
 */
public class WorkArea extends javax.swing.JPanel implements Serializable {
    DFDBackend dfd;
    DDBackend dd;
    boolean isChanged;

    public WorkArea() {
        dfd = new DFDBackend();
        dd = new DDBackend();
        isChanged = false;
    }
    
    public void insertDataFlow(Positions ps) {
        DataFlow df = new DataFlow();
        df.start = dfd.findShapeAnchor(ps.topLeft);
        df.end = dfd.findShapeAnchor(ps.bottomRight);
        if (
            df.start != null &&
            df.end != null &&
            (
                df.start.shape.type == Type.DataProcess ||
                df.end.shape.type == Type.DataProcess
            ) &&
            df.start.shape.type != Type.ExternalOutput
        ) {
            dfd.updateConnects(df);
            if (df.start.shape.type == Type.DataProcess) {
                if (df.end.shape.type == Type.DataProcess) DDWizard(0);
                else DDWizard(1);
            } else DDWizard(2);
        }
        df.decompose = null;
        df.start.shape.outDataFlow.add(df);
        df.end.shape.inDataFlow.add(df);
        display();
        isChanged = true;
    }

    private void DDWizard(int mode) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void display() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
