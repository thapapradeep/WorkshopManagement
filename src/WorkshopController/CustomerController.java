/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WorkshopController;

import Workshop.modules.Customer;
import Workshop.utils.TableManager;
import WorkshopDbController.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Pradip
 */
public class CustomerController {
    Connection con=null;
    Statement st=null;
    
    public CustomerController(){
        if(con==null){
            con=DbConnection.getConnection();
        }
    }
    
    public int doInsert(Customer cs) throws SQLException{
       int done=0;
        System.out.println(cs.getServiceId().getId());
        System.out.println(cs.getStaffId().getId());
       String sql="insert into customer values(null, '"+cs.getFname()+"', '"+cs.getLname()+"', '"+cs.getAddress()+"', "+cs.getContact()+", "+cs.getStaffId().getId()+", "+cs.getServiceId().getId()+")";
       st=con.createStatement();
       done=st.executeUpdate(sql);
       return done;
    }
    
    public ResultSet getCustomers() throws SQLException{
        ResultSet rs=null;
        String query="select c.fname, c.lname , s.name from customer c, services s where c.service_id=s.id and s.name in ('repair', 'purchase')";
        st=con.createStatement();
        rs=st.executeQuery(query);
        return rs;
        
        
    }

    public int getCustomerId(Customer cs) throws SQLException {
        int id=0;
        ResultSet rs=null;
        String sql="select id from customer where fname='"+cs.getFname()+"' and lname='"+cs.getLname()+"'";
        st=con.createStatement();
        rs=st.executeQuery(sql);
        while(rs.next()){
            id=rs.getInt("id");
        }
        return id;
    }
    
    public ResultSet fetchRecord(Customer cus) throws SQLException{
       ResultSet rs=null;
       String sql="select id, fname, lname, address,contact from customer where fname like '"+cus.getFname()+'%'+"'";
       st=con.createStatement();
       rs=st.executeQuery(sql);
       return rs;
    }

    public DefaultTableModel buildCustomerTable(Customer cus) throws SQLException {
        DefaultTableModel data=TableManager.buildDataTable(fetchRecord(cus));
        return data;
    }

    public int deleteCustomer(Customer cus) throws SQLException {
        int done=0;
        String sql="delete from customer where id="+cus.getId()+"";
        st=con.createStatement();
        done=st.executeUpdate(sql);
        return done;
    }

    public int updateCustomer(Customer cs) throws SQLException {
    int done=0;
    String sql="update customer set fname='"+cs.getFname()+"' ,lname='"+cs.getLname()+"' , address='"+cs.getAddress()+"' ,contact="+cs.getContact()+" where id="+cs.getId()+" ";
    st=con.createStatement();
    done=st.executeUpdate(sql);
    return done;
    }
    
}
