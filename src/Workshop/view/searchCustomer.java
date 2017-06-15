/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Workshop.view;

import Workshop.modules.Customer;
import Workshop.utils.TableManager;
import WorkshopController.CarController;
import WorkshopController.CustomerController;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Pradip
 */
public class searchCustomer extends javax.swing.JPanel {

    /**
     * Creates new form searchCustomer
     */
    int id=0;
    public searchCustomer(int var) {
        initComponents();
        if(var==2 || var==3){
            up.setVisible(true);
            del.setVisible(true);
        }
        else{
         up.setVisible(false);
            del.setVisible(false);   
        }
        lbl1.setVisible(false);
        txt_fname.setVisible(false);
        header.setVisible(false);
        lname.setVisible(false);
        txt_lname.setVisible(false);
        add.setVisible(false);
        txt_address.setVisible(false);
        con.setVisible(false);
        txtContact.setVisible(false);
        btn_update.setVisible(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_customer = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        up = new javax.swing.JButton();
        del = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_details = new javax.swing.JTable();
        lbl1 = new javax.swing.JLabel();
        lname = new javax.swing.JLabel();
        txt_fname = new javax.swing.JTextField();
        header = new javax.swing.JLabel();
        txt_lname = new javax.swing.JTextField();
        add = new javax.swing.JLabel();
        con = new javax.swing.JLabel();
        txt_address = new javax.swing.JTextField();
        txtContact = new javax.swing.JTextField();
        btn_update = new javax.swing.JButton();

        jLabel1.setText("Enter Customer Name");

        txt_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nameKeyPressed(evt);
            }
        });

        tbl_customer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbl_customer);

        jLabel2.setText("Detaiils of customer");

        up.setText("Update");
        up.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upActionPerformed(evt);
            }
        });

        del.setText("Delete");
        del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delActionPerformed(evt);
            }
        });

        jButton3.setText("Refresh");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("View Purchase Details");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel3.setText("Details of transactions done by this customer");

        tbl_details.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Service", "Type", "Date", "Name"
            }
        ));
        jScrollPane2.setViewportView(tbl_details);

        lbl1.setText("First  Name");

        lname.setText("Last Name");

        header.setText("Update The details of customer");

        add.setText("Address");

        con.setText("Contact");

        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(con, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(72, 72, 72)
                                        .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton4)
                                        .addGap(92, 92, 92)
                                        .addComponent(jButton3)
                                        .addGap(67, 67, 67)
                                        .addComponent(up)
                                        .addGap(35, 35, 35)
                                        .addComponent(del))
                                    .addComponent(header)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lbl1)
                                                .addGap(69, 69, 69)
                                                .addComponent(txt_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lname)
                                                    .addComponent(add))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txt_lname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txt_address, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtContact, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(64, 64, 64)
                                        .addComponent(btn_update)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton3)
                    .addComponent(up)
                    .addComponent(del))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(header)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl1)
                            .addComponent(txt_fname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_lname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lname)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btn_update)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(con, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nameKeyPressed
        try {
            // TODO add your handling code here:
            String name=txt_name.getText();
            Customer cus=new Customer();
            cus.setFname(name);
            CustomerController custom=new CustomerController();
            tbl_customer.setModel(custom.buildCustomerTable(cus));
        } catch (SQLException ex) {
            Logger.getLogger(searchCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txt_nameKeyPressed

    private void delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delActionPerformed
        // TODO add your handling code here:
        if(tbl_customer.getSelectedRow()!=-1){
            try {
                int  memId=tbl_customer.getSelectedRow();
                int id=(Integer) tbl_customer.getValueAt(memId, 0);
                Customer cus=new Customer();
                cus.setId(id);
                CustomerController custom=new CustomerController();
                int del=custom.deleteCustomer(cus);
                if(del!=0){
                    JOptionPane.showMessageDialog(null, "Selected Customer has been Deleted. Please refresh the table");
                }
            } catch (SQLException ex) {
                Logger.getLogger(searchCustomer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_delActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            // TODO add your handling code here:
            String name=txt_name.getText();
            Customer cus=new Customer();
            cus.setFname(name);
            CustomerController custom=new CustomerController();
            tbl_customer.setModel(custom.buildCustomerTable(cus));
        } catch (SQLException ex) {
            Logger.getLogger(searchCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if(tbl_customer.getSelectedRow()!=-1){
            try {
                int  memId=tbl_customer.getSelectedRow();
                int id=(Integer) tbl_customer.getValueAt(memId, 0);
                Customer cust=new Customer();
                cust.setId(id);
                CarController car=new CarController();
                ResultSet rs=car.getCarDetails(cust);
                tbl_details.setModel(TableManager.buildDataTable(rs));
            } catch (SQLException ex) {
                Logger.getLogger(searchCustomer.class.getName()).log(Level.SEVERE, null, ex);
            }
              
          
                
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void upActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upActionPerformed
        // TODO add your handling code here:
        if(tbl_customer.getSelectedRow()!=-1){
            lbl1.setVisible(true);
            txt_fname.setVisible(true);
            header.setVisible(true);
            lname.setVisible(true);
            txt_lname.setVisible(true);
            add.setVisible(true);
            txt_address.setVisible(true);
            con.setVisible(true);
            txtContact.setVisible(true);
            btn_update.setVisible(true);
            int memId=tbl_customer.getSelectedRow();
            int idd=(Integer) tbl_customer.getValueAt(memId, 0);
            this.id=idd;
            String fname=String.valueOf(tbl_customer.getValueAt(memId, 1));
            String lname1=String.valueOf(tbl_customer.getValueAt(memId, 2));
            String address=String.valueOf(tbl_customer.getValueAt(memId, 3));
            int contact=(Integer)tbl_customer.getValueAt(memId, 4);
            txt_fname.setText(fname);
            txt_lname.setText(lname1);
            txt_address.setText(address);
            txtContact.setText(String.valueOf(contact));
            int conn=Integer.parseInt(txtContact.getText());
        }
    }//GEN-LAST:event_upActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        try {
            // TODO add your handling code here:
            
            
            
            String first=txt_fname.getText();
            String last=txt_lname.getText();
            String addr=txt_address.getText();
            int conn=Integer.parseInt(txtContact.getText());
            
            Customer cs=new Customer();
            cs.setFname(first);
            cs.setLname(last);
            cs.setAddress(addr);
            cs.setContact(conn);
            cs.setId(id);
            
            CustomerController css=new CustomerController();
           
           
               int done = css.updateCustomer(cs);
               if(done!=0){
                JOptionPane.showMessageDialog(null, "Sucessfully Updated");
                txtContact.setText("");
                txt_address.setText("");
                txt_lname.setText("");
                txt_fname.setText("");
               }
               else{
                  JOptionPane.showMessageDialog(null, " Something went Wrong"); 
               }
            } catch (SQLException ex) {
                Logger.getLogger(searchCustomer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
    }//GEN-LAST:event_btn_updateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel add;
    private javax.swing.JButton btn_update;
    private javax.swing.JLabel con;
    private javax.swing.JButton del;
    private javax.swing.JLabel header;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lname;
    private javax.swing.JTable tbl_customer;
    private javax.swing.JTable tbl_details;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txt_address;
    private javax.swing.JTextField txt_fname;
    private javax.swing.JTextField txt_lname;
    private javax.swing.JTextField txt_name;
    private javax.swing.JButton up;
    // End of variables declaration//GEN-END:variables
}
