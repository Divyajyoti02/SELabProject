/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nitrkl.sadesignerlite;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;

/**
 *
 * @author Leo R. Rodrigues
 */
public class GraphicController extends MouseInputAdapter{
    WorkArea component;
    Point offset = new Point();
    boolean dragging = false;
    boolean constructing=false;
    
     public GraphicController(WorkArea gdad) {
        component = gdad;
        component.addMouseListener(this);
        component.addMouseMotionListener(this);
    }
    
    //Selected symbol
    int sel=-1;
    Point p,q;
    ShapeObj x;
    //For connstructing new symbol
    ShapeObj temp;
    
    //For constructing new arrow
    DataFlow tempa;
    
    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("CHECK -- Mouse moved " + e.getPoint());
        x = component.dfd.findShapeAnchor(e.getPoint()).shape; //sel = getsymbolindex(e.getPoint());
        component.currShape = x;
        //component.repaint();
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("CHECK -- Mouse clicked once rn " + e.getPoint());
         x = component.dfd.findShapeAnchor(p).shape;
        /*if (SwingUtilities.isRightMouseButton(e)) {
            PopUpDemo menu = new PopUpDemo();
            menu.show(e.getComponent(), e.getX(), e.getY());
            System.out.println("showing menu");
        }*/
        if (e.getClickCount() == 2){
            x = component.dfd.findShapeAnchor(e.getPoint()).shape;
            /*
            if(component.mode == 11 && x.type == Type.DataProcess) {
                dfd d = ((Bubble)component.shapes.get(sel)).d;
                d.name = component.shapes.get(sel).name;
                GraphicDragController gdadc = new GraphicDragController(d);
                //if(d.shapes.size()==0) d.addtochild(component, component.shapes.get(sel), d);
                Global.n.tabs.add(d.name, d);
                Global.n.tabs.setSelectedIndex(Global.n.tabs.getTabCount()-1);
            }
            else {// Global.mode==5
            */
                if(x != null) {
                    x.rename();
                }
            }
        if(component.mode == 21) {
            x = component.dfd.findShapeAnchor(e.getPoint()).shape;
            if(x != null) {
                x.deleteObj();
            }
        }
        else if (component.mode == 7){
            temp = new LabelObj(e.getPoint());
            component.dfd.arrShapes.add(temp);
            component.insertLabel((LabelObj) component.dfd.arrShapes.get(component.dfd.arrShapes.size() - 1));
        }
    }
    public void mousePressed(MouseEvent e) {
        System.out.println("CHECK -- Mouse pressed " + e.getPoint());
        x = null;
        p = e.getPoint();
        if(component.mode != 4)
            x = component.dfd.findShapeAnchor(p).shape;
        if(x != null) {
            ShapeObj r = x;
            offset.x = (int) (p.x - r.getBounds2D().getX());
            offset.y = (int) (p.y - r.getBounds2D().getY());
            dragging = true;
        } else{
            switch (component.mode) {
                case 1:
                    temp = new ExternalEntity(p.x,p.y,0,0);
                    component.dfd.arrShapes.add(temp);
                    break;
                case 2: 
                    //component.insertDataProcess(new Positions(p.x, p.y, p.x +5, p.y+5));
                    temp = new DataProcess(p.x,p.y,0,0);
                    component.dfd.arrShapes.add(temp);
                    break;
                case 3: 
                    temp = new DataStore(p.x, p.y, 0, 0);
                    component.dfd.arrShapes.add(temp);
                    break;
                case 4:
                    Position P = new Position(p);
                    temp = new DataFlow(p, p);
                    component.dfd.arrShapes.add(temp);
                    break;
                case 6:
                    System.out.println("Create");
                    temp = new ExternalOutput(p.x, p.y, 0, 0);
                    component.dfd.arrShapes.add(temp);
            }
            dragging = true;
            constructing = true;
        }
    }
 
    public void mouseReleased(MouseEvent e) {
        System.out.println("CHECK -- Mouse released " + e.getPoint());
        dragging = false;
        //if(Global.mode==0) return;
        q = e.getPoint();
        if(constructing){
            if (temp!= null){
                if (temp.isdrawn()) {
                    if(component.mode == 4) {
                        constructing = component.insertDataFlow(new Positions(p.x, p.y, q.x, q.y));
                    } else {
                    /*
                    Edit edit = new Edit (component.shapes.get(component.shapes.size()-1));
                    edit.setVisible(true);
                    */
                    }
                }
                else {
                   
                }
                switch(component.mode){
                        case 1:  component.insertExternalEntity((ExternalEntity) component.dfd.arrShapes.get(component.dfd.arrShapes.size() - 1));
                        break;
                        case 2: component.insertDataProcess((DataProcess) component.dfd.arrShapes.get(component.dfd.arrShapes.size() - 1));
                        break;
                        case 3: component.insertDataStore((DataStore) component.dfd.arrShapes.get(component.dfd.arrShapes.size() - 1));
                        break;
                        case 6: component.insertExternalOutput((ExternalOutput) component.dfd.arrShapes.get(component.dfd.arrShapes.size() - 1));
                }
        } else {
                component.repaint();
        }
        component.repaint();
        constructing = false;
    }
}
    public void mouseDragged(MouseEvent e) {
        System.out.println("CHECK -- Mouse dragged " + e.getPoint());
        if (dragging) {
            if(!constructing){
                int x1 = e.getX() - offset.x;
                int y1 = e.getY() - offset.y;
                x.move(x1, y1);  //needs to be changed
            }
            else {
            switch (component.mode) {
                case 1:
                    temp.resize(new Point(e.getX(),e.getY()));
                    break;
                case 2:
                    temp.resize(new Point(e.getX(),e.getY()));
                    break;
                case 3:
                    temp.resize(new Point(e.getX(),e.getY()));
                    break;
                case 4:
                    temp.resize(new Point(e.getX(),e.getY()));
                    break;
                case 6:
                    temp.resize(new Point(e.getX(),e.getY()));
                    break;
                case 7:
                    temp.resize(new Point(e.getX(),e.getY()));
            }
            }
            
            component.repaint();
        }
    }

   /* void adjustarrows (Symbol curr, int x, int y) {
        FlowArrow a;
        for(int i=0; i<component.shapes.size(); i++) {
            Symbol s = component.shapes.get(i);
            if(s.gettype().equals("flowarrow")) {
                a = (FlowArrow) s;
                if(a.head == curr) a.movehead(x, y);
                else if (a.tail==curr) a.movetail(x,y);
            }
        }    
        CtrlArrow b;
        for(int i=0; i<component.shapes.size(); i++) {
            Symbol s = component.shapes.get(i);
            if(s.gettype().equals("ctrlarrow")) {
                b = (CtrlArrow) s;
                if(b.head == curr) b.movehead(x, y);
                else if (b.tail==curr) b.movetail(x,y);
            }
        }
        System.out.println("Arrows adjusted");
    }
    void deletearrow(Symbol curr) {
        DataFlow a;
        for(int i=0; i<component.shapes.size(); i++) {
            Symbol s = component.shapes.get(i);
            if(s.gettype().equals("flowarrow")) {
                a = (FlowArrow) s;
                if(a.head == curr) component.shapes.remove(i);
                else if (a.tail==curr) component.shapes.remove(i);
            }
        }    
    }    
}
*/
}
class menuclicklistener implements MouseListener {
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse clicked (# of clicks: " + e.getClickCount() + ")");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
