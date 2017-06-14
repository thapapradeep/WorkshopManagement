/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WorkshopDbController;

import static java.lang.Class.forName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pradip
 */
public class DbConnection {
   static Statement st=null;
    static Connection con=null;
    
    public static Connection getConnection(){
        if(con==null){
          connect();
        }
        return con;
    }
    
    private static void connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("connected");
        } catch (ClassNotFoundException ex) {
            System.out.println("not connected");
        }
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/workshop", "root", "");
            System.out.println("loaded");
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("not loaded");
        }
        
    }
    
}
