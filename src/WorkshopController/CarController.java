/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WorkshopController;

import Workshop.modules.CarModel;
import Workshop.modules.CarPart;
import Workshop.modules.Customer;
import Workshop.modules.CustomerCar;
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
public class CarController {
    Connection con=null;
    Statement st=null;
    
    public CarController(){
        if(con==null){
            con=DbConnection.getConnection();
        }
    }
    
    public int insertCar(CarPart cp) throws SQLException{
        int done=0;
        String sql="insert into car_part values(null, '"+cp.getName()+"', '"+cp.getType()+"', "+cp.getPrice()+", "+cp.getAvailableUnit()+", "+cp.getModelId().getId()+","+cp.getSupplierId().getId()+")";
        st=con.createStatement();
        done=st.executeUpdate(sql);
        return done;
        
    }
    
    public int insertModel(CarModel car) throws SQLException{
        int done=0;
        String sql="insert into car_model values(null,'"+car.getModel()+"')";
        st=con.createStatement();
        done=st.executeUpdate(sql);
        return done;
        
    }
    
    public ResultSet getModel() throws SQLException{
        ResultSet rs=null;
        String sql="select model from car_model";
        st=con.createStatement();
        rs=st.executeQuery(sql);
        return rs;
    }
    
    public int getModelId(CarModel mo) throws SQLException{
         ResultSet rs=null;
        int id=0;
        String sql="select id from car_model where model='"+mo.getModel()+"'";
        st=con.createStatement();
        rs=st.executeQuery(sql);
        while(rs.next()){
            id=rs.getInt(1);
        }
        return id;
    }
    
    public ResultSet getCarDetails(CarPart car) throws SQLException{
        ResultSet rss=null;
        String sql="select c.id, c.name, c.price, c.available_unit, c.type from car_part c, car_model cm where c.model_id=cm.id and type='"+car.getType()+"' and model='"+car.getModelId().getModel()+"'";
        st=con.createStatement();
        rss=st.executeQuery(sql);
        return rss;
        
    }
    
    public DefaultTableModel buildCarTable(CarPart car) throws SQLException{
       DefaultTableModel data=TableManager.buildDataTable(getCarDetails(car));
       return data;
    }

    public ResultSet getPrice(CustomerCar css) throws SQLException {
        ResultSet rss=null;
        String sql="select c.name, c.type, c.price from car_part c, customer ci, customer_car co where c.id=co.car_id and co.customer_id=ci.id and ci.id="+css.getCustomerId().getId()+" and co.date='"+new java.sql.Date(css.getDate().getTime())+"'";
        st=con.createStatement();
        rss=st.executeQuery(sql);
        return rss;
    }

    public ResultSet getCarDetails(Customer cus) throws SQLException {
        ResultSet rs=null;
        String sql="SELECT s.name, ca.name,ca.price,car.date from customer c, services s, car_part ca, customer_car car where s.id=c.service_id and c.id=car.customer_id and ca.id=car.car_id and c.id="+cus.getId()+"";
        st=con.createStatement();
        rs=st.executeQuery(sql);
        return rs;
    }

    public ResultSet getAllCar(int index, String name) throws SQLException {
        ResultSet rs=null;
        String sql=null;
        if(index==0){
            CarModel car=new CarModel();
            car.setModel(name);
            sql="select c.id, c.name, c.type, c.available_unit,c.price, m.model from car_part c, car_model m where m.id=c.model_id and m.model like '"+car.getModel()+'%'+"'";
        }
        else if(index==1){
            CarPart cc=new CarPart();
            cc.setName(name);
            sql="select c.id, c.name, c.type, c.available_unit,c.price, m.model from car_part c, car_model m where m.id=c.model_id and c.name like '"+cc.getName()+'%'+"'";
            
        }
        st=con.createStatement();
        rs=st.executeQuery(sql);
        return rs;
    }

    public int updateCar(CarPart cp) throws SQLException {
      int done=0;
      String sql="update car_part set name='"+cp.getName()+"', available_unit="+cp.getAvailableUnit()+", price="+cp.getPrice()+" where id="+cp.getId()+"";
      st=con.createStatement();
      done=st.executeUpdate(sql);
      return done;
    }

    public int deleteCar(CarPart cpp) throws SQLException {
     int done=0;
     String sql="delete from car_part where id="+cpp.getId()+"";
     st=con.createStatement();
     done=st.executeUpdate(sql);
     return done;
    }
}

