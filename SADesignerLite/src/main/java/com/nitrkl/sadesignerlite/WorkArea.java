/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nitrkl.sadesignerlite;

import java.awt.Color;
import java.awt.Dimension;
import java.io.Serializable;

/**
 *
 * @author hp
 */
public class WorkArea extends javax.swing.JPanel implements Serializable {
    DFDBackend dfd;
    DDBackend dd;
    boolean isChanged;

    WorkArea() {
        dfd = new DFDBackend();
        dd = new DDBackend();
        isChanged = false;
        this.setBackground(Color.white);
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        Dimension d = new Dimension(1024, 728);
        this.setMinimumSize(d);
        this.setMaximumSize(d);
        this.setPreferredSize(d);
        this.setVisible(true);
        this.setSize(1024, 728);
    }
    
    void insertDataFlow(Positions ps) {
        DataFlow df = new DataFlow();
        df.start = dfd.findShapeAnchor(ps.topLeft);
        df.end = dfd.findShapeAnchor(ps.bottomRight);
        if (
            df.start.shape != null &&
            df.end.shape != null &&
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
        dfd.g.addEdge(new TwoPath(df.start.shape, df.end.shape));
        dfd.arrShapes.add(df);
        display();
        isChanged = true;
    }
    
    void insertDataProcess(Positions ps) {
        DataProcess dp = new DataProcess();
        dp.Name = "";
        while(true) {
            dp.Name = javax.swing.JOptionPane.showInputDialog(
                "Enter name of data process"
            );
            if (!"".equals(dp.Name) && !dd.Names.containsKey(dp.Name)) {
                dd.Names.put(dp.Name, Type.DataProcess);
                break;
            } else {
                javax.swing.JOptionPane.showMessageDialog(
                    null, 
                    "Name \"" + dp.Name + "\" already exists",
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE
                );
            }
        }
        dfd.g.addNode(dp);
        dfd.arrShapes.add(dp);
        display();
        isChanged = true;
    }
    
    void insertDataStore(Positions ps) {
        DataStore ds = new DataStore();
        ds.Name = "";
        while(true) {
            ds.Name = javax.swing.JOptionPane.showInputDialog(
                "Enter name of data store"
            );
            if (!"".equals(ds.Name) && !dd.Names.containsKey(ds.Name)) {
                dd.Names.put(ds.Name, Type.DataProcess);
                break;
            } else {
                javax.swing.JOptionPane.showMessageDialog(
                    null, 
                    "Name \"" + ds.Name + "\" already exists",
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE
                );
            }
        }
        dfd.g.addNode(ds);
        dfd.arrShapes.add(ds);
        display();
        isChanged = true;
    }
    
    void insertExternalEntity(Positions ps) {
        ExternalEntity ee = new ExternalEntity();
        ee.Name = "";
        while(true) {
            ee.Name = javax.swing.JOptionPane.showInputDialog(
                "Enter name of external entity"
            );
            if (!"".equals(ee.Name) && !dd.Names.containsKey(ee.Name)) {
                dd.Names.put(ee.Name, Type.DataProcess);
                break;
            } else {
                javax.swing.JOptionPane.showMessageDialog(
                    null, 
                    "Name \"" + ee.Name + "\" already exists",
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE
                );
            }
        }
        dfd.g.addNode(ee);
        dfd.arrShapes.add(ee);
        display();
        isChanged = true;
    }
    
    void insertExternalOutput(Positions ps) {
        ExternalOutput eo = new ExternalOutput();
        eo.Name = "";
        while(true) {
            eo.Name = javax.swing.JOptionPane.showInputDialog(
                "Enter name of external output"
            );
            if (!"".equals(eo.Name) && !dd.Names.containsKey(eo.Name)) {
                dd.Names.put(eo.Name, Type.DataProcess);
                break;
            } else {
                javax.swing.JOptionPane.showMessageDialog(
                    null, 
                    "Name \"" + eo.Name + "\" already exists",
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE
                );
            }
        }
        dfd.g.addNode(eo);
        dfd.arrShapes.add(eo);
        display();
        isChanged = true;
    }
    
    void insertLabel(Positions ps) {
        LabelObj l = new LabelObj();
        l.Name = "Label" + Integer.toString(l.labelCount++);
        display();
        isChanged = true;
    }

    void DDWizard(int mode) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void display() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
