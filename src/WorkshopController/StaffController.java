/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WorkshopController;

import Workshop.modules.Staff;
import Workshop.modules.StaffType;
import Workshop.utils.TableManager;
import WorkshopDbController.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pradip
 */
public class StaffController {
    Statement st=null;
    Connection con=null;
    
    public StaffController(){
        if(con==null){
            con=DbConnection.getConnection();
        }
    }
    public ResultSet doLogin(Staff staf) throws SQLException{
        ResultSet rs=null;
        String sql="select s.staff_type, sta.id, sta.fname, sta.lname from staff sta, staff_type s where sta.staff_type_id=s.id and sta.username='"+staf.getUsername()+"' and sta.password='"+staf.getPassword()+"'";
        st=con.createStatement();
        rs=st.executeQuery(sql);
        return rs;
        
    }
    
    public int insertStaffType(StaffType sta) throws SQLException{
        int done=0;
        String sql="insert into staff_type values(null, '"+sta.getStaffType()+"', "+sta.getDailyWage()+")";
        st=con.createStatement();
        done=st.executeUpdate(sql);
        return done;
    }
        
        public ResultSet getAllType() throws SQLException{
            ResultSet rs=null;
            String sql="Select * from staff_type";
            st=con.createStatement();
            rs=st.executeQuery(sql);
            return rs;
        
    }
        
        public int insertStaff(Staff sta) throws SQLException{
            int done=0;
            String sql="insert into staff values(null, '"+sta.getFname()+"', '"+sta.getLname()+"','"+sta.getUsername()+"', '"+sta.getPassword()+"', '"+sta.getAddress()+"',"+sta.getContact()+" ,"+sta.getStaffTypeId().getId()+")";
            st=con.createStatement();
            done=st.executeUpdate(sql);
            return done;
             }
        
        public ResultSet getStaff(StaffType staffs) throws SQLException{
            ResultSet rss;
            String sql="select s.id, s.fname, s.lname, s.address, s.contact, st.staff_type from staff s, staff_type st where s.staff_type_id=st.id and staff_type like'"+staffs.getStaffType()+'%'+"'";
            st=con.createStatement();
            rss=st.executeQuery(sql);
            return rss;
        }
        
        public DefaultTableModel buildStaffTable(StaffType sta) throws SQLException{
            DefaultTableModel data=TableManager.buildDataTable(getStaff(sta));
            return data;
        }
        
        public ResultSet getStaffs() throws SQLException{
            ResultSet rs=null;
            String query="select fname, lname from staff";
            st=con.createStatement();
            rs=st.executeQuery(query);
            return rs;
        }
        public int getId(Staff stt) throws SQLException{
            int id=0;
            ResultSet rs=null;
            String sql="select id from staff where fname='"+stt.getFname()+"' and lname='"+stt.getLname()+"'";
            st=con.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                id=rs.getInt(1);
            }
            return id;
        }
        
        public int countDays(Date start, Date end, int id) throws SQLException{
            int idd=0;
            ResultSet rs=null;
            String sql="select count(fs.id) as 'count' from staff fs, attendence a where a.staff_id=fs.id and a.date between('"+new java.sql.Date(start.getTime())+"')and ('"+new java.sql.Date(end.getTime())+"') and a.status='present' and fs.id="+id+"";
            st=con.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                idd=rs.getInt(1);
            }
            System.out.println(start);
            System.out.println(start);
             System.out.println(id);       
            System.out.println(idd);
            return idd;
        }
        
        public ResultSet getTypeDetails(Staff staf) throws SQLException{
           ResultSet rss=null;
           String sql="select stt.staff_type, stt.daily_wage from staff_type stt, staff sta where stt.id=sta.staff_type_id and sta.id="+staf.getId()+"";
       st=con.createStatement();
       rss=st.executeQuery(sql);
       return rss;
        }
        
         public ResultSet getStaffs(Staff staffs) throws SQLException{
            ResultSet rss;
            String sql="select s.id, s.fname, s.lname, s.address, st.staff_type from staff s, staff_type st where st.id=s.staff_type_id and  s.fname like'"+staffs.getFname()+'%'+"'";
            st=con.createStatement();
            rss=st.executeQuery(sql);
            return rss;
        }

    public int deleteStaff(Staff stt) throws SQLException {
     int done=0;
     String sql="delete from staff where id="+stt.getId()+"";
     st=con.createStatement();
     done=st.executeUpdate(sql);
     return done;
    }

    public int updateStaff(Staff staff) throws SQLException {
        int done=0;
        String sql="update staff set fname='"+staff.getFname()+"', lname='"+staff.getLname()+"', address='"+staff.getAddress()+"', contact="+staff.getContact()+", staff_type_id="+staff.getStaffTypeId().getId()+"";
        st=con.createStatement();
        done=st.executeUpdate(sql);
        return done;
    }
        
}

