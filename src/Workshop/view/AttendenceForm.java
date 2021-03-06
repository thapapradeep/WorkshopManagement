/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Workshop.view;

import Workshop.modules.Attendence;
import Workshop.modules.Staff;
import WorkshopController.AttendenceController;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;

/**
 *
 * @author Pradip
 */
public class AttendenceForm extends javax.swing.JPanel {

    /**
     * Creates new form AttendenceForm
     */
    String date=null;
    public AttendenceForm() throws SQLException {
        initComponents();
        Calendar cal=Calendar.getInstance();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        
        date=sdf.format(cal.getTime());
        lbl.setText("Date:"+date);
        loadTable();
    }
    
    public void loadTable() throws SQLException{
        AttendenceController ac=new AttendenceController();
        tbl_staff.setModel(ac.buildAttendenceTable());
      
        
       
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_staff = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        lbl.setText("Date");

        jLabel2.setText("Select The Employee and do the Attendence");

        jButton1.setText("Present");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Absent");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tbl_staff.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbl_staff);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("CarGiant Attendence System");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(95, 95, 95)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl)
                            .addComponent(jLabel1))
                        .addGap(39, 39, 39)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(tbl_staff.getSelectedRow()!=-1){
            try {
                int memid=tbl_staff.getSelectedRow();
                int id=(Integer) tbl_staff.getValueAt(memid, 0);
                String name=String.valueOf(tbl_staff.getValueAt(memid, 1));
                String status="present";
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                Date datee=sdf.parse(this.date);
                Attendence ac=new Attendence();
                ac.setDate(datee);
                ac.setStatus(status);
                Staff st=new Staff();
                st.setId(id);
                ac.setStaffId(st);
                
                AttendenceController acc=new AttendenceController();
                int done=acc.doAttendence(ac);
                if(done!=0){
                    JOptionPane.showMessageDialog(null, name+" is "+status);
                    
                }
                
            } catch (ParseException ex) {
                Logger.getLogger(AttendenceForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(AttendenceForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            // TODO add your handling code here:
            int memid=tbl_staff.getSelectedRow();
            int id=(Integer) tbl_staff.getValueAt(memid, 0);
            String name=String.valueOf(tbl_staff.getValueAt(memid, 1));
            String status="absent";
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Date datee=sdf.parse(this.date);
            Attendence ac=new Attendence();
            ac.setDate(datee);
            ac.setStatus(status);
            Staff st=new Staff();
            st.setId(id);
            ac.setStaffId(st);
            
            AttendenceController acc=new AttendenceController();
            int done=acc.doAttendence(ac
            );
            if(done!=0){
                JOptionPane.showMessageDialog(null, name+" is "+status);
                
            }
        } catch (ParseException ex) {
            Logger.getLogger(AttendenceForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AttendenceForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl;
    private javax.swing.JTable tbl_staff;
    // End of variables declaration//GEN-END:variables
}
