/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Workshop.view;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Pradip
 */
public class SupplierManagement extends javax.swing.JPanel {

    /**
     * Creates new form SupplierManagement
     */
    
    public SupplierManagement(int var) throws SQLException {
        initComponents();
        if(var==2){
         tab.add(new CreateSupplier(), "Create Supplier");
        tab.add(new supplierTransaction(), "Pay to Supplier");  
        }
        else if(var==4){
            tab.add(new supplierTransaction(), "Pay to Supplier");
        }
        else{
            JOptionPane.showMessageDialog(null, "Something went wrong");
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tab = new javax.swing.JTabbedPane();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tab, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tab, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane tab;
    // End of variables declaration//GEN-END:variables
}
