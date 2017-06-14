/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WorkshopController;

import Workshop.modules.Attendence;
import Workshop.modules.Staff;
import Workshop.utils.TableManager;
import WorkshopDbController.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pradip
 */
public class AttendenceController {
    Connection con=null;
    Statement st=null;
    
    public AttendenceController(){
        if(con==null){
            con=DbConnection.getConnection();
            
        }
    }
    
    public int doAttendence(Attendence at) throws SQLException{
        int done=0;
        String sql="insert into attendence values(null, '"+new java.sql.Date(at.getDate().getTime())+"', '"+at.getStatus()+"', "+at.getStaffId().getId()+")";
        st=con.createStatement();
        done=st.executeUpdate(sql);
        return done;
        
    }
    public ResultSet getAllStaffs() throws SQLException{
        String sql="Select s.id, s.fname, s.lname, st.staff_type from staff s, staff_type st where st.id=s.staff_type_id"; 
       st=con.createStatement();
        ResultSet rs=st.executeQuery(sql);
        return rs;
    }
    
    public DefaultTableModel buildAttendenceTable() throws SQLException{
        DefaultTableModel data=TableManager.buildDataTable(getAllStaffs());
        return data;
        
    }
    
    public ResultSet getAttendence(Staff att) throws SQLException{
        ResultSet rs=null;
        String sql="select  a.date, a.status from attendence a, staff s where s.id=a.staff_id and s.id="+att.getId()+"";
        st=con.createStatement();
        rs=st.executeQuery(sql);
        return rs;
    }
    
    
}
