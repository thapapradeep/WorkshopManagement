/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WorkshopController;

import Workshop.modules.Customer;
import Workshop.modules.Services;
import Workshop.modules.Staff;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
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
public class Customer_insert {
    
    public Customer_insert() {
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
     * Test of doInsert method, of class CustomerController.
     */
    @Test
    public void testDoInsert() throws Exception {
        System.out.println("doInsert");
        Customer cs = new Customer();
        Staff s=new Staff();
        s.setId(1);
        Services sc=new Services();
        sc.setId(1);
        cs.setFname("Durga");
        cs.setLname("Ips");
        cs.setAddress("Dadehdhura");
        cs.setContact(6736342);
        cs.setServiceId(sc);
        cs.setStaffId(s);
        CustomerController instance = new CustomerController();
        int expResult = 1;
        int result = instance.doInsert(cs);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
}

    