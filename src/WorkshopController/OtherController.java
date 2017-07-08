/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WorkshopController;

import Workshop.modules.CustomerCar;
import Workshop.modules.Services;
import Workshop.modules.StaffType;
import WorkshopDbController.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Pradip
 */
public class OtherController {
    Connection con=null;
    Statement st=null;
    
    public OtherController(){
        if(con==null){
         con=DbConnection.getConnection();
        }
    }
    
        public ResultSet getAllServices() throws SQLException{
         ResultSet rs=null;
         String sql="select * from services";
         st=con.createStatement();
         rs=st.executeQuery(sql);
        return rs;
    }
        
        public int getType(StaffType sta) throws SQLException{
            int idd=0;
            String sql="Select id from Staff_type where staff_type='"+sta.getStaffType()+"'";
            st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                idd=rs.getInt(1);
            }
            return idd;
        }

    public int getId(Services ser) throws SQLException {
       ResultSet rs=null;
             int  idd=0;
       String sql="select id from services where name='"+ser.getName()+"'";
       st=con.createStatement();
      rs=st.executeQuery(sql);
      while(rs.next()){
          idd=rs.getInt(1);
      }
      return idd;
       
    
}

    public int insertPurchase(CustomerCar cusc) throws SQLException {
        int done = 0;
        String sql = "insert into customer_car values(null, " + cusc.getCarId().getId() + ", " + cusc.getCustomerId().getId() + ",'" + new java.sql.Date(cusc.getDate().getTime()) + "')";
        st = con.createStatement();
        done = st.executeUpdate(sql);
        return done;

    }
}
