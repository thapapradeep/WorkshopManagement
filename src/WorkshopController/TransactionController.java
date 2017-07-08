/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WorkshopController;

import Workshop.modules.Transaction;
import WorkshopDbController.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Pradip
 */
public class TransactionController {
    Statement st=null;
    Connection con=null;
    
    public TransactionController(){
        if(con==null){
            con=DbConnection.getConnection();
        }
    }
    
    public int doEntry(Transaction t) throws SQLException{
     int done=0;
     String sql="insert into transaction values(null,'"+new java.sql.Date(t.getDate().getTime())+"', '"+t.getType()+"', "+t.getTypeId()+", "+t.getAmount()+", '"+t.getStatus()+"')";
     st=con.createStatement();
     done=st.executeUpdate(sql);
     return done;
    }
    
    public ResultSet getSupplierTrans(int month) throws SQLException{
        String sql="SELECT * FROM `transaction` WHERE type='supplier' and month(date)="+month+" and status='paid'";
        st=con.createStatement();
      ResultSet done=st.executeQuery(sql);
      return done;
    }
     public ResultSet getStaffTrans(int month) throws SQLException{
        String sql="SELECT * FROM `transaction` WHERE type='staff' and month(date)="+month+" and status='paid'";
        st=con.createStatement();
      ResultSet done=st.executeQuery(sql);
      return done;
    }
     
      public ResultSet getCusTrans(int month) throws SQLException{
        String sql="SELECT * FROM `transaction` WHERE type='customer' and month(date)="+month+" and status='received'";
        st=con.createStatement();
        ResultSet done=st.executeQuery(sql);
        return done;
    }
}
