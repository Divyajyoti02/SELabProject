/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nitrkl.sadesignerlite;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.Serializable;
import javax.swing.Action;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.System.in;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class WorkArea extends javax.swing.JPanel implements Serializable {
    DFDBackend dfd;
    DDBackend dd;
    boolean isChanged;
    String title;
    int decomposeLevel;
    ShapeObj currShape;
    int mode;
    DDWizardUI ddw;
    String filename, filepath;

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
        decomposeLevel = 0;
        mode = 0;
    }
    
    boolean insertDataFlow(DataFlow df, ShapeAnchor sa1, ShapeAnchor sa2) {
        df.start = sa1;
        df.end = sa2;
        System.out.println(df.start + " " + df.end);
        if (
            df.start.shape != null &&
            df.end.shape != null &&
            (
                df.start.shape.type == Type.DataProcess ||
                df.end.shape.type == Type.DataProcess
            ) &&
            df.start.shape.type != Type.ExternalOutput
        ) {
            System.out.println("Step1");
            dfd.updateConnects(df);
            System.out.println("Step2");
            Position p1 = df.start.shape.position.topLeft;
            Position p2 = df.start.shape.position.bottomRight;
            switch(df.start.anchor) {
                case Up: df.position.topLeft = new Position((int)((p1.x+p2.x)/2),p1.y);
                break;
                case Down: df.position.topLeft = new Position((int)((p1.x+p2.x)/2),p2.y);
                break;
                case Left: df.position.topLeft = new Position(p1.x,(int)((p1.y+p2.y)/2));
                break;
                case Right: df.position.topLeft = new Position(p2.x,(int)((p1.y+p2.y)/2));
            }
            p1 = df.end.shape.position.topLeft;
            p2 = df.end.shape.position.bottomRight;
            switch(df.end.anchor) {
                case Up: df.position.bottomRight = new Position((int)((p1.x+p2.x)/2),p1.y);
                break;
                case Down: df.position.bottomRight = new Position((int)((p1.x+p2.x)/2),p2.y);
                break;
                case Left: df.position.bottomRight = new Position(p1.x,(int)((p1.y+p2.y)/2));
                break;
                case Right: df.position.bottomRight = new Position(p2.x,(int)((p1.y+p2.y)/2));
            }
            if (df.start.shape.type == Type.DataProcess) {
                if (df.end.shape.type == Type.DataProcess) ddw = new DDWizardUI(0, df);
                else ddw = new DDWizardUI(1, df);
            } else ddw = new DDWizardUI(2, df);
            ddw.setParent(this);
            ddw.setVisible(true);
            df.decompose = null;
            df.start.shape.outDataFlow.add(df);
            df.end.shape.inDataFlow.add(df);
            dfd.g.addEdge(new TwoPath(df.start.shape, df.end.shape));
            repaint();
            isChanged = true;
            return true;
        } else {
            dfd.arrShapes.remove(df);
            return false;
        }
    }
    
    void insertDataProcess(DataProcess dp) {
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
        System.out.println(dp.position);
        dfd.g.addNode(dp);
        repaint();
        isChanged = true;
    }
    
    void insertDataStore(DataStore ds) {
        ds.Name = "";
        while(true) {
            ds.Name = javax.swing.JOptionPane.showInputDialog(
                "Enter name of data store"
            );
            if (ds.Name == null) {
                dfd.arrShapes.remove(ds);
                repaint();
                break;
            } else if (!"".equals(ds.Name) && !dd.Names.containsKey(ds.Name)) {
                dd.Names.put(ds.Name, Type.DataProcess);
                dfd.g.addNode(ds);
                repaint();
                isChanged = true;
                break;
            } else {
                javax.swing.JOptionPane.showMessageDialog(
                    null, 
                    "Name \"" + ds.Name + "\" already exists",
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE
                );
                dfd.g.addNode(ds);
                repaint();
                isChanged = true;
            }
        }
        
    }
    
    void insertExternalEntity(ExternalEntity ee) {
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
        repaint();
        isChanged = true;
    }
    
    void insertExternalOutput(ExternalOutput eo) {
        eo.Name = "";
        while(true) {
            eo.Name = javax.swing.JOptionPane.showInputDialog(
                "Enter name of external output"
            );
            if (!"".equals(eo.Name) && !dd.Names.containsKey(eo.Name)) {
                dd.Names.put(eo.Name, Type.ExternalOutput);
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
        repaint();
        isChanged = true;
    }
    
    void insertLabel(LabelObj l) {
        //l.Name = "Label" + Integer.toString(l.labelCount++);ee.Name = "";
        while(true) {
            l.Name = javax.swing.JOptionPane.showInputDialog(
                "Enter the text in the Label"
            );
            if (!"".equals(l.Name) && !dd.Names.containsKey(l.Name)) {
                dd.Names.put(l.Name, Type.DataProcess);
                break;
            } else {
                javax.swing.JOptionPane.showMessageDialog(
                    null, 
                    "Name \"" + l.Name + "\" already exists",
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE
                );
            }
        }
        repaint();
        isChanged = true;
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(3));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setPaint(Color.black);

        int i;
        for(ShapeObj s: dfd.arrShapes) {
            //if(s.equals(currShape)) s.draw(g);
            s.draw(g);
        }
    }
    

    void display() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    boolean savePrompt() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void saveAs() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void save() {
        FileOutputStream temp;
        ObjectOutputStream o;
        try {
            temp = new FileOutputStream("Demo.dfd");
            o = new ObjectOutputStream(temp);
            o.writeObject(new WorkArea());
            o.close();
            temp.close();
        } catch (IOException ex) {
            Logger.getLogger(WorkArea.class.getName()).log(Level.SEVERE, null, ex);
        }
        isChanged = false;
    }
    
    /*void open(){
        FileInputStream file;
        ObjectInputStream o;
        try{
        file = new FileInputStream("demo.dfd");
        o = new ObjectInputStream(file);
        WorkArea temp = (WorkArea)o.readObject();
        o.close();
        file.close();       
        } catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }
        
    }*/

    Action deleteShape() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
