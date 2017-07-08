/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WorkshopController;

import Workshop.modules.CarPart;
import Workshop.modules.Customer;
import Workshop.modules.CustomerCar;
import Workshop.modules.Services;
import Workshop.modules.StaffType;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pradip
 */
public class OtherControllerTest {
    
    public OtherControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllServices method, of class OtherController.
     */
  

    /**
     * Test of getType method, of class OtherController.
     */
  

    /**
     * Test of getId method, of class OtherController.
     */
   

    /**
     * Test of insertPurchase method, of class OtherController.
     */
    @Test
    public void testInsertPurchase() throws Exception {
        System.out.println("insertPurchase");
        CustomerCar cusc = new CustomerCar();
        CarPart car=new CarPart();
        car.setId(3);
        cusc.setCarId(car);
        Customer c=new Customer();
        c.setId(7);
        cusc.setCustomerId(c);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date=sdf.parse("2017-02-06");
        cusc.setDate(date);
        OtherController instance = new OtherController();
        int expResult = 1;
        int result = instance.insertPurchase(cusc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
