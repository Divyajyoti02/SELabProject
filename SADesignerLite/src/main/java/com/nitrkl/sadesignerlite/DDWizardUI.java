/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.nitrkl.sadesignerlite;

/**
 *
 * @author hp
 */
public class DDWizardUI extends javax.swing.JFrame {

    private WorkArea wa;
    String name;
    int mode;
    DataFlow df;
    boolean addNew, validName;
    
    private StructureWizardUI strUI;

    /**
     * Creates new form DDWizard
     */
    public DDWizardUI() {
        initComponents();
        this.setTitle("DDWizard");
        name = "";
        validName = false;
    }
    
    public DDWizardUI(int mode, DataFlow df) {
        initComponents();
        this.setTitle("DDWizard");
        name = "";
        this.mode = mode;
        this.df = df;
    }
    
    public void setParent(WorkArea wa) {this.wa = wa;}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Submit = new javax.swing.JButton();
        VarNameLabel = new javax.swing.JLabel();
        NameField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Submit.setText("Submit");
        Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitActionPerformed(evt);
            }
        });

        VarNameLabel.setText("Variable Name");

        NameField.setText("Enter Name");
        NameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                NameFieldFocusLost(evt);
            }
        });
        NameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameFieldActionPerformed(evt);
            }
        });

        jLabel1.setText("Variable Data Type");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose DataType", "Integer", "Float", "Boolean", "String", "Structure" }));
        jComboBox1.setToolTipText("");
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Number of occurrences");

        jLabel3.setText("Min");

        jLabel4.setText("Max");

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jSpinner2.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(VarNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(Submit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VarNameLabel)
                    .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Submit)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public String getSelVal()
    {
        return jComboBox1.getSelectedItem().toString();
    }
    public String getObjName()
    {
        return NameField.getText();
    }
    public String getObjMin()
    {
        return jSpinner1.getValue().toString();
    }
    public String getObjMax()
    {
        return jSpinner2.getValue().toString();
    }
    public void setParent(StructureWizardUI swi)
    {
        strUI=swi;
    }
    private void SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitActionPerformed
        // TODO add your handling code here:
        if (!validName) {
            javax.swing.JOptionPane.showMessageDialog(
                this,
                "Invalid variable name", 
                "Error", 
                javax.swing.JOptionPane.ERROR_MESSAGE
            );
            NameField.requestFocusInWindow();
        } else if (jComboBox1.getSelectedItem().toString().equals("Choose DataType")){
            javax.swing.JOptionPane.showMessageDialog(
                this,
                "Invalid data type Selected!", 
                "Error", 
                javax.swing.JOptionPane.ERROR_MESSAGE
            );
            jComboBox1.requestFocusInWindow();
        } else {
            int jspin1 = (Integer) jSpinner1.getValue();
            int jspin2 = (Integer) jSpinner2.getValue();
            if (jspin1 > jspin2) {
                javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Min is greater than max!", 
                    "Error", 
                    javax.swing.JOptionPane.ERROR_MESSAGE
                );
                jSpinner1.requestFocusInWindow();
            } else if (jspin2 == 0){
                javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Both values can't be zero!", 
                    "Error", 
                    javax.swing.JOptionPane.ERROR_MESSAGE
                );
                jSpinner2.requestFocusInWindow();
            } else {
                wa.dd.Names.put(name, com.nitrkl.sadesignerlite.Type.General);
                wa.dd.dd.put(name, new DDEntry(VarType.valueOf((String) jComboBox1.getSelectedItem()), (Integer) jSpinner1.getValue(), (Integer) jSpinner2.getValue()));
                if (addNew) {wa.dd.structs.put(name, new StructEntry(name));}
                this.dispose();
            }
        }
    }//GEN-LAST:event_SubmitActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void NameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameFieldActionPerformed
        // TODO add your handling code here:
        name = NameField.getText();
        System.out.println("Here:" + name);
        if (name.isEmpty() || name.contains(" ")) {
            javax.swing.JOptionPane.showMessageDialog(
                this,
                "Invalid variable name", 
                "Error", 
                javax.swing.JOptionPane.ERROR_MESSAGE
            );
            NameField.requestFocusInWindow();
        }
        addNew = !wa.dd.Names.containsKey(name);
        if (!addNew) {
            if (mode == 0) {
                javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Invalid variable name", 
                    "Error", 
                    javax.swing.JOptionPane.ERROR_MESSAGE
                );
                jComboBox1.setEditable(true);
                NameField.setText("");
                NameField.requestFocusInWindow();
                validName = true;
            } else {
                ShapeObj s;
                if (mode == 1) s = df.end.shape.containsName(name);
                else s = df.start.shape.containsName(name);
                if (s == null) {
                    javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "Invalid variable name", 
                        "Error", 
                        javax.swing.JOptionPane.ERROR_MESSAGE
                    );
                    jComboBox1.setEditable(true);
                    NameField.setText("");
                    NameField.requestFocusInWindow();
                } else {
                    jComboBox1.setSelectedItem(s.varType.toString());
                    jComboBox1.setEditable(false);
                    validName = true;
                }
            }
        } else {
            validName = true;
        }
    }//GEN-LAST:event_NameFieldActionPerformed

    private void NameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NameFieldFocusLost
        // TODO add your handling code here:
        name = NameField.getText();
        System.out.println("Here:" + name);
        if (name.isEmpty() || name.contains(" ")) {
            javax.swing.JOptionPane.showMessageDialog(
                this,
                "Invalid variable name", 
                "Error", 
                javax.swing.JOptionPane.ERROR_MESSAGE
            );
            NameField.requestFocusInWindow();
        }
        addNew = !wa.dd.Names.containsKey(name);
        if (!addNew) {
            if (mode == 0) {
                javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Invalid variable name", 
                    "Error", 
                    javax.swing.JOptionPane.ERROR_MESSAGE
                );
                jComboBox1.setEditable(true);
                NameField.setText("");
                NameField.requestFocusInWindow();
                validName = true;
            } else {
                ShapeObj s;
                if (mode == 1) s = df.end.shape.containsName(name);
                else s = df.start.shape.containsName(name);
                if (s == null) {
                    javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "Invalid variable name", 
                        "Error", 
                        javax.swing.JOptionPane.ERROR_MESSAGE
                    );
                    jComboBox1.setEditable(true);
                    NameField.setText("");
                    NameField.requestFocusInWindow();
                } else {
                    jComboBox1.setSelectedItem(s.varType.toString());
                    jComboBox1.setEditable(false);
                    validName = true;
                }
            }
        } else {
            validName = true;
        }
    }//GEN-LAST:event_NameFieldFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DDWizardUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DDWizardUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DDWizardUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DDWizardUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DDWizardUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField NameField;
    private javax.swing.JButton Submit;
    private javax.swing.JLabel VarNameLabel;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    // End of variables declaration//GEN-END:variables

    void setvisile(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
