/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Workshop.view;

import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author Pradip
 */
public class staffMgmnt extends javax.swing.JPanel {

    /**
     * Creates new form staffMgmnt
     */int var=0;
    public staffMgmnt(int var) throws SQLException,ClassNotFoundException, ParseException {
        initComponents();
        this.var=var;
        if(var==1){
          tab.add(new searchStaff(var), "Search Staff"); 
          tab.add(new AttendenceForm(), "Attendence");
        }
        else if(var==2){
        tab.add(new createStaffType(), "Add Staff Type");
        tab.add(new create_staff(), "Create Staff");
        tab.add(new AttendenceForm(), "Attendence") ;
        tab.add(new searchStaff(var), "Search Staff");
        }
        else if(var==3){
       tab.add(new salaryStatement(), "Prepare Salary Statement");
       tab.add(new searchStaff(var), "Search Staff");  
        }
        else if(var==4){
        tab.add(new salaryStatement(), "Prepare Salary Statement");
       tab.add(new searchStaff(var), "Search Staff");  
        }
        else{
            JOptionPane.showMessageDialog(null, "Something went wrong");
        }
       
        this.validate();
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

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Staff Management", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane tab;
    // End of variables declaration//GEN-END:variables
}
