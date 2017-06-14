/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WorkshopController;

import Workshop.modules.Supplier;
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
public class SupplierController {
    Statement st=null;
    Connection con=null;
    
    public SupplierController(){
    if(con==null){
        con=DbConnection.getConnection();
    }
}
    
    public int insertSupplier(Supplier sp) throws SQLException{
        int done=0;
        String sql="insert into supplier values(null, '"+sp.getName()+"', '"+sp.getAddress()+"', "+sp.getContact()+")";
        st=con.createStatement();
        done=st.executeUpdate(sql);
        return done;
        
    }
    
    public ResultSet getSupplier() throws SQLException{
      ResultSet rs=null;
      String sql="select name from supplier";
      st=con.createStatement();
      rs=st.executeQuery(sql);
      return rs;
    }
    
    public int getId(Supplier sp) throws SQLException{
        ResultSet rs=null;
        int id=0;
        String sql="select id from supplier where name='"+sp.getName()+"'";
        st=con.createStatement();
        rs=st.executeQuery(sql);
        while(rs.next()){
            id=rs.getInt(1);
        }
        return id;
    }

    public DefaultTableModel buildSupplierTable(Supplier supp) throws SQLException {
        DefaultTableModel data=TableManager.buildDataTable(getSupplierDetails(supp));
        return data;
    }

    private ResultSet getSupplierDetails(Supplier supp) throws SQLException {
       ResultSet rs=null;
       String sql="select c. id, c.name , c.available_unit, c.price, s.name from car_part c, supplier s where c.supplier_id=s.id and s.name='"+supp.getName()+"'";
       st=con.createStatement();
       rs=st.executeQuery(sql);
       return rs;
       
    }
}
